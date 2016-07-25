package com.tb.variables;

import com.tb.commands.CommandException;

public class NumberVariable extends Variable {
	private int value;

	public NumberVariable(int value) {
		this.value = value;
	}

	public NumberVariable() {
		this(0);
	}

	@Override
	public void substract(int num) {
		value -= num;
	}

	@Override
	public void multiply(int num) {
		value *= num;
	}

	@Override
	public void add(String s) {
		int num;
		try{
		num = Integer.parseInt(s);}
		catch(NumberFormatException e){
			throw new CommandException(s+" is not correct argument, must be Integer number ", e);
		}
		value += num;
	}

	@Override
	public String getValue() {
		return Integer.toString(value);
	}

	@Override
	public String toString() {
		return "[number] " + getValue();
	}

	@Override
	public void setValue(String value) {
		this.value = Integer.parseInt(value);
	}

	@Override
	public Variable add(Variable var) {
		Variable result = new NumberVariable();
		result.setValue(Integer.toString(value));
		result.add(var.getValue());
		return result;
	}

	@Override
	public Variable substract(Variable var) {
		Variable result = new NumberVariable();
		result.setValue(Integer.toString(value));
		result.substract(Integer.parseInt(var.getValue()));
		return result;
	}

	@Override
	public Variable multiply(Variable var) {
		Variable result = new NumberVariable();
		result.setValue(Integer.toString(value));
		result.multiply(Integer.parseInt(var.getValue()));
		return result;
	}
}