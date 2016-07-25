package com.tb.operations;

import com.tb.variables.Variable;

public interface Operation {
	public static final OperationFactory operationFactory = new OperationFactory();

	public Variable evaluate(Variable var1, Variable var2);

	public static class OperationFactory {
		private OperationFactory() {
		}

		public Operation getOperation(String operationName) {
			if (operationName.equals("+")) {
				return new AddOperation();
			} else if (operationName.equals("-")) {
				return new SubstractOperation();
			} else if (operationName.equals("*")) {
				return new MultiplyOperation();
			} else {
				return null;
			}
		}
	}
}
