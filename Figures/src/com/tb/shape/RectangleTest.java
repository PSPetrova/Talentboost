package com.tb.shape;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class RectangleTest {

	@Test
	public void testGetArea() {
		Shape r = new Rectangle(4, 5);
		Assert.assertTrue(r.area() == 20);
	}

}
