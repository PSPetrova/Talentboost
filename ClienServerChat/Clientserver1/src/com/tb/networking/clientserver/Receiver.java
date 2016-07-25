package com.tb.networking.clientserver;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Receiver implements Runnable {
	private Socket socket;

	public Receiver(Socket socket) {
		this.socket = socket;
	}

	public void run() {

		try {
			InputStreamReader reader = new InputStreamReader(this.socket.getInputStream());
			BufferedReader in = new BufferedReader(reader);
			String input;
			input = in.readLine();
			while (true) {
				System.out.println(input);
				input = in.readLine();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
