package com.tb.operations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tb.commands.CommandException;
import com.tb.variables.DateVariable;
import com.tb.variables.NumberVariable;
import com.tb.variables.StringVariable;
import com.tb.variables.Variable;

public class SubstractOperationTest {
	Operation substractOperation;

	@Before
	public void setUp() {
		substractOperation = new SubstractOperation();
	}

	@Test
	public void testEvaluate() {
		Variable var1 = new NumberVariable(5);
		Variable var2 = new NumberVariable(3);
		Variable result = substractOperation.evaluate(var1, var2);
		Assert.assertEquals("2", result.getValue());
	}

	@Test(expected = NullPointerException.class)
	public void testEvaluateNullArg() {
		substractOperation.evaluate(null, null);
	}

	@Test(expected = CommandException.class)
	public void testEvaluateSubstractFromDateString() {
		Variable date = new DateVariable();
		Variable str = new StringVariable("aaaa");
		substractOperation.evaluate(date, str);
	}
}
