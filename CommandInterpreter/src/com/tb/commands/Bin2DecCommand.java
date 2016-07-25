package com.tb.commands;

public class Bin2DecCommand implements Command {

	@Override
	public String execute(String arguments) {

		if (arguments.length() <= 0) {
			return "";
		}
		int decimalNumber = 0;
		for (int i = arguments.length() - 1; i >= 0; i--) {
			int a = Integer.parseInt(arguments.substring(i, i + 1));
			int pow = arguments.length() - i - 1;
			decimalNumber += Math.pow(2, pow) * a;

		}
		return Integer.toString(decimalNumber);
	}

}
