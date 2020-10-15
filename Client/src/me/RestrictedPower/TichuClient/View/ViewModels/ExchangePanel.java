package me.RestrictedPower.TichuClient.View.ViewModels;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

import me.RestrictedPower.TichuClient.Util;
import me.RestrictedPower.TichuClient.Controller.Main;
import me.RestrictedPower.TichuClient.Model.Card;
import me.RestrictedPower.TichuClient.View.GameView;

public class ExchangePanel {
	private ImageIcon select = Util.loadImageIcon("cards/SELECT.png");
	private int CARD_HEIGHT = Card.BLACK_10.image.getIconHeight(), CARD_WIDTH = Card.BLACK_10.image.getIconWidth();
	private JFrame frame;
	private JLabel background;
	private int width,height;
	private Card left,mid,right;
	private JButton leftButton, rightButton, midButton;
	public ExchangePanel(JFrame frame, int width, int height) {
		this.frame = frame;
		this.width = width;
		this.height = height;
		background = new JLabel(Util.loadImageIcon("exchange.png"));
		background.setBounds(width/2-332/2, height/2+50, background.getIcon().getIconWidth(), background.getIcon().getIconHeight());
		background.setVisible(true);
		
		leftButton = new JButton(select);
		leftButton.setBounds(30, 30, CARD_WIDTH, CARD_HEIGHT);
		leftButton.setFocusable(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setBorderPainted(false);
		leftButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				leftClick();
			}
		});
		
		midButton = new JButton(select);
		midButton.setBounds(30+CARD_WIDTH+10, 30, CARD_WIDTH, CARD_HEIGHT);
		midButton.setFocusable(false);
		midButton.setContentAreaFilled(false);
		midButton.setBorderPainted(false);
		midButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				midClick();
			}
		});
		
		rightButton = new JButton(select);
		rightButton.setBounds(30+2*CARD_WIDTH+20, 30, CARD_WIDTH, CARD_HEIGHT);
		rightButton.setFocusable(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setBorderPainted(false);
		rightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rightClick();
			}
		});
		background.add(midButton);
		background.add(rightButton);
		background.add(leftButton);
		frame.getContentPane().add(background,0);
	}
	public void show(boolean show) {
		background.setVisible(show);
	}
	public void exchanged() {
		background.setIcon(Util.loadImageIcon("exchange_complete.png"));
		background.remove(midButton);
		background.remove(rightButton);
		background.remove(leftButton);
	}
	private void leftClick() {
		if(left!=null) Main.gameHandler.getHand().addCard(left);
		if(Main.gameHandler.getHand().getSelected().isEmpty()) {
			left = null;
			leftButton.setIcon(select);
		}else {
			Card c = null;
			for(Card cx : Main.gameHandler.getHand().getSelected()) c = cx;
			left = c;
			setLeftCard(c);
			Main.gameHandler.getHand().removeCard(c);
		}
		Main.view3.drawCards(Main.gameHandler.getHand());
	}
	private void rightClick() {
		if(right!=null) Main.gameHandler.getHand().addCard(right);
		if(Main.gameHandler.getHand().getSelected().isEmpty()) {
			right = null;
			rightButton.setIcon(select);
		}else {
			Card c = null;
			for(Card cx : Main.gameHandler.getHand().getSelected()) c = cx;
			right = c;
			setRightCard(c);
			Main.gameHandler.getHand().removeCard(c);
		}
		Main.view3.drawCards(Main.gameHandler.getHand());
	}
	private void midClick() {
		if(mid!=null) Main.gameHandler.getHand().addCard(mid);
		if(Main.gameHandler.getHand().getSelected().isEmpty()) {
			mid = null;
			midButton.setIcon(select);
		}else {
			Card c = null;
			for(Card cx : Main.gameHandler.getHand().getSelected()) c = cx;
			mid = c;
			setMiddleCard(c);
			Main.gameHandler.getHand().removeCard(c);
		}
		Main.view3.drawCards(Main.gameHandler.getHand());
	}
	public void setLeftCard(Card c) {
		left = c;
		leftButton.setIcon(c.image);
	}
	public void setRightCard(Card c) {
		right = c;
		rightButton.setIcon(c.image);
	}
	public void setMiddleCard(Card c) {
		mid = c;
		midButton.setIcon(c.image);
	}
	public Card[] getSubmitedCards() {
		return new Card[] {left,mid,right};
	}
}
