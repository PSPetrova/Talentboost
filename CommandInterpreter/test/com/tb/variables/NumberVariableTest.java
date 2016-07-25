package com.tb.variables;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tb.commands.CommandException;

public class NumberVariableTest {
	private Variable numVariable;

	@Before
	public void setUp() {
		numVariable = new NumberVariable();
	}

	@Test
	public void testDefaultConstructor() {
		String number = numVariable.getValue();
		Assert.assertEquals(0, Integer.parseInt(number));
	}

	@Test
	public void testSetUpVariable() {
		Variable var = new NumberVariable();
		var.setValue("0");
		Assert.assertEquals("0", var.getValue());
	}

	@Test
	public void testAdd() {
		numVariable.add("5");
		Assert.assertEquals("5", numVariable.getValue());
		numVariable.add("3");
		Assert.assertEquals("8", numVariable.getValue());
	}

	@Test(expected = CommandException.class)
	public void testAddIllegalArguments() {
		numVariable.add("abcdef");
	}

	@Test(expected = CommandException.class)
	public void testAddNullInput() {
		numVariable.add((String) null);
	}

	@Test
	public void testSubstract() {
		numVariable.substract(1);
		Assert.assertEquals("-1", numVariable.getValue());
		numVariable.substract(2);
		Assert.assertEquals("-3", numVariable.getValue());
	}

	@Test
	public void testMultiply() {
		numVariable = new NumberVariable(10);
		numVariable.multiply(10);
		Assert.assertEquals("100", numVariable.getValue());
	}
	@Test
	public void testAddVariable(){
		Variable var=new NumberVariable();
		var.setValue("3");
		var.add("3");
		Assert.assertEquals("6", var.getValue());
	}
	@Test
	public void testSubstractVariable(){
		Variable var=new NumberVariable();
		var.setValue("6");
		var.substract(2);
		Assert.assertEquals("4", var.getValue());
	}
	@Test
	public void testMultiplyVariable(){
		Variable var=new NumberVariable();
		var.setValue("2");
		var.multiply(5);
		Assert.assertEquals("10", var.getValue());
	}
}
