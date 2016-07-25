package com.tb.app;

import java.util.ArrayList;
import java.util.List;

public class HashTableImpl {

	private final List<Pair> pairs;

	public HashTableImpl() {
		pairs = new ArrayList<Pair>();
	}

	public void insert(double key, String value) {
		Pair p = new Pair(key, value);
		if (pairs.contains(p)) {
			pairs.remove(p);
		}
		pairs.add(p);
	}

	public String search(double key) {
		for (Pair p : pairs) {
			if (p.getKey() == key) {
				return p.getValue();
			}
		}
		return null;
	}

	public void delete(double key) {
		for (Pair p : pairs) {
			if (p.getKey() == key) {
				pairs.remove(p);
				break;
			}
		}

	}

	public void print() {
		for (Pair p : pairs) {
			System.out.println("key: " + p.getKey() + " value: " + p.getValue());
		}
	}

	public static void main(String[] args) {
		HashTableImpl hashtable=new HashTableImpl();
		hashtable.insert(2.46, "tomato");
		hashtable.insert(6.32, "pomegranate");
		hashtable.insert(1.32, "melon");
		hashtable.insert(5.32, "apple");
		hashtable.print();
		System.out.println();
		hashtable.insert(2.46, "tomato-edited");
		hashtable.print();
		hashtable.delete(1.32); 
		System.out.println();
		hashtable.print();
		
	}
}
