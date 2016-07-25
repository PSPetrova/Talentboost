package com.tb.handlers;

import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.HttpHandler;

public abstract class AbstractHandler implements HttpHandler {
	protected Map<String, Integer> fruits;

	public AbstractHandler(Map<String, Integer> fruits) {
		this.fruits = fruits;

	}

	protected final Map<String, String> queryToMap(String query) {
		Map<String, String> result = new HashMap<String, String>();
		for (String param : query.split("&")) {
			String pair[] = param.split("=");
			if (pair.length > 1) {
				result.put(pair[0], pair[1]);
			} else {
				result.put(pair[0], "");
			}
		}
		return result;
	}
}
