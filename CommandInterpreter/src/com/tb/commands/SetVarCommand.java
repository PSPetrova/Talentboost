package com.tb.commands;

import java.util.Map;

import com.tb.variables.VarManip;
import com.tb.variables.Variable;

public class SetVarCommand extends VarManip {

	public SetVarCommand(Map<String, Variable> map) {
		super(map);
	}

	@Override
	public String execute(String s) {
		String[] split = Command.parseArguments(s);
		if (split.length != 3) {
			throw new CommandException(s + " is not valid input. Expected <name type value>");
		}
		String name = split[0];
		String type = split[1];
		String value = split[2];
		Variable var = varFactory.getVariable(type, value);
		if (var != null) {
			map.put(name, var);
			return OK;
		} else {
			return ERR;
		}
	}

}
