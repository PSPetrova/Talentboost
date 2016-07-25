package com.tb.commands;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SubstringCommandTest {
	Command command;

	@Before
	public void setUp() {
		command = new SubstringCommand();
	}

	@Test
	public void testExecuteCorrectInputFalse() {
		Assert.assertEquals("false", command.execute("abc zabcz"));
	}

	@Test
	public void testExecuteCorrectInputTrue() {
		Assert.assertEquals("true", command.execute("abcdef abc"));
	}

	@Test
	public void testExecuteOneWordInput() {
		Assert.assertEquals("true", command.execute("oneword"));
	}

	@Test
	public void testExecuteEmptyStringInput() {
		Assert.assertEquals("true", command.execute(""));
	}

	@Test
	public void testExecuteNullInput() {
		command.execute(null);
	}

}
