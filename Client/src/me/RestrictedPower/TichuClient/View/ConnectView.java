package me.RestrictedPower.TichuClient.View;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;

import me.RestrictedPower.TichuClient.Controller.Main;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class ConnectView {
	private final int Height = 250, Width = 450;
	private JFrame frame;
	private JTextField nameField;
	private JLabel serverLabel;
	private JTextField serverField;
	public ConnectView() {
		initialize();
		frame.setVisible(true);
	}
	private void initialize() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame = new JFrame();
		frame.setTitle("Tichu by RestrictedPower - Connect to a server.");
		frame.setBounds((int) (dim.getWidth()-Width)/2,(int) (dim.getHeight()-Height)/2, Width, Height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel nameLabel = new JLabel("Enter your name:");
		nameLabel.setFont(new Font("Rockwell", Font.PLAIN, 13));
		nameLabel.setBounds(center(105), 20, 105, 20);
		frame.getContentPane().add(nameLabel);
		
		
		nameField = new JTextField();
		nameField.setText("Name");
		nameField.setFont(new Font("Rockwell", Font.PLAIN, 13));
		nameField.setBounds(center(200), 40, 200, 20);
		frame.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		serverLabel = new JLabel("Enter the server ip:");
		serverLabel.setFont(new Font("Rockwell", Font.PLAIN, 13));
		serverLabel.setBounds(center(110), 80, 110, 20);
		frame.getContentPane().add(serverLabel);
		
		serverField = new JTextField();
		serverField.setText("localhost");
		serverField.setFont(new Font("Rockwell", Font.PLAIN, 13));
		serverField.setColumns(10);
		serverField.setBounds(center(200), 100, 200, 20);
		frame.getContentPane().add(serverField);
		
		JButton connectButton = new JButton("Connect");
		connectButton.setFont(new Font("Rockwell", Font.BOLD, 15));
		connectButton.setBounds(center(300), 150, 300, 40);
		connectButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        try {
					Main.gameHandler.attemptToConnect(nameField.getText(), serverField.getText());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
		    }
		});
		frame.getContentPane().add(connectButton);
	}
	public int center(int sz) {
		return (Width-sz+1)/2;
	}
	public void close() {
		if(frame!=null)frame.dispose();
	}
}
