package com.tb.shape;

public class Rectangle implements Shape {
	private final double height;
	private final double width;

	Rectangle(double height, double width) {
		this.height = height;
		this.width = width;
	}

	@Override
	public double area() {
		return height * width;
	}

}
