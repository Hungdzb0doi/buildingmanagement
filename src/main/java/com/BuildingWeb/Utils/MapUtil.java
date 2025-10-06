package com.BuildingWeb.Utils;

import java.util.HashMap;

public class MapUtil {
	public static <T> T getObject(HashMap<String,Object> params,String key,Class<T> tclass) {
		Object ob= params.getOrDefault(key, null);
		if(ob!=null) {
			if(tclass.getTypeName().equals("java.lang.Integer")) {
				ob=ob!=null?Integer.valueOf(ob.toString()):null;
			}
			if(tclass.getTypeName().equals("java.lang.Long")) {
				ob=ob!=null?Long.valueOf(ob.toString()):null;
			}
			if(tclass.getTypeName().equals("java.lang.String")) {
				ob=ob.toString();
			}
		}
		return tclass.cast(ob);
	}
}
