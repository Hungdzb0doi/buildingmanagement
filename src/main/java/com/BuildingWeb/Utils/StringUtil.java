package com.BuildingWeb.Utils;

public class StringUtil {
public static boolean CheckString(String value) {
	if(value!=null&&!value.equals("")) {
		return true;
	}else {
		return false;
	}
}
}
