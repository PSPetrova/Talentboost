package com.tb.commands;

import java.util.Map;

import com.tb.variables.VarManip;
import com.tb.variables.Variable;

public class GetVarCommand extends VarManip {

	public GetVarCommand(Map<String, Variable> map) {
		super(map);
	}

	@Override
	public String execute(String arguments) {
		if (arguments == null) {
			throw new CommandException(arguments + " is not valid command. ");
		}
		Variable result = map.get(arguments);
		if (result == null) {
			return "";
		}
		return result.toString();
	}

}
