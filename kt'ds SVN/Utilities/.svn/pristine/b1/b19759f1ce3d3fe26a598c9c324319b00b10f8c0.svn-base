package kr.co.hucloud.utilities.calendar;

import java.util.Calendar;

import com.ibm.icu.util.ChineseCalendar;

public class Scheduler {

	/**
	 * 지정한 연도와 월의 날짜정보를 가져온다.
	 * 
	 * <style>
		table.calendar {
			border-collapse: collapse;
			border: 1px solid #333333;
		}
		table.calendar td {
			border: 1px solid #cccccc;
			padding: 15px;
			text-align: left;
			height: 100px;
			width: 75px;
			vertical-align: top;
		}
		table.calendar tr.days td {
			background-color: #f3f3f4;
			font-weight: bold;
			vertical-align: middle;
			text-align: center;
		}
		table.calendar td.sunday {
			font-weight: bold;
			color: red;
		}
		table.calendar td.saturday {
			font-weight: bold;
			color: blue;
		}
		table.calendar td span.vacation {
			padding: 3px 15px 3px 15px;
			border-radius: 15px;
			background-color: #f3f3f4;
			font-size: 9pt;
			color: #333333;
		}
	</style>
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static MonthlyCalendar getScheduler(int year, int month) {
		
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, 1);
		
		int maximumDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		MonthlyCalendar calendar = new MonthlyCalendar(year, month, maximumDate);
		
		// 1 == 일요일
		// 2 == 월요일
		// 3 == 화요일
		// 4 == 수요일
		// 5 == 목요일
		// 6 == 금요일
		// 7 == 토요일
		int week = 0;
		for(int i = 1; i < (maximumDate + 1); i++) {
			cal.set(year, month - 1, i);
			week = cal.get(Calendar.DAY_OF_WEEK);
			calendar.setDay(i, week);
			calendar.setChinaDate(i, GetChineseCalendar.getChineseDate(cal));
		}
		
		return calendar;
		
	}
	
	public static String drawCalendar(int year, int month) {
		
		MonthlyCalendar cal = getScheduler(year, month);
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("<table class='calendar'>\n\t<tr class='days'>");
		sb.append("\n\t\t<td class='sunday'>일</td>\n\t\t<td>월</td>\n\t\t<td>화</td>\n\t\t<td>수</td>\n\t\t<td>목</td>\n\t\t<td>금</td>\n\t\t<td class='saturday'>토</td>\n\t</tr>");
		sb.append("\n\t<tr>");
		
		int cell = 0;
		int startDay = cal.getDays().get(1);
		String vacations = "";
		String[] vacationName = new String[2];
		
		for(int i = 1; i < startDay; i++) {
			cell++;
			if(cell == 1) {
				vacations = " class='sunday'";
			}
			else {
				vacations = "";
				
			}
			sb.append("\n\t\t<td" + vacations + ">&nbsp;</td>");
		}
		
		int i = 1;
		for(i = 1; cell < 7; i++) {
			cell++;
			if(cell == 7) {
				vacations = " saturday";
			}
			else {
				vacations = "";
			}
			
			vacationName[0] = Vacation.getKoreanVacation(month, i);
			if ( vacationName[0].length() > 0 ) {
				vacations = " sunday";
			}
			
			vacationName[1] = Vacation.getChineseVacation(cal.getChinaDate(i));
			if ( vacationName[1].length() > 0 ) {
				vacations = " sunday";
			}
			
			sb.append("\n\t\t<td class='" + i + vacations + "'>" + i + "<br/>");
			for(String vacation : vacationName) {
				if ( vacation.length() > 0 ) {
					sb.append("<span class='vacation'>"+vacation+"</span><br/>");
				}
			}
			sb.append("</td>");
		}
		sb.append("\n\t</tr>\n\t<tr>");
		
		cell = 0;
		for(int j = i; j <= cal.getMaximumDate(); j++) {
			cell++;
			
			if(cell == 1) {
				vacations = " sunday";
			}
			else if(cell == 7) {
				vacations = " saturday";
			}
			else {
				vacations = "";
			}
			
			vacationName[0] = Vacation.getKoreanVacation(month, j);
			if ( vacationName[0].length() > 0 ) {
				vacations = " sunday";
			}
			
			vacationName[1] = Vacation.getChineseVacation(cal.getChinaDate(j));
			if( vacationName[1].length() > 0 ) {
				vacations = " sunday";
			}
			
			sb.append("\n\t\t<td class='" + j + vacations + "'>" + j + "<br/>");
			for(String vacation : vacationName) {
				if ( vacation.length() > 0) {
					sb.append("<span class='vacation'>"+vacation+"</span><br/>");
				}
			}
			sb.append("</td>");
			
			if(cell % 7 == 0) {
				cell = 0;
				sb.append("\n\t</tr>\n\t<tr>");
			}
		}
		
		for(i = 1; cell < 7; i++) {
			cell++;
			if(cell == 7) {
				vacations = " class='saturday'";
			}
			else {
				vacations = "";
			}
			sb.append("\n\t\t<td" + vacations + ">&nbsp;</td>");
		}
		
		sb.append("\n\t</tr>\n</table>");
		
		return sb.toString();
	}
	
	private static class GetChineseCalendar {
		
		public static String getChineseDate(Calendar calendar) {
			ChineseCalendar chinaCal = new ChineseCalendar();
			
			chinaCal.setTimeInMillis(calendar.getTimeInMillis());
			int chinaYY = chinaCal.get(ChineseCalendar.EXTENDED_YEAR) - 2637 ;
			int chinaMM = chinaCal.get(ChineseCalendar.MONTH) + 1;
			int chinaDD = chinaCal.get(ChineseCalendar.DAY_OF_MONTH);

			String chinaDate = "" ;		// 음력 날짜
			
			chinaDate += chinaYY ;		// 년
			chinaDate += "-" ;			// 연도 구분자
			
			
			if(chinaMM < 10)			// 월
				chinaDate += "0" + Integer.toString(chinaMM) ;
			else
				chinaDate += Integer.toString(chinaMM) ;
			
			
			chinaDate += "-" ;			// 날짜 구분자
			
			
			if(chinaDD < 10)			// 일
				chinaDate += "0" + Integer.toString(chinaDD) ;
			else
				chinaDate += Integer.toString(chinaDD) ;

			
			return chinaDate;

		}
		
	}
	
	public static void main(String[] args) {
		//MonthlyCalendar calendar = getScheduler(2015, 9);
//		for ( int i = 1; i <= calendar.getMaximumDate(); i++ ) {
//			System.out.println(i);
//			System.out.println(calendar.getDays().get(i));
//		}
		System.out.println(drawCalendar(2015, 12));
	}
	
}
