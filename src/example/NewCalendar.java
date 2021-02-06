package example;

import java.util.Scanner;

public class NewCalendar {

	public void printSampleCalendarMonth28() {
		System.out.println("일  월  화  수  목 금 토");
		System.out.println("--------------------");
		System.out.println(" 1  2  3  4  5  6  7");
		System.out.println(" 8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
		System.out.println();
	}
	public void printSampleCalendarMonth30() {
		System.out.println("일  월  화  수  목 금 토");
		System.out.println("--------------------");
		System.out.println(" 1  2  3  4  5  6  7");
		System.out.println(" 8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
		System.out.println("29 30");
		System.out.println();
	}
	public void printSampleCalendarMonth31() {
		System.out.println("일  월  화  수  목 금 토");
		System.out.println("--------------------");
		System.out.println(" 1  2  3  4  5  6  7");
		System.out.println(" 8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
		System.out.println("29 30 31");
		System.out.println();
	}

	public static void main(String[] args) {
		String PROMPT = "cal> ";

		int month = 1;
	
		Scanner scanner = new Scanner(System.in);
		NewCalendar cal = new NewCalendar();
		
		while(true) {
			System.out.println("달을 입력하세요.");
			System.out.print(PROMPT);
			month = scanner.nextInt();	
			if( month == 2 ) {
				cal.printSampleCalendarMonth28();
				continue;
			}
			else if(month == 4 || month == 6 || month == 9 || month ==11 ) {
				cal.printSampleCalendarMonth30();
				continue;
			}
			else if(month == -1) {
				System.out.println("프로그램을 종료합니다.");
			}
			else {
				cal.printSampleCalendarMonth31();
				continue;
		
			}
		}	
	}
}
