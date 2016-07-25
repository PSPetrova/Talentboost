package com.tb.shape;

import org.junit.Assert;
import org.junit.Test;

public class SquareTest {

	@Test
	public void testGetArea() {
		Shape s = new Square(4);
		Assert.assertTrue(s.area() == 16);
	}


}
