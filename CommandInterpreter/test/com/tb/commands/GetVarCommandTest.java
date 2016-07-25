package com.tb.commands;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tb.variables.StringVariable;
import com.tb.variables.Variable;

public class GetVarCommandTest {
	private Command getVarCommand;
	Map<String, Variable> varMap;

	@Before
	public void setUp() {
		varMap = new HashMap<String, Variable>();
		getVarCommand = new GetVarCommand(varMap);
	}

	@Test(expected = NullPointerException.class)
	public void testConstructorNullVarMap() {
		new GetVarCommand(null);
	}

	@Test
	public void testGetVariable() {
		Variable strVar = new StringVariable("abc");
		varMap.put("test", strVar);
		String var = getVarCommand.execute("test");
		Assert.assertEquals(strVar.toString(), var);
	}

	@Test
	public void testGetVariableEmptyString() {
		Variable strVar = new StringVariable("aaa");
		varMap.put("", strVar);
		String var = getVarCommand.execute("");
		Assert.assertEquals(strVar.toString(), var);
	}

	@Test(expected = CommandException.class)
	public void testGetVariableNull() {
		getVarCommand.execute(null);
	}

	@Test
	public void testGetVariableNonExisting() {
		String result = getVarCommand.execute("none_existing");
		Assert.assertEquals("", result);
	}

}
