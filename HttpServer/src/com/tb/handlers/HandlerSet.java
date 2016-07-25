package com.tb.handlers;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;

public class HandlerSet extends AbstractHandler {

	public HandlerSet(Map<String, Integer> fruits) {
		super(fruits);
	}

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		Map<String, String> paramMap = queryToMap(exchange.getRequestURI().getQuery());
		String fruitName = paramMap.get("name");
		String countParam = paramMap.get("count");
		int count = Integer.parseInt(countParam);
		if (fruits.containsKey(fruitName)) {
			fruits.put(fruitName, fruits.get(fruitName) + count);
		} else {
			fruits.put(fruitName, count);
		}

		String response = count + " " + fruitName + " were added";
		exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, response.length());
		OutputStream os = exchange.getResponseBody();
		os.write(response.getBytes());
		os.close();

	}

}
