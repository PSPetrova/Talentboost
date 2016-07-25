package com.tb.variables;

public abstract class Variable {

	public void add(String s) {
		// Do nothing
	}

	public void substract(int num) {
		// Do nothing
	}

	public void multiply(int num) {
		// Do nothing
	}

	public Variable add(Variable var) {
		return null;
	}

	public Variable substract(Variable var) {
		return null;
	}

	public Variable multiply(Variable var) {
		return null;
	}

	public abstract void setValue(String value);

	public abstract String getValue();

};