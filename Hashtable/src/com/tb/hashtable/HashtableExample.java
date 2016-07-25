package com.tb.hashtable;

import java.util.Hashtable;

public class HashtableExample {

	public static void main(String[] args) {

		Hashtable<String, Double> grocery = new Hashtable<String, Double>();
		grocery.put("apple", 4.0);
		grocery.put("avoccado", 7.63);
		grocery.put("tomato", 3.72);
		grocery.put("carrots", 1.35);
		grocery.put("banana", 2.70);
		grocery.put("lemon", 4.75);
		

		for (String key : grocery.keySet()) {
			System.out.println("Key " + key + " Value " + grocery.get(key));
		}

		System.out.println(grocery.size());
		System.out.println(grocery.get("apple"));
		System.out.println(grocery.isEmpty());

	}

}
