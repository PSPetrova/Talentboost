package com.tb.interpreter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.tb.commands.Bin2DecCommand;
import com.tb.commands.CalcCommand;
import com.tb.commands.CapitalizeComand;
import com.tb.commands.Command;
import com.tb.commands.CountWordsCommand;
import com.tb.commands.ExitCommand;
import com.tb.commands.GetVarCommand;
import com.tb.commands.RadToDegCommand;
import com.tb.commands.ReverseCommand;
import com.tb.commands.ReverseWordsCommand;
import com.tb.commands.SetVarCommand;
import com.tb.commands.SubstringCommand;
import com.tb.commands.TranslateSquezeCommand;
import com.tb.variables.Variable;

public class Main {
	public static void main(String[] args) {
		Interpreter interp = new Interpreter(getCommandMap());

		Scanner scan = new Scanner(System.in);
		while (true) {
			String command = scan.nextLine();
			String commandName = "";
			String arguments = "";

			if (command.indexOf(" ") > 0) {
				commandName = command.substring(0, command.indexOf(" "));
				arguments = command.substring(command.indexOf(" ") + 1, command.length());
			} else {
				commandName = command;
			}

			System.out.println(interp.executeCommand(commandName, arguments));
		}

	}

	private static Map<String, Command> getCommandMap() {
		Map<String, Command> cmdMap = new HashMap<String, Command>();
		cmdMap.put("capitalize", new CapitalizeComand());
		cmdMap.put("translateSqueze", new TranslateSquezeCommand());
		cmdMap.put("bin2dec", new Bin2DecCommand());
		cmdMap.put("rad2deg", new RadToDegCommand());
		cmdMap.put("reverse-words", new ReverseWordsCommand());
		cmdMap.put("reverse", new ReverseCommand());
		cmdMap.put("substring", new SubstringCommand());
		cmdMap.put("count-words", new CountWordsCommand());
		ExitCommand exitCommand = new ExitCommand();
		cmdMap.put("q", exitCommand);
		cmdMap.put("exit", exitCommand);
		cmdMap.put("end", exitCommand);
		Map<String, Variable> varMap = new HashMap<String, Variable>();
		cmdMap.put("set", new SetVarCommand(varMap));
		cmdMap.put("get", new GetVarCommand(varMap));
		cmdMap.put("calc", new CalcCommand(varMap));
		return cmdMap;
	}

}