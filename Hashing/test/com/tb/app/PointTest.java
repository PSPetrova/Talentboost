package com.tb.app;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

	@Test
	public void testConstructorTwoIntegers() {
		int x = 3;
		int y = 4;
		Point p = new Point(x, y);
		Assert.assertEquals(x, p.getX());
		Assert.assertEquals(y, p.getY());
	}

	@Test
	public void testConstructorString() {
		Point p = new Point("3 8");
		Assert.assertEquals(3, p.getX());
		Assert.assertEquals(8, p.getY());
	}

	@Test(expected = NumberFormatException.class)
	public void testConstructorEmptyString() {
		new Point("");

	}

	@Test(expected = NumberFormatException.class)
	public void testConstructorNullString() {
		new Point(null);
	}

	@Test(expected = NumberFormatException.class)
	public void testConstructorInvalidString() {
		new Point("3 ");
	}

	@Test(expected = NumberFormatException.class)
	public void testConstructorInvalidStringNotNumbers() {
		new Point("efw wefw");
	}

	@Test(expected = NumberFormatException.class)
	public void testConstructorInvalidStringTooManyArg() {
		new Point("2 3 4");
	}
	@Test
	public void testEqualsForTwoPoints(){
		Point p1=new Point(6,7);
		Point p2=new Point(6,7);
		Assert.assertTrue(p1.equals(p2));
	}
	@Test
	public void testEqualsTwoDifferentPoints(){
		Point p1=new Point(6,8);
		Point p2=new Point(2,8);
		Assert.assertFalse(p1.equals(p2));
	}
	@Test
	public void testHashCodeOfPoint(){
		Point p=new Point(2,3);
		int x=p.getX();
		int y=p.getY();
		String str=x+""+y;
		Assert.assertEquals(str.hashCode(), p.hashCode());
	}
}
