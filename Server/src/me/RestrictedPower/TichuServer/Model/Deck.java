package me.RestrictedPower.TichuServer.Model;
import java.util.Collections;
import java.util.Stack;


public class Deck {
	private Stack<Card> cards;
	public Deck() {
		reset();
	}
	public void reset() {
		cards = new Stack<Card>();
		for(Card c : Card.values()) cards.add(c);
		Collections.shuffle(cards);
	}
	public Card pullCard() {
		return cards.pop();
	}
}
