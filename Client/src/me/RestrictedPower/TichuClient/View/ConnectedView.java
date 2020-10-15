package me.RestrictedPower.TichuClient.View;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class ConnectedView {
	private final int Height = 250, Width = 450;
	private JFrame frame;
	private JLabel waitingForServerLabel;
	public ConnectedView() {
		initialize();
		frame.setVisible(true);
	}
	private void initialize() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame = new JFrame();
		frame.setTitle("Tichu by RestrictedPower - Waiting for players...");
		frame.setBounds((int) (dim.getWidth()-Width)/2,(int) (dim.getHeight()-Height)/2, Width, Height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel connectedLabel = new JLabel("You are connected!");
		connectedLabel.setFont(new Font("Rockwell", Font.PLAIN, 20));
		connectedLabel.setBounds(center(185), 20, 185, 20);
		frame.getContentPane().add(connectedLabel);
		
		waitingForServerLabel = new JLabel("    Waiting for players, 0/4 connected.    ");
		waitingForServerLabel.setFont(new Font("Rockwell", Font.PLAIN, 20));
		waitingForServerLabel.setBounds(center(365), 88, 365, 20);
		frame.getContentPane().add(waitingForServerLabel);
	}
	public void updatePlayerCount(int v) {
		if(v==4) waitingForServerLabel.setText("All players connected! Waiting for host.");
		else     waitingForServerLabel.setText("    Waiting for players, "+v+"/4 connected.    ");
	}
	public int center(int sz) {
		return (Width-sz+1)/2;
	}
	public void close() {
		if(frame!=null)frame.dispose();
	}
}
