package me.RestrictedPower.TichuClient.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Connection {
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	public Connection(Socket socket) throws IOException {
		this.socket = socket;
		this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    this.out = new PrintWriter(socket.getOutputStream(), true);
	}
	public void sendMessage(String msg) {
		out.println(msg);
	}
	public BufferedReader getConnectionInput() {
		return in;
	}
	public void close() {
		try {
			this.socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
