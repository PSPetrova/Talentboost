package com.tb.networking.clientserver;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8080);
		Socket socket = server.accept();
		BufferedOutputStream bufferOut = new BufferedOutputStream(socket.getOutputStream());
		while (true) {
			System.out.println("Server is wating for input");
			byte[] messageByte = new byte[1024];
			boolean end = false;
			String dataString = "";
			BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
			int bytesRead = 0;
			String messageString = "";
			while (true) {
				bytesRead = in.read(messageByte);
				String message = new String(messageByte, 0, bytesRead);
				System.out.println(message);
				messageString += new String(messageByte, 0, bytesRead);
				if (bytesRead <= 0) {
					break;
				}
			}
			System.out.println("MESSAGE: " + messageString);
			bufferOut.write("Hi Client".getBytes());
			bufferOut.flush();
		}

	}

}
