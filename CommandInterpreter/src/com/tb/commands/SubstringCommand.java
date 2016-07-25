package com.tb.commands;

public class SubstringCommand implements Command {
	String str1 = "";
	String str2 = "";

	@Override
	public String execute(String arguments) {
		String str1 = "";
		String str2 = "";
		String[] split = Command.parseArguments(arguments);
		if (split.length >= 1) {
			str1 = split[0];

		}
		if (split.length >= 2) {
			str2 = split[1];
		}

		return Boolean.toString(str1.indexOf(str2) >= 0);
	}
}
