package com.tb.interpreter;

import java.util.Map;

import com.tb.commands.Command;

public class Interpreter {
	private final Map<String, Command> commandMap;
	private final static String NO_SUCH_COMMAND_MESSAGE = "No such command";

	public Interpreter(Map<String, Command> commandMap) {
		if (commandMap == null) {
			throw new NullPointerException();
		}
		this.commandMap = commandMap;
	}

	public String executeCommand(String commandName, String arguments) {
		Command command = commandMap.get(commandName);
		String result = NO_SUCH_COMMAND_MESSAGE;
		if (command != null) {
			result = command.execute(arguments);
		}
		return result;
	}

}