package com.tb.variables;

import java.util.Map;

import com.tb.commands.Command;

public abstract class VarManip implements Command {
	protected final VarFactory varFactory = new VarFactory();
	protected final Map<String, Variable> map;
	protected final static String OK = "Ok";
	protected final static String ERR = "Err";

	protected VarManip(Map<String, Variable> map) {
		if (map == null) {
			throw new NullPointerException();
		}
		this.map = map;
	}

	public class VarFactory {
		private VarFactory() {
		};

		public Variable getVariable(String varType, String value) {
			if (varType.equalsIgnoreCase("string")) {
				return new StringVariable(value);
			} else if (varType.equalsIgnoreCase("date")) {
				return new DateVariable(value);
			} else if (varType.equalsIgnoreCase("number")) {
				return new NumberVariable(Integer.parseInt(value));
			} else {
				return null;
			}
		}
	}

}
