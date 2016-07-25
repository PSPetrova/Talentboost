package com.tb.commands;

public class ReverseWordsCommand implements Command {

	@Override
	public String execute(String arguments) {
		String[] sentenceSplit = Command.parseArguments(arguments);
		reverseArray(sentenceSplit);

		StringBuilder b = new StringBuilder();
		for (String s : sentenceSplit) {
			b.append(s + " ");
		}
		return b.toString().trim();
	}

	private void reverseArray(Object[] array) {
		for (int i = 0; i < array.length / 2; i++) {
			Object temp = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = temp;
		}
	}

}
