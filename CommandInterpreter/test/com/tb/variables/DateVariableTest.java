package com.tb.variables;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tb.commands.CommandException;

public class DateVariableTest {
	private static final String DEFAULT_DATE = "24.07.2016";
	private Variable dateVar;

	@Before
	public void setUp() {
		dateVar = new DateVariable();
	}

	@Test
	public void testEmptyContructor() {
		Assert.assertEquals(dateVar.getValue(), DEFAULT_DATE);
	}

	@Test(expected = CommandException.class)
	public void testConstructorIllegalArguments() {
		new DateVariable("abcdef");
	}

	@Test(expected = NullPointerException.class)
	public void testConstructorNullInput() {
		new DateVariable(null);
	}

	@Test
	public void testSetVariable() {
		Variable var1 = new DateVariable();
		var1.setValue(DEFAULT_DATE);
		Assert.assertEquals(var1.getValue(), DEFAULT_DATE);
	}

	@Test
	public void testAddDays() {
		dateVar.add("3");
		Assert.assertEquals("27.07.2016", dateVar.getValue());
	}

	@Test(expected = CommandException.class)
	public void testAddDaysNullInput() {
		dateVar.add((String) null);
	}

	@Test(expected = CommandException.class)
	public void testAddDaysIllegalString() {
		dateVar.add("abcd");
	}

	@Test
	public void testMultiplyDoesNothing() {
		String before = dateVar.getValue();
		dateVar.multiply(211);
		Assert.assertEquals(before, dateVar.getValue());
	}

	@Test
	public void testSubstractDays() {
		dateVar.substract(3);
		Assert.assertEquals("21.07.2016", dateVar.getValue());
	}

	@Test
	public void testSubstractDaysNegativeNumber() {
		dateVar.substract(-5);
		Assert.assertEquals("29.07.2016", dateVar.getValue());
	}

	@Test
	public void testAddVariable() {
		Variable var1 = new DateVariable();
		var1.add("3");
		Assert.assertEquals("27.07.2016", var1.getValue());
	}

	@Test(expected = CommandException.class)
	public void testAddVariableNullInput() {
		Variable var1 = new DateVariable();
		var1.add((String) null);
	}

	@Test
	public void testSubstractVariable() {
		Variable var = new DateVariable();
		var.substract(3);
		Assert.assertEquals("21.07.2016", var.getValue());
	}

}
