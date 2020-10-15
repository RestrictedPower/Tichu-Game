package me.RestrictedPower.TichuServer.Controller;

import java.awt.EventQueue;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import me.RestrictedPower.TichuServer.Util;
import me.RestrictedPower.TichuServer.Model.Card;
import me.RestrictedPower.TichuServer.Model.Deck;
import me.RestrictedPower.TichuServer.Model.Player;
import me.RestrictedPower.TichuServer.View.MainView;

public class Main {
	public static GameState state;
	public static Deck deck;
	public static ArrayList<Player> players = new ArrayList<Player>();
	public static final int PORT = 8901;
	private static MainView view;
	private static ServerSocket socket;
	private static int skippedGrandState;
	private static int sentCards;
	public static void messageRecieveEvent(Player p, String message) {
		if (message.startsWith("NAMEANSWER")) {
			String[] args = message.split(":");
			String check = nameCheck(args[1]);
			if(check!=null) {
				p.sendMessage("KICKED:"+check);
				p.closeConnection();
				players.remove(players.size()-1);
				addLog("Another player tried to connect with name "+args[1]+" therefore he was kicked.");
				return;
			}
			p.setPName(args[1]);
			addLog(args[1] + " connected!");
			p.sendMessage("CONNECTED");
			view.updateName(players.size()-1, args[1]);
			for (Player v : players) v.sendMessage("PLAYERJOIN:" + players.size());
			return;
		}
		if (message.equalsIgnoreCase("GRAND")||(message.equalsIgnoreCase("FOLD") && state == GameState.GRAND_PHASE)) {
			if(message.equalsIgnoreCase("GRAND")) {
				for(Player v : players) v.sendMessage("SAIDGRAND:"+p.getPlayerName());
				p.setPressedGrand(true);
			}else for(Player v : players) v.sendMessage("PASSEDGRAND:"+p.getPlayerName());
			sendCards(p,6);
			if(++skippedGrandState==4) startExchangePhase();
			return;
		}
		
		if (message.startsWith("SUBMITEXCHANGE")) {
			p.setCardExchange(message);
			if(++sentCards==4) exchangeCompleted();
			return;
		}
	}
	public static void exchangeCompleted() {
		state = GameState.PLAYING_PHASE;
		String[] cardMessages = new String[4];
		for(int i = 0; i<4; i++) cardMessages[i] = "EXCHANGECOMPLETE";
		for(int i = 0; i<4; i++) {
			for(int j = 0; j<3; j++) players.get(i).removeCard(Card.getByID(Integer.parseInt(players.get(i).getCardExchange(j))));
			Player bef = players.get((i+3)%4), team = players.get((i+2)%4), aft = players.get((i+1)%4);
			cardMessages[i]+=":"+bef.getCardExchange(2);
			cardMessages[i]+=":"+team.getCardExchange(1);
			cardMessages[i]+=":"+aft.getCardExchange(0);
		}
		for(int i = 0; i<4; i++) {
			players.get(i).sendMessage(cardMessages[i]);
			for(int j = 0; j<3; j++) players.get(i).addCard(Card.getByID(Integer.parseInt(cardMessages[i].split(":")[j+1])));
		}
		int startingIdx = 0;
		while(!players.get(startingIdx).hasCard(Card.MAHJONG)) startingIdx++;
		for(Player p : players) p.sendMessage("CURRENTTURN:"+players.get(startingIdx).getPlayerName());
		
	}
	//complete code below
	public static void startExchangePhase() {
		state = GameState.EXCHANGE_PHASE;
		for(Player v : players) v.sendMessage("EXCHANGE");
		sentCards = 0;
	}
	public static void main(String[] args) {
		view = new MainView();
		try {
			state = GameState.WAITING_FOR_PLAYERS;
			createConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void createConnection() throws IOException {
		socket = new ServerSocket(PORT);
		addLog("Server generated!");
		addLog("IP: " + Util.getIp());
		while (state == GameState.WAITING_FOR_PLAYERS) {
			Socket s = socket.accept();
			players.add(new Player(s));
			players.get(players.size() - 1).sendMessage("NAMEREQUEST");
			players.get(players.size() - 1).start();
		}
	}

	public static void startGrandPhase() {
		state = GameState.GRAND_PHASE;
		skippedGrandState = 0;
		ArrayList<Player> team1 = new ArrayList<Player>(), team2 = new ArrayList<Player>();
		for(int i = 0; i<4; i++) if(view.firstTeam(i)) team1.add(players.get(i)); else team2.add(players.get(i));
		players.clear();
		players.add(team1.get(0));
		players.add(team2.get(0));
		players.add(team1.get(1));
		players.add(team2.get(1));
		deck = new Deck();
		for (Player v : players) v.sendMessage("STARTGAME:"+players.get(0).getPlayerName()+":"+players.get(1).getPlayerName()+":"+players.get(2).getPlayerName()+":"+players.get(3).getPlayerName());
		for (Player v : players) sendCards(v,8);
	}
	
	public static void sendCards(Player p, int number) {
		String cardsToGive = "PULLCARDS";
		for(int i = 0; i<number; i++) {
			Card c = deck.pullCard();
			p.addCard(c);
			cardsToGive+=":"+c.id;
		}
		p.sendMessage(cardsToGive);
	}
	public static void startPress() {
		if(players.size()!=4) {
			addLog("Please wait for all players to join!");
			return;
		}
		int cnt = 0;
		for(int i = 0; i<4; i++) cnt+=view.firstTeam(i)?1:-1;
		if(cnt!=0) {
			addLog("Please set up the teams correctly!");
			return;
		}
		startGrandPhase();
	}
	
	private static String nameCheck(String s) {
		if(s.indexOf(':')!=-1) return "Names can not contain ':' because it is a special character!";
		if(s.length()>16) return "Names can not be more than 16 characters!";
		for(int i = 0; i<players.size()-1; i++) if(players.get(i).getPlayerName().equalsIgnoreCase(s)) return "Name already connected to the server!";
		return null;
	}
	
	public static void addLog(String s) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view.addLog(s);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
