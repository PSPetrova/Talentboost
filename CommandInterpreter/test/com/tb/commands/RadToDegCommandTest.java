package com.tb.commands;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class RadToDegCommandTest {
	Command command;

	@Before
	public void setUp() {
		command = new RadToDegCommand();
	}

	@Test
	public void testExecuteCorrectDegreesReturned() {
		String radians = Double.toString(Math.PI);
		String degrees = Double.toString(180);
		Assert.assertEquals(degrees, command.execute(radians));

	}

	@Test(expected = NumberFormatException.class)
	public void testExecuteNotNumberRadians() {
		command.execute("radtodeg");
	}

	@Test(expected = NullPointerException.class)
	public void testExecuteNullRadians() {
		command.execute(null);
	}

	@Test
	public void testExecuteEmptyRadians() {
		Assert.assertEquals("", command.execute(""));
	}

}
