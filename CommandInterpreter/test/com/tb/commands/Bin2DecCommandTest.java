package com.tb.commands;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Bin2DecCommandTest {
	Command command;

	@Before
	public void setUp() {
		command = new Bin2DecCommand();
	}

	@Test
	public void testExecuteCorrectDecimalReturned() {
		String binaryNum = "1010";
		String decimalExpected = Integer.toString(10);

		Assert.assertEquals(decimalExpected, command.execute(binaryNum));
	}

	@Test(expected = NumberFormatException.class)
	public void testExecuteNotNumberBinary() {
		command.execute("abcde");
	}

	@Test(expected = NullPointerException.class)
	public void testExecuteNullBinaryNumber() {
		command.execute(null);
	}

	@Test
	public void testExecuteEmptyBinaryNumber() {
		Assert.assertEquals("", command.execute(""));
	}

}
