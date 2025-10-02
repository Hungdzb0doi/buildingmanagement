package com.BuildingWeb.Utils;

public class NumberUtil {
public static boolean IsNumber(String Value) {
	
	try {
		Integer.parseInt(Value);
	}catch(NumberFormatException e) {
		return false;
		}
	
	return true;
}
}
