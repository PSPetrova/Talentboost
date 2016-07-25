package com.tb.variables;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tb.commands.CommandException;

public class StringVariableTest {

	private Variable stringVar;

	@Before
	public void setUp() {
		stringVar = new StringVariable();
	}
	@Test
	public void testSetVariable(){
		Variable var=new StringVariable();
		var.setValue("");
		Assert.assertEquals("", var.getValue());
	}

	@Test
	public void testAddAnotherString() {
		stringVar.add("Other");
		Assert.assertEquals("Other", stringVar.getValue());
		stringVar.add("AaaB");
		Assert.assertEquals("OtherAaaB", stringVar.getValue());
	}

	@Test(expected = CommandException.class)
	public void testAddAnotherStringNull() {
		stringVar.add((String) null);
	}
	@Test
	public void testAddVariable(){
		Variable var=new StringVariable();
		var.setValue("abc");
		var.add("def");
		Assert.assertEquals("abcdef", var.getValue());
	}

	@Test
	public void testMultiply() {
		stringVar = new StringVariable("A");
		stringVar.multiply(5);
		Assert.assertEquals("AAAAA", stringVar.getValue());
	}

	@Test(expected = CommandException.class)
	public void testMultiplyNegativeNumber() {
		stringVar.setValue("aaa");
		stringVar.multiply(-2);
	}
	@Test
	public void testMultiplyVariable(){
		Variable var=new StringVariable();
		var.setValue("aaa");
		var.multiply(2);
		Assert.assertEquals("aaaaaa", var.getValue());
	}
	@Test
	public void testSubstractDoesNothing() {
		String before = stringVar.getValue();
		stringVar.substract(3);
		Assert.assertEquals(before, stringVar.getValue());
	}

}
