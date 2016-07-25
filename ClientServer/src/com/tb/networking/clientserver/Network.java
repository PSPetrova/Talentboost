package com.tb.networking.clientserver;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.util.Enumeration;

public class Network {
	public static void download(URL location, String filename) throws IOException {

		InputStream in = new BufferedInputStream(location.openStream());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buf = new byte[2048];
		int n;
		while ((n = in.read(buf)) != -1) {
			out.write(buf, 0, n);
		}
		in.close();
		out.close();

		byte[] response = out.toByteArray();

		FileOutputStream fos = new FileOutputStream(filename);
		fos.write(response);
		fos.close();
	}

	public static boolean ping(String hostname, int port) {
		boolean result = false;
		try (Socket socket = new Socket(hostname, port)) {
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void ipConfigAll() {
		try {
			Enumeration<NetworkInterface> interall = NetworkInterface.getNetworkInterfaces();
			while (interall.hasMoreElements()) {
				NetworkInterface i = interall.nextElement();
				System.out.println(i);
			}
		} catch (SocketException exp) {
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		// ipConfigAll();

		// System.out.println(ping("www.abv.bg", 80));
		URL url = new URL(
				"https://yt3.ggpht.com/-dlysGbGWUKQ/AAAAAAAAAAI/AAAAAAAAAAA/NQpT00a8Iv4/s88-c-k-no-rj-c0xffffff/photo.jpg");
		download(url, "kitty.jpg");
	}
}
