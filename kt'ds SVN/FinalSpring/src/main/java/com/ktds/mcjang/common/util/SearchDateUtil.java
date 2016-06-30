package com.ktds.mcjang.common.util;

import java.util.Calendar;

public class SearchDateUtil {

	public static String getYear(Calendar cal, Object obj) {
		
		String result = "";
		
		if(obj == null) {
			result = cal.get(Calendar.YEAR) + "";
		}
		else {
			result = obj.toString();
		}
		
		return result;
		
	}
	
	public static String getMonth(Calendar cal, Object obj) {
		
		String result = "";
		
		if(obj == null) {
			result = (cal.get(Calendar.MONTH) + 1) + "";
		}
		else {
			result = obj.toString();
		}
		
		return result;
		
	}

	public static String getDay(Calendar cal, Object obj) {
		
		String result = "";
		
		if(obj == null) {
			result = cal.get(Calendar.DAY_OF_MONTH) + "";
		}
		else {
			result = obj.toString();
		}
		
		return result;
		
	}
	
}
