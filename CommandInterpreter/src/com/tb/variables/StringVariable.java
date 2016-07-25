package com.tb.variables;

import com.tb.commands.CommandException;

public class StringVariable extends Variable {
	private String value;

	public StringVariable(String value) {
		this.value = value;
	}

	public StringVariable() {
		this("");
	}

	@Override
	public void multiply(int num) {
		if (num < 0) {
			throw new CommandException(num + " is not correct, must be nonnegative number ");
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num; i++) {
			sb.append(value);
		}
		value = sb.toString();
	}

	@Override
	public void add(String s) {
		if (s == null) {
			throw new CommandException("Cannot add null value");
		}
		value += s;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "[String] " + getValue();
	}

	@Override
	public Variable add(Variable var) {
		Variable result = new StringVariable();
		result.setValue(value + var);
		return result;
	}

	@Override
	public Variable multiply(Variable var) {
		Variable result = new StringVariable();
		result.setValue(value);
		int num = 0;
		try {
			num = Integer.parseInt(var.getValue());
		} catch (NumberFormatException e) {
			throw new CommandException(var.getValue() + " is not valid number. ", e);
		}

		result.multiply(num);
		return result;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
	}
}
