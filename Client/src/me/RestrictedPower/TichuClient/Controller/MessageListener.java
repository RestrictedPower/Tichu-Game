package me.RestrictedPower.TichuClient.Controller;

import java.io.IOException;

public class MessageListener extends Thread{
    public void run() {
        try {
            while (true) {
                String msg = Main.gameHandler.getConnection().getConnectionInput().readLine();
                if(msg!=null) Main.gameHandler.messageRecieveEvent(msg);
            }
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }
}
