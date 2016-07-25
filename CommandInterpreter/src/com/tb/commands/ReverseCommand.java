package com.tb.commands;

public class ReverseCommand implements Command {

	@Override
	public String execute(String arguments) {
		StringBuilder b = new StringBuilder(arguments);
		return b.reverse().toString();
	}

}
