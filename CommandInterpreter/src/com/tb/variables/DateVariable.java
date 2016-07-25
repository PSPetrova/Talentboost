package com.tb.variables;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.tb.commands.CommandException;

public class DateVariable extends Variable {
	private static final String DATE_FORMAT_STR = "dd.MM.yyyy";
	private static final DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_STR);
	private static final String DEFAULT_DATE = "24.07.2016";

	private final Calendar calendar;

	public DateVariable(String value) {
		calendar = Calendar.getInstance();
		setValue(value);
	}

	public DateVariable() {
		this(DEFAULT_DATE);
	}

	@Override
	public void add(String s) {
		int num;
		try {
			num = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			throw new CommandException(s + " must be Integer number. ", e);
		}
		calendar.add(Calendar.DATE, num);
	}

	@Override
	public void substract(int num) {
		add(Integer.toString(-num));
	}

	@Override
	public String getValue() {
		return dateFormat.format(calendar.getTime());
	}

	@Override
	public String toString() {
		return "[date] " + getValue();
	}

	@Override
	public void setValue(String value) {
		try {
			calendar.setTime(dateFormat.parse(value));
		} catch (ParseException e) {
			throw new CommandException(value + " is not correct Date format.Correct format is " + DATE_FORMAT_STR, e);
		}

	}

	@Override
	public Variable add(Variable var) {
		Variable result = new DateVariable();
		result.setValue(getValue());
		result.add(var.getValue());
		return result;
	}

	@Override
	public Variable substract(Variable var) {
		Variable result = new DateVariable();
		result.setValue(getValue());
		int num;
		try {
			num = Integer.parseInt(var.getValue());
		} catch (NumberFormatException e) {
			throw new CommandException(var.getValue() + " is not valid input. ", e);
		}
		result.substract(num);
		return result;
	}

}