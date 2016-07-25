package com.tb.commands;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReverseWordsCommandTest {
	Command command;

	@Before
	public void setUp() {
		command = new ReverseWordsCommand();
	}

	@Test
	public void testExecuteCorrectInput() {
		String str = "one two three four";
		Assert.assertEquals("four three two one", command.execute(str));
	}

	@Test
	public void testExecuteEmptyInput() {
		Assert.assertEquals("", command.execute(""));
	}

	@Test
	public void testExecuteOneWordInput() {
		Assert.assertEquals("one", command.execute("one"));
	}

	@Test
	public void testExecuteNullInput() {
		command.execute(null);
	}
}
