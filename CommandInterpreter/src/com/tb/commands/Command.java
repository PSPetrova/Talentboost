package com.tb.commands;

public interface Command {
	public String execute(String arguments);

	public static String[] parseArguments(String arguments) {
		String[] result = {};
		if (arguments != null && arguments.length() > 0) {
			result = arguments.split(" ");
		}
		return result;
	}
}
