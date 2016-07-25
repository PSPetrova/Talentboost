package com.tb.commands;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReverseCommandTest {
	Command command;

	@Before
	public void setUp() {
		command = new ReverseCommand();
	}

	@Test
	public void testExecuteCorrectInputReverse() {
		Assert.assertEquals("12345", command.execute("54321"));
	}

	@Test(expected = NullPointerException.class)
	public void testExecuteNullInputReverse() {
		command.execute(null);
	}
}
