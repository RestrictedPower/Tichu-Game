package me.RestrictedPower.TichuServer.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import me.RestrictedPower.TichuServer.Controller.Main;

public class Player extends Thread{
	private ArrayList<Card> cards = new ArrayList<Card>();
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private String name,cardExchange;
	private boolean grand,tichu;
	private boolean outOfGame;
	public Player(Socket s) {
		try {
			socket = s;
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			setOut(false);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
    public void run() {
        try {
            while (true) {
            	if(socket.isClosed()) return;
                String msg = in.readLine();
                if(msg!=null) Main.messageRecieveEvent(this, msg);
            }
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }
	public void sendMessage(String message) {
		out.println(message);
	}
	public String getPlayerName() {
		return this.name;
	}
	public void setPName(String name) {
		this.name = name;
	}
	public void closeConnection() {
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public boolean hasCard(Card c) {
		return cards.contains(c);
	}
	public void addCard(Card c) {
		cards.add(c);
	}
	public void removeCard(Card c) {
		if(!cards.contains(c)) return;
		cards.remove(c);
	}
	public boolean pressedGrand() {
		return grand;
	}
	public void setPressedGrand(boolean grand) {
		this.grand = grand;
	}
	public boolean pressedTichu() {
		return tichu;
	}
	public void setPressedTichu(boolean tichu) {
		this.tichu = tichu;
	}
	public String getCardExchange(int idx) {
		return cardExchange.split(":")[idx+1];
	}
	public void setCardExchange(String cardExchange) {
		this.cardExchange = cardExchange;
	}
	public boolean isOut() {
		return outOfGame;
	}
	public void setOut(boolean outOfGame) {
		this.outOfGame = outOfGame;
	}
}
