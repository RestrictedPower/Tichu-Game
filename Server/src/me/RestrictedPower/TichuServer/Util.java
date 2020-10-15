package me.RestrictedPower.TichuServer;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import me.RestrictedPower.TichuServer.Controller.Main;

public class Util {
	public static ImageIcon loadImageIcon(String name) {
		return new ImageIcon(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("../../../../resources/"+name)));
	}
	public static void sendError(String title, String msg) {
		JOptionPane.showMessageDialog(null, msg, title, JOptionPane.ERROR_MESSAGE);
	}
	public static String getIp() {
		try {
			URL site = new URL("http://checkip.amazonaws.com/");
			BufferedReader in = new BufferedReader(new InputStreamReader(site.openStream()));
        	return in.readLine();
		} catch (Exception e) {
			return null;
		}
	}
}
