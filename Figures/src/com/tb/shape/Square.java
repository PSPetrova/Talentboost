package com.tb.shape;

public class Square implements Shape {
	private final double height;

	Square(double height) {
		this.height = height;
	}

	@Override
	public double area() {
		return height * height;
	}

}
