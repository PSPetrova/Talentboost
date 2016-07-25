package com.tb.commands;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class CapitalizeCommandTest {
	Command command;

	@Before
	public void setUp() {
		command = new CapitalizeComand();
	}

	@Test
	public void testExecuteCorrectInputCapitalize() {
		String str = "abcdef";
		Assert.assertEquals(str.toUpperCase(), command.execute(str));
	}

	@Test(expected = NullPointerException.class)
	public void testExecuteNullInput() {
		command.execute(null);
	}
}
