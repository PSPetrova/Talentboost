package com.tb.operations;

import com.tb.variables.Variable;

public class SubstractOperation implements Operation {

	@Override
	public Variable evaluate(Variable var1, Variable var2) {
		return var1.substract(var2);
	}

}
