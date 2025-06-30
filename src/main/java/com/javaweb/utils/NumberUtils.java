package com.javaweb.utils;

public class NumberUtils {
	public static boolean isLong(String value) {
		if(value == null)return false;
		try { 
			Long numBer = Long.parseLong(value);
		}
		catch(NumberFormatException ex) {
			return false;
		}
		return true;
	}

	public static boolean isValue(Object value) {
		if(value instanceof String) {
			return !((String)value).isEmpty();
		}
		if(value instanceof Long) {
			return true;
		}
		return false;
	}
}

