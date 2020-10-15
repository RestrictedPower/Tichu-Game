package me.RestrictedPower.TichuClient.View.ViewModels;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import me.RestrictedPower.TichuClient.Util;

public class DisplayPlayer{
	private JFrame frame;
	private JLabel grandLabel,tichuLabel,cardsLeftLabel,playerName,playingNow;
	private ArrayList<JLabel> cardsLeft = new ArrayList<JLabel>();
	private String name;
	private int width,height;
	private final int delta = -10, grandOrTichuDelta = -60;
	boolean saidGrandOrTichu;
	public DisplayPlayer(String name, JFrame frame, int width, int height) {
		this.frame = frame;
		this.width = width;
		this.height = height;
		playingNow = new JLabel(Util.loadImageIcon("informative/playing_now.png"));
		playingNow.setBounds(width-playingNow.getIcon().getIconWidth()/2, height+155, playingNow.getIcon().getIconWidth(), playingNow.getIcon().getIconHeight());
		playingNow.setVisible(false);
		
		grandLabel = new JLabel(Util.loadImageIcon("informative/grand_tichu.png"));
		grandLabel.setBounds(width-grandLabel.getIcon().getIconWidth()/2, height, grandLabel.getIcon().getIconWidth(), grandLabel.getIcon().getIconHeight());
		grandLabel.setVisible(false);
		
		tichuLabel = new JLabel(Util.loadImageIcon("informative/tichu.png"));
		tichuLabel.setBounds(width-tichuLabel.getIcon().getIconWidth()/2, height, tichuLabel.getIcon().getIconWidth(), tichuLabel.getIcon().getIconHeight());
		tichuLabel.setVisible(false);
		
		playerName = new JLabel(name, SwingConstants.CENTER);
		playerName.setFont(new Font("Rockwell", Font.BOLD, 30));
		playerName.setForeground(java.awt.Color.BLACK);
		playerName.setBounds(width-340/2, height+delta, 340, 68);
		saidGrandOrTichu = false;
		updateLeftCards(8);
		frame.getContentPane().add(playingNow,0);
		frame.getContentPane().add(playerName,0);
		frame.getContentPane().add(grandLabel,0);
		frame.getContentPane().add(tichuLabel,0);
	}
	public void updateLeftCards(int left) {
		for(JLabel c : cardsLeft) frame.remove(c);
		cardsLeft.clear();
		if(cardsLeftLabel!=null) frame.remove(cardsLeftLabel);
		int inc = -247/2;
		for(int i = 0; i<Math.max(left, 1); i++) {
			JLabel cardBack = new JLabel(Util.loadImageIcon("cards/BACK_SMALL.png"));
			cardBack.setBounds(width+10+inc, height+50, cardBack.getIcon().getIconWidth(), cardBack.getIcon().getIconHeight());
			frame.add(cardBack,0);
			cardsLeft.add(cardBack);
			inc+=10;
		}
		cardsLeftLabel = new JLabel(left+"", SwingConstants.CENTER);
		cardsLeftLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 40));
		cardsLeftLabel.setForeground(java.awt.Color.BLACK);
		cardsLeftLabel.setBounds(width+inc+10, height+60, 45, 68);
		frame.getContentPane().add(cardsLeftLabel,0);
 	}
	public void saidGrand() {
		saidGrandOrTichu = true;
		showTichuLabel(false);
		showGrandLabel(true);
	}
	public void saidTichu() {
		saidGrandOrTichu = true;
		showGrandLabel(false);
		showTichuLabel(true);
	}
	public void setPlayingNow(boolean show) {
		playingNow.show(show);
	}
	
	private void showTichuLabel(boolean show) {
		tichuLabel.show(show);
		if(saidGrandOrTichu) playerName.setBounds(width-170/2, height+grandOrTichuDelta, 170, 68);
		else playerName.setBounds(width-340/2, height+delta, 340, 68);
	}
	private void showGrandLabel(boolean show) {
		grandLabel.show(show);
		if(saidGrandOrTichu) playerName.setBounds(width-170/2, height+grandOrTichuDelta, 170, 68);
		else playerName.setBounds(width-340/2, height+delta, 340, 68);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
