package me.RestrictedPower.TichuClient.Controller;
import java.util.Random;

import me.RestrictedPower.TichuClient.View.ConnectView;
import me.RestrictedPower.TichuClient.View.ConnectedView;
import me.RestrictedPower.TichuClient.View.GameView;

public class Main {
	public static final int PORT = 8901;
	public static ConnectView view1;
	public static ConnectedView view2;
	public static GameView view3;
	
	public static GameHandler gameHandler;
	
	
	public static void main(String[] args) throws Exception {
		gameHandler = new GameHandler();
		//gameHandler.attemptToConnect(new Random().nextInt(1000)+"", "localhost");
		//view3 = new GameView("da", "da", "Dass");
	}
	
}
