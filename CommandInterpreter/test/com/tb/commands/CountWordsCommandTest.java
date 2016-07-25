package com.tb.commands;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CountWordsCommandTest {
	Command command;

	@Before
	public void setUp() {
		command = new CountWordsCommand();
	}

	@Test
	public void testExecuteCorrectInput() {
		String str = "one two three four";
		Assert.assertEquals(Integer.toString(4), command.execute(str));
	}

	@Test
	public void testExecuteEmptyInput() {

		Assert.assertEquals("0", command.execute(""));
	}

	@Test
	public void testExecuteNullInput() {
		Assert.assertEquals("0", command.execute(null));
	}

}
