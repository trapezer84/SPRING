package kr.co.hucloud.utilities.calendar;

import java.util.HashMap;
import java.util.Map;

public class Vacation {

	public static Map<String, String> chineseVacations;
	public static Map<String, String> koreanVacations;
	
	static {
		chineseVacations = new HashMap<String, String>();
		chineseVacations.put("12-31", "설날");
		chineseVacations.put("01-01", "설날");
		chineseVacations.put("01-02", "설날");
		chineseVacations.put("04-08", "부처님 오신날");
		chineseVacations.put("08-14", "추석");
		chineseVacations.put("08-15", "추석");
		chineseVacations.put("08-16", "추석");
		
		koreanVacations = new HashMap<String, String>();
		koreanVacations.put("01-01", "신정");
		koreanVacations.put("03-01", "3.1절");
		koreanVacations.put("05-05", "어린이날");
		koreanVacations.put("06-06", "현충일");
		koreanVacations.put("08-15", "광복절");
		koreanVacations.put("10-03", "개천절");
		koreanVacations.put("10-09", "한글날");
		koreanVacations.put("12-25", "크리스마스");
	}
	
	public static String getChineseVacation(String chineseDate) {
		
		String[] date = chineseDate.split("-");
		chineseDate = date[1] + "-" + date[2];
		String result = chineseVacations.get(chineseDate);
		return result == null ? "" : result.toString();
	}
	
	public static String getKoreanVacation(int month, int day) {
		
		String monthStr = "0";
		if ( month < 10 ) {
			monthStr = "0" + month;
		}
		else {
			monthStr = month + "";
		}
		
		String dayStr = "0";
		if ( day < 10 ) {
			dayStr = "0" + day;
		}
		else {
			dayStr = day + "";
		}
		
		String koreanDate = monthStr + "-" + dayStr;
		
		String result = koreanVacations.get(koreanDate);
		return result == null ? "" : result.toString();
	}
	
}
