package com.tb.commands;

import java.util.Map;

import com.tb.operations.Operation;
import com.tb.variables.VarManip;
import com.tb.variables.Variable;

public class CalcCommand extends VarManip {

	public CalcCommand(Map<String, Variable> map) {
		super(map);
	}

	@Override
	public String execute(String arguments) {
		String[] split = Command.parseArguments(arguments);
		if (split.length != 4) {
			return "Err";
		}
		String var1Name = split[0];
		String var2Name = split[1];
		String operatorName = split[2];
		String var3Name = split[3];

		Variable var2 = map.get(var2Name);
		Variable var3 = map.get(var3Name);
		Operation operation = Operation.operationFactory.getOperation(operatorName);
		Variable result = operation.evaluate(var2, var3);
		map.put(var1Name, result);
		return "Ok";
	}

}
