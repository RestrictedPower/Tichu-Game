package me.RestrictedPower.TichuClient.Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.JButton;

import me.RestrictedPower.TichuClient.Controller.GameState;
import me.RestrictedPower.TichuClient.Controller.Main;

public class Hand {
	private ArrayList<Card> cards = new ArrayList<Card>();
	private HashSet<Card> selected = new HashSet<Card>();
	private HashMap<Card, JButton> buttonMap = new HashMap<Card, JButton>();
	public Hand(ArrayList<Card> cards) {
		this.cards = cards;
		Collections.sort(this.cards);
		Collections.reverse(this.cards);
		for(Card c : cards) addCard(c);
	}
	public Hand() {
		this.cards = new ArrayList<Card>();
	}
	public ArrayList<Card> getCards() {
		return cards;
	}

	public boolean isSelected(Card c) {
		return selected.contains(c);
	}
	
	public void setSelected(Card c) {
		getButon(c).setLocation((int)getButon(c).getLocation().getX(), (int)getButon(c).getLocation().getY()-50);
		selected.add(c);
	}
	
	public void addCard(Card c) {
		cards.add(c);
		buttonMap.put(c, new JButton(c.image));
		JButton ci = getButon(c);
		ci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Main.gameHandler.getState() != GameState.EXCHANGE_PHASE && Main.gameHandler.getState() != GameState.PLAYING_PHASE) return;
				
				if(isSelected(c)) removeSelected(c);
				else {
					if(Main.gameHandler.getState() == GameState.EXCHANGE_PHASE)for(Card ca : selected) removeSelected(ca);
					setSelected(c);
				}
			}
		});
		Collections.sort(this.cards);
		Collections.reverse(this.cards);
	}
	public void removeSelected(Card c) {
		if(isSelected(c)) {
			selected.remove(c);
			getButon(c).setLocation((int)getButon(c).getLocation().getX(), (int)getButon(c).getLocation().getY()+50);
		}
	}
	public void removeCard(Card c) {
		if(!cards.contains(c)) return;
		removeSelected(c);
		buttonMap.remove(c);
		cards.remove(c);
	}
	public HashSet<Card> getSelected(){
		return selected;
	}
	public JButton getButon(Card c) {
		return buttonMap.get(c);
	}
	public int size() {
		return cards.size();
	}
}
