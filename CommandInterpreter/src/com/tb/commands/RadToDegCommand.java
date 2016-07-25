package com.tb.commands;

public class RadToDegCommand implements Command {

	@Override
	public String execute(String arguments) {
		if (arguments.length() <= 0) {
			return "";
		}
		double ang = Double.parseDouble(arguments);
		return Double.toString(Math.toDegrees(ang));
	}

}
