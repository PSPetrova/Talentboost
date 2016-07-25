package com.tb.operations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tb.commands.CommandException;
import com.tb.variables.NumberVariable;
import com.tb.variables.StringVariable;
import com.tb.variables.Variable;

public class AddOperationTest {
	private Operation addOperation;

	@Before
	public void setUp() {
		addOperation = new AddOperation();
	}

	@Test
	public void testEvaluate() {
		Variable var1 = new NumberVariable(4);
		Variable var2 = new NumberVariable(3);
		Variable result = addOperation.evaluate(var1, var2);
		Assert.assertEquals("7", result.getValue());
	}

	@Test(expected = NullPointerException.class)
	public void testEvaluateNullArg() {
		addOperation.evaluate(null, null);
	}

	@Test(expected = CommandException.class)
	public void testAddStringToNumberFail() {
		Variable number = new NumberVariable(5);
		Variable str = new StringVariable("abc");
		addOperation.evaluate(number, str);
	}
	
}
