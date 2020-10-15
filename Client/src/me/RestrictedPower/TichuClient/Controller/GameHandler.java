package me.RestrictedPower.TichuClient.Controller;

import java.net.Socket;

import me.RestrictedPower.TichuClient.Util;
import me.RestrictedPower.TichuClient.Model.Card;
import me.RestrictedPower.TichuClient.Model.Hand;
import me.RestrictedPower.TichuClient.View.ConnectView;
import me.RestrictedPower.TichuClient.View.ConnectedView;
import me.RestrictedPower.TichuClient.View.GameView;

public class GameHandler {
	private Connection connection;
	private MessageListener listener;
	private GameState state;
	private String playerName;
	private int playerIdx;
	private String[] playerNames = new String[4];
	private Hand hand;
	public GameHandler() {
		state = GameState.WAITING_TO_CONNECT;
		Main.view1 = new ConnectView();
		hand = new Hand();
	}
	public void attemptToConnect(String name, String ip) throws Exception {
		this.playerName = name;
		this.connection = new Connection(new Socket(ip, Main.PORT));
        listener = new MessageListener();
        listener.start();
	}
	public void messageRecieveEvent(String msg) {
		if(msg.startsWith("NAMEREQUEST")) nameRequest();
		else if(msg.startsWith("CONNECTED")) connected();
		else if(msg.startsWith("KICK")) kick(msg.split(":")[1]);
		else if(msg.startsWith("PLAYERJOIN")) playerJoin(Integer.parseInt(msg.split(":")[1]));
		else if(msg.startsWith("STARTGAME")) startGame(msg);
		else if(msg.startsWith("PULLCARDS")) pullCards(msg);
		else if(msg.startsWith("SAIDGRAND")) saidGrand(msg.split(":")[1]);
		else if(msg.startsWith("PASSEDGRAND")) passedGrand(msg.split(":")[1]);
		else if(msg.startsWith("EXCHANGECOMPLETE")) exchangeComplete(msg);
		else if(msg.startsWith("EXCHANGE")) exchangePhase();
		else if(msg.startsWith("CURRENTTURN")) changeTurn(msg.split(":")[1]);
	}
	
	private void changeTurn(String who) {
		int id = idxByName(who);
		Main.view3.showYourTurnLabel(id==-1);
		Main.view3.showPlayCardsButton(id==-1);
		Main.view3.showFoldButton(id==-1);
		if(id!=-1) for(int i = 0; i<3; i++) Main.view3.players[i].setPlayingNow(i==id);
	}
	/* done message recieve handle functions*/
	private void nameRequest() {
		sendServerMessage("NAMEANSWER:"+playerName);
	}
	
	private void connected() {
		state = GameState.CONNECTED;
		Main.view1.close();
		Main.view2 = new ConnectedView();
	}
	
	private void kick(String msg) {
		connection.close();
		Util.sendError("Connection error!", msg);
		listener.stop();
		listener = null;
	}
	
	private void playerJoin(int count) {
		Main.view2.updatePlayerCount(count);
	}
	
	private void startGame(String msg) {
		state = GameState.GRAND_PHASE;
		String[] args = msg.split(":");
		for(int i = 1; i<5; i++) { 
			playerNames[i-1] = args[i];
			if(args[i].equalsIgnoreCase(playerName)) playerIdx = i-1;
		}
		int prev = (playerIdx+3)%4, next = (playerIdx+1)%4, team = (playerIdx+2)%4;
		Main.view2.close();
		Main.view3 = new GameView(playerNames[prev],playerNames[next],playerNames[team]); 
		Main.view3.showGrandTichuButton(true);
		Main.view3.showFoldButton(true);
	}
	
	private void pullCards(String msg) {
		String[] a = msg.split(":");
		for(int i = 1; i<a.length; i++) hand.addCard(Card.getByID(Integer.parseInt(a[i])));
		Main.view3.drawCards(hand);
	}
	
	private void saidGrand(String who) {
		int idx = idxByName(who);
		if(idx==-1) {
			Main.view3.showGrandTichuButton(false);
			Main.view3.showFoldButton(false);
		} else {
			Main.view3.players[idx].saidGrand();
			Main.view3.players[idx].updateLeftCards(14);
		}
	}
	
	private void passedGrand(String who) {
		int idx = idxByName(who);
		if(idx==-1) {
			Main.view3.showGrandTichuButton(false);
			Main.view3.showFoldButton(false);
		}else Main.view3.players[idx].updateLeftCards(14);
	}
	
	private void exchangePhase() {
		state = GameState.EXCHANGE_PHASE;
		Main.view3.showExchange(true);
		Main.view3.showSendCards(true);
	}
	public void exchangeComplete(String msg) {
		String[] a = msg.split(":");
		for(int i = 1; i<a.length; i++) hand.addCard(Card.getByID(Integer.parseInt(a[i])));
		Main.view3.showExchange(false);
		Main.view3.drawCards(hand);
		state = GameState.PLAYING_PHASE;
	}
	public void grandPressEvent() {
		sendServerMessage("GRAND");
	}
	
	public void tichuPressEvent() {
		sendServerMessage("TICHU");
	}
	
	public void foldPressEvent() {
		sendServerMessage("FOLD");
	}
	
	public void playCardsEvent() {
		if(hand.getSelected().isEmpty()) {
			Util.sendError("No selected cards!", "Please select some crads to play.");
			return;
		}
		String request = "PLAYCARDS";
		for(Card c : hand.getSelected()) request += ":"+c.id;
		connection.sendMessage(request);
	}
	
	public void sendCardsEvent() {
		Card[] c = Main.view3.getExchangeCards();
		for(int i = 0; i<3; i++) if(c[i]==null) {
			Util.sendError("Error!", "Please select all three cards before sending them!");
			return;
		}
		String message = "SUBMITEXCHANGE:"+c[0].id+":"+c[1].id+":"+c[2].id;
		connection.sendMessage(message);
		Main.view3.exchanged();
		Main.view3.showSendCards(false);
	}
	
	public int idxByName(String name) {
		if(name.equalsIgnoreCase(playerNames[(playerIdx+3)%4])) return 0;
		if(name.equalsIgnoreCase(playerNames[(playerIdx+2)%4])) return 1;
		if(name.equalsIgnoreCase(playerNames[(playerIdx+1)%4])) return 2;
		return -1;
	}
	public void sendServerMessage(String msg) {
		connection.sendMessage(msg);
	}
	public Hand getHand() {
		return this.hand;
	}
	public GameState getState() {
		return this.state;
	}
	public void setState(GameState state) {
		this.state = state;
	}
	public void setConnection(Connection c) {
		this.connection = c;
	}
	public void setName(String name) {
		this.playerName = name;
	}
	public Connection getConnection() {
		return this.connection;
	}
}
