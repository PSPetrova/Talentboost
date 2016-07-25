package com.tb.app;

import java.util.HashMap;
import java.util.Map;

public class Point {
	private final int x;
	private final int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	Point(String str) {
		if (str == null) {
			throw new NumberFormatException();
		}
		String[] split = str.split(" ");
		if (split == null || split.length != 2) {
			throw new NumberFormatException();
		}
		x = Integer.parseInt(split[0]);
		y = Integer.parseInt(split[1]);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point p = (Point) obj;
			return (p.x == x && p.y == y);
		}
		return false;
	}

	@Override
	public int hashCode() {
		String str = x + "" + y;
		return str.hashCode();
	}

	@Override
	public String toString() {
		return (x + " " + y);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public static void main(String[] args) {
		String[] array = { "1 2", "1 2", "2 1", "1 3", "3 1", "4 1", "5 1" };
		Map<Integer, Point> map = new HashMap<Integer, Point>();
		for (String x : array) {
			Point p = new Point(x);
			map.put(p.hashCode(), p);
		}
		for (Integer x : map.keySet()) {
			System.out.println(x + " " + map.get(x));
		}
		System.out.println("Different points : " + map.keySet().size());
	}
}
