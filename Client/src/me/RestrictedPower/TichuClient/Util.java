package me.RestrictedPower.TichuClient;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import me.RestrictedPower.TichuClient.Controller.Main;

public class Util {
	public static ImageIcon loadImageIcon(String name) {
		return new ImageIcon(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("../../../../resources/"+name)));
	}
	public static void sendNotification(String title, String msg) {
		JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
	}
	public static void sendError(String title, String msg) {
		JOptionPane.showMessageDialog(null, msg, title, JOptionPane.ERROR_MESSAGE);
	}
}
