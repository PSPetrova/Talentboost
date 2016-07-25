package com.tb.commands;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tb.variables.NumberVariable;
import com.tb.variables.StringVariable;
import com.tb.variables.Variable;

public class SetVarCommandTest {
	private final static String OK = "Ok";
	private final static String ERR = "Err";
	private Command setVarCommand;
	Map<String, Variable> varMap;

	@Before
	public void setUp() {
		varMap = new HashMap<String, Variable>();
		setVarCommand = new SetVarCommand(varMap);
	}

	@Test(expected = NullPointerException.class)
	public void testConstructorNullVarMap() {
		new SetVarCommand(null);
	}

	@Test
	public void testSetVariable() {
		String result = setVarCommand.execute("test string test");
		Variable var = varMap.get("test");
		Assert.assertEquals(OK, result);
		Assert.assertEquals("test", var.getValue());
		Assert.assertTrue(var.getClass().equals(StringVariable.class));
	}

	@Test(expected = CommandException.class)
	public void testSetVariableTwoArgumentsFail() {
		setVarCommand.execute("string test");
	}

	@Test(expected = CommandException.class)
	public void testSetVariableOneArgumentFail() {
		setVarCommand.execute("test");
	}

	@Test(expected = CommandException.class)
	public void testSetVariableEmptyArguments() {
		setVarCommand.execute("");
	}

	@Test(expected = CommandException.class)
	public void testSetVariableNullArgument() {
		setVarCommand.execute(null);
	}

	@Test(expected = CommandException.class)
	public void testSetTooManyArguments() {
		setVarCommand.execute("result string test string");
	}

	@Test
	public void testSetNonExistingType() {
		String result = setVarCommand.execute("a none_existing_type 123");
		Assert.assertEquals(ERR, result);
		Assert.assertTrue(varMap.size() == 0);
	}

	@Test
	public void testVarMapOverwriteValue() {
		String name = "overwrite";
		setVarCommand.execute(name + " string test");
		Assert.assertNotNull(varMap.get(name));
		String result = setVarCommand.execute(name + " number 123");
		Variable var = varMap.get(name);
		Assert.assertEquals(OK, result);
		Assert.assertEquals("123", var.getValue());
		Assert.assertTrue(var.getClass().equals(NumberVariable.class));
		Assert.assertTrue(varMap.size() == 1);
	}
}
