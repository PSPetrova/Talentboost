package com.tb.httpserver;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.HttpServer;
import com.tb.handlers.HandlerGet;
import com.tb.handlers.HandlerSet;
import com.tb.handlers.MyHandler;

public class Server {
	public static void main(String[] args) throws Exception {
		Map<String, Integer> fruits = new HashMap<String, Integer>();
		HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
		server.createContext("/fruits/get", new HandlerGet(fruits));
		server.createContext("/fruits/set", new HandlerSet(fruits));
		server.createContext("/fruits", new MyHandler());
		server.setExecutor(null); // creates a default executor
		server.start();
	}

}
