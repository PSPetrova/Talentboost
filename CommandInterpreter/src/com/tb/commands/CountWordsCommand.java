package com.tb.commands;

public class CountWordsCommand implements Command {

	@Override
	public String execute(String arguments) {
		if (arguments == null || arguments.isEmpty()) {
			return "0";
		}
		int count = 1;
		for (char c : arguments.toCharArray()) {
			if (c == ' ') {
				count++;
			}
		}
		return Integer.toString(count);
	}

}
