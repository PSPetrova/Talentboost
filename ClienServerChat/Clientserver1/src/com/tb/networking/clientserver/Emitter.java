package com.tb.networking.clientserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Emitter implements Runnable {
	private Socket socket;

	public Emitter(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		Scanner scan = new Scanner(System.in);
		try {
			// scan.nextLine();
			PrintWriter pwritter = new PrintWriter(socket.getOutputStream(), true);
			while (true) {
				String msg = scan.nextLine();
				pwritter.println("Petya" + msg);
				pwritter.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
