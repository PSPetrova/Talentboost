package com.tb.operations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tb.commands.CommandException;
import com.tb.variables.DateVariable;
import com.tb.variables.NumberVariable;
import com.tb.variables.StringVariable;
import com.tb.variables.Variable;

public class MultiplyOperationTest {
	Operation multiplyOperation;

	@Before
	public void setUp() {
		multiplyOperation = new MultiplyOperation();
	}

	@Test
	public void testEvaluate() {
		Variable var1 = new NumberVariable(3);
		Variable var2 = new NumberVariable(2);
		Variable result = multiplyOperation.evaluate(var1, var2);
		Assert.assertEquals("6", result.getValue());
	}

	@Test(expected = NullPointerException.class)
	public void testEvaluateNullArg() {
		multiplyOperation.evaluate(null, null);
	}

	@Test(expected = CommandException.class)
	public void testEvaluateMultiplyDateWithStringFail() {
		Variable str = new StringVariable("abcd");
		Variable date = new DateVariable();
		multiplyOperation.evaluate(str, date);
	}
}
