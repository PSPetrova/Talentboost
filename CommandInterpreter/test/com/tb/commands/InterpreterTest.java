package com.tb.commands;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tb.interpreter.Interpreter;

public class InterpreterTest {
	private final static String NO_SUCH_COMMAND_MESSAGE = "No such command";
	private Interpreter inter;

	@Before
	public void setUp() {
		Map<String, Command> cmdMap = new HashMap<String, Command>();
		inter = new Interpreter(cmdMap);
	}

	@Test
	public void testExecuteCommand() {
		Map<String, Command> cmdMap = new HashMap<String, Command>();
		String commandName = "test-command";
		cmdMap.put(commandName, new CommandTest());
		inter = new Interpreter(cmdMap);
		String arg = "testResult";
		String result = inter.executeCommand(commandName, arg);
		Assert.assertEquals(arg, result);
	}

	@Test(expected = NullPointerException.class)
	public void testInterpetarotNullCommands() {
		new Interpreter(null);
	}

	@Test
	public void testExecuteNoSUchCommand() {
		Map<String, Command> cmdMap = new HashMap<String, Command>();
		inter = new Interpreter(cmdMap);
		String result = inter.executeCommand("not-existing-command", "");
		Assert.assertEquals(NO_SUCH_COMMAND_MESSAGE, result);
	}

	class CommandTest implements Command {

		@Override
		public String execute(String arguments) {
			return arguments;
		}

	}
}