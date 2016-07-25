package com.tb.app;

public class Pair {
	private double key;
	private String value;

	Pair(double key, String value) {
		this.key = key;
		this.value = value;
	}

	public double getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Pair) {
			Pair pair1 = (Pair) obj;
			return pair1.getKey() == key;
		}
		return false;
	}

}
