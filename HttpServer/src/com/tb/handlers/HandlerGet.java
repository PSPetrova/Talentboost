package com.tb.handlers;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;

public class HandlerGet extends AbstractHandler {

	public HandlerGet(Map<String, Integer> fruits) {
		super(fruits);
	}

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		Map<String, String> paramMap = queryToMap(exchange.getRequestURI().getQuery());
		String fruitName = paramMap.get("name");
		Integer count = fruits.get(fruitName);
		String message = "No such fruit " + fruitName;
		if (count != null) {
			message = fruitName + " " + count;
		}
		exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, message.length());
		OutputStream os = exchange.getResponseBody();
		os.write(message.getBytes());
		os.close();

	}

}
