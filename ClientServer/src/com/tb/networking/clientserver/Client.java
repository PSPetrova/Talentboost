package com.tb.networking.clientserver;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws IOException {
		InetAddress host = InetAddress.getLocalHost();
		Socket socket = new Socket(host.getHostName(), 8080);
		BufferedInputStream bufferIn = new BufferedInputStream(socket.getInputStream());
		BufferedOutputStream bufferOut = new BufferedOutputStream(socket.getOutputStream());
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			bufferOut.write(sc.nextLine().getBytes());
			bufferOut.flush();
		}

	}

}
