package com.tb.commands;

public class ExitCommand implements Command {

	@Override
	public String execute(String arguments) {
		System.exit(0);
		return "";
	}

}
