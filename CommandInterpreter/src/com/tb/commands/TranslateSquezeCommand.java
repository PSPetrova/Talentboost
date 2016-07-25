package com.tb.commands;

public class TranslateSquezeCommand implements Command {

	@Override
	public String execute(String arguments) {
		if (arguments.isEmpty()) {
			return arguments;
		}
		StringBuilder build = new StringBuilder();
		char current = arguments.charAt(0);
		build.append(current);
		for (int i = 1; i < arguments.length(); i++) {
			char c = arguments.charAt(i);
			if (current != c) {
				build.append(c);
				current = c;
			}

		}
		return build.toString();
	}

}
