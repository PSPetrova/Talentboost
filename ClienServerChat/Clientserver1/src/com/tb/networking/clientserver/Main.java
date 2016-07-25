package com.tb.networking.clientserver;

import java.io.IOException;
import java.net.UnknownHostException;

public class Main {

	public static void main(String[] args) {
		Client cl=new Client();
		try {
			cl.start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
