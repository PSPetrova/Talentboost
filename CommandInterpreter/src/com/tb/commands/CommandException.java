package com.tb.commands;

@SuppressWarnings("serial")
public class CommandException extends RuntimeException {
	public CommandException(String message, Throwable t) {
		super(message, t);
	}

	public CommandException(String message) {
		super(message);
	}
}
