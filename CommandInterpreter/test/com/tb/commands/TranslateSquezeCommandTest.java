package com.tb.commands;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TranslateSquezeCommandTest {
	Command command;

	@Before
	public void setUp() {
		command = new TranslateSquezeCommand();
	}

	@Test
	public void testExecuteCorrectInputRepeated() {
		Assert.assertEquals("abc", command.execute("aabbcc"));
	}

	@Test
	public void testExecuteCorrectInputNoRepeated() {
		Assert.assertEquals("abc", command.execute("abc"));
	}

	@Test
	public void testExecuteEmptyInput() {
		Assert.assertEquals("", command.execute(""));
	}

	@Test(expected = NullPointerException.class)
	public void testExecuteNullInput() {
		command.execute(null);
	}

}
