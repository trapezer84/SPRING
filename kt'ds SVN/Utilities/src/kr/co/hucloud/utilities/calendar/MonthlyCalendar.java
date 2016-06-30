package kr.co.hucloud.utilities.calendar;

import java.util.HashMap;
import java.util.Map;

public class MonthlyCalendar {

	/**
	 * 지정 연도
	 */
	private int year;
	
	/**
	 * 지정 월
	 */
	private int month;
	
	/**
	 * 지정 연도와 지정 월의 가장 마지막 날짜 (윤달 계산)
	 */
	private int maximumDate;
	
	/**
	 * 일과 요일
	 * key = 일, value = 월
	 * value = 1 : 일요일
	 * value = 2 : 월요일
	 * value = 3 : 화요일
	 * value = 4 : 수요일
	 * value = 5 : 목요일
	 * value = 6 : 금요일
	 * value = 7 : 토요일
	 */
	private Map<Integer, Integer> days;
	
	/**
	 * 음력날짜
	 */
	private Map<Integer, String> chinaDate;
	
	public MonthlyCalendar(int year, int month, int maximumDate) {
		this.year = year;
		this.month = month;
		this.maximumDate = maximumDate;
		this.days = new HashMap<Integer, Integer>();
		this.chinaDate = new HashMap<Integer, String>();
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getMaximumDate() {
		return maximumDate;
	}
	public void setMaximumDate(int maximumDate) {
		this.maximumDate = maximumDate;
	}
	public Map<Integer, Integer> getDays() {
		return days;
	}
	public void setDays(Map<Integer, Integer> days) {
		this.days = days;
	}
	public void setDay(int date, int week) {
		this.days.put(date, week);
	}

	public Map<Integer, String> getChinaDate() {
		return chinaDate;
	}
	public String getChinaDate(int day) {
		return chinaDate.get(day);
	}
	
	public void setChinaDate(Map<Integer, String> chinaDate) {
		this.chinaDate = chinaDate;
	}
	public void setChinaDate(int day, String chinaDate) {
		this.chinaDate.put(day, chinaDate);
	}
	
}











