package practice;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public class Calendar {

	private static final int[] MAX_DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	private HashMap <Date, String> planMap;
	
	public Calendar() {
		planMap = new HashMap<Date, String>();
	}
	
	public void registerPlan(String strDate, String plan) throws ParseException {
		Date date = new SimpleDateFormat("YYYY-MM-DD").parse(strDate);
		// System.out.println(date);
		planMap.put(date, plan);
	}
	
	public String searchPlan(String strDate) throws ParseException {
		Date date = new SimpleDateFormat("YYYY-MM-DD").parse(strDate);
		String plan = planMap.get(date);
		return plan;
	}
				
	public boolean isLeapYear(int year) {
		if( year % 4 == 0 && year % 100 != 0 || year % 400 == 0) 
			return true;
		else 
			return false;
	}
	
	public int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month];
		} else {
			return MAX_DAYS[month];
		}
	}
	
	public void printCalendar(int year, int month) {
		System.out.printf("   <<%4d년%3d월>>\n", year, month);
		System.out.println(" 일  월  화  수  목 금  토");
		System.out.println("---------------------");
	
		// get weekday automatically
		int weekday = getWeekday(year, month, 1);
		
		// print blank space
		for ( int i = 0; i < weekday; i++) {
			System.out.print("   ");
		}
		int maxDay = getMaxDaysOfMonth( year, month);
		
		int count = 7 - weekday; 
		int delim = (count < 7) ? count : 0;
/*		//if (count < 7 ) {
			delim = count;
		} else {
			delim = 0;
		}
		delimiter : 텍스트의 개시, 종료를 표시하는 것
*/		
		for ( int i = 1; i <= count; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();
		
		count++;
		
		// print from second line to last
		for(int i = count; i <= maxDay; i++ ) {
			System.out.printf("%3d", i);
			if( i % 7 == delim ) {
				System.out.println();
			}
		}
		System.out.println();
	}

	private int getWeekday(int year, int month, int day) {
		int syear = 1970;
		final int STANDARD_WEEKDAY = 4; // 목요일
		
		int count = 0;
		
		for(int i = syear; i < year; i++ ) {
			int delta = isLeapYear(i) ? 366 : 365;
			count += delta;
		}
		
		//System.out.println(count);
		for( int i = 0; i < month; i++ ) {
			int delta = getMaxDaysOfMonth(year, i);
			count += delta;
		}
		
		count += day -1;
		
		int weekday = ( count + STANDARD_WEEKDAY ) % 7 ;
		
		return weekday;
	}
	// simple test code here
	public static void main(String[] args) throws ParseException{
		Calendar cal = new Calendar();
		System.out.println(cal.getWeekday(1970, 1, 1) == 4);
		System.out.println(cal.getWeekday(1971, 1, 1) == 5);
		System.out.println(cal.getWeekday(1972, 1, 1) == 6);
		System.out.println(cal.getWeekday(1973, 1, 1) == 1);
		System.out.println(cal.getWeekday(1974, 1, 1) == 2);
		
		cal.registerPlan("2021-02-10", "Study JAVA");
		System.out.println(cal.searchPlan("2021-02-10").equals("Study JAVA"));
	}
}
