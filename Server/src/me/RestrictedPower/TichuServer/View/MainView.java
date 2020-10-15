package me.RestrictedPower.TichuServer.View;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JTextArea;

import me.RestrictedPower.TichuServer.Controller.Main;
import me.RestrictedPower.TichuServer.Model.Player;

import javax.swing.JButton;

public class MainView {
	public static final int PORT = 8901;
	private final int Height = 300, Width = 450;
	private JFrame frame;
	private JTextArea logArea;
	private JScrollPane scrollPane;
	private JButton startButton;
	private JButton[] playerTeam = new JButton[4];
	private JLabel[] playerLabel = new JLabel[4];
	public MainView() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Tichu by RestrictedPower - Server");
		frame.setBounds((int) (dim.getWidth()-Width)/2,(int) (dim.getHeight()-Height)/2, Width, Height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel logLabel = new JLabel("Server Log:");
		logLabel.setFont(new Font("Rockwell", Font.PLAIN, 13));
		logLabel.setBounds(25, 27, 75, 20);
		frame.getContentPane().add(logLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 58, 220, 202);
		frame.getContentPane().add(scrollPane);
		
		logArea = new JTextArea();
		scrollPane.setViewportView(logArea);
		logArea.setFont(new Font("Rockwell", Font.PLAIN, 13));
		
		startButton = new JButton("Start Game");
		startButton.setFont(new Font("Rockwell", Font.PLAIN, 11));
		startButton.setBounds(276, 185, 143, 62);
		startButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
				Main.startPress();
		    }
		});
		frame.getContentPane().add(startButton);
		
		
		for(int i = 0; i<4; i++) {
			final int k = i;
			playerLabel[i] = new JLabel("Waiting...");
			playerTeam[i] = new JButton(i<2?"Team 1":"Team 2");
			playerTeam[i].setFont(new Font("Rockwell", Font.PLAIN, 11));
			playerTeam[i].setBounds(359, 59, 75, 23);
			playerTeam[i].addActionListener(new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
					playerTeam[k].setText(playerTeam[k].getText().equalsIgnoreCase("Team 1")?"Team 2":"Team 1");
			    }
			});
			frame.getContentPane().add(playerTeam[k]);
			frame.getContentPane().add(playerLabel[i]);
		}
		playerLabel[0].setBounds(252, 63, 108, 14);
		playerLabel[1].setBounds(252, 92, 108, 14);
		playerLabel[2].setBounds(252, 121, 108, 14);
		playerLabel[3].setBounds(252, 150, 108, 14);
		
		playerTeam[0].setBounds(359, 59, 75, 23);
		playerTeam[1].setBounds(359, 88, 75, 23);
		playerTeam[2].setBounds(359, 117, 75, 23);
		playerTeam[3].setBounds(359, 146, 75, 23);
		frame.setVisible(true);
	}
	public void updateName(int id, String name) {
		playerLabel[id].setText(name);
	}
	public boolean firstTeam(int playerId) {
		return playerTeam[playerId].getText().equalsIgnoreCase("Team 1");
	}
	public int center(int sz) {
		return (Width-sz+1)/2;
	}
	public void addLog(String s) {
		logArea.setText((logArea.getText()==null?"":logArea.getText())+s+"\n");
	}
}
