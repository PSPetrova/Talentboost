package com.tb.commands;

public class CapitalizeComand implements Command {

	@Override
	public String execute(String arguments) {
		return arguments.toUpperCase();
	}

}
