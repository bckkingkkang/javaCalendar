package practice;

import java.util.Scanner;

public class Prompt {
	public int parseDay(String week) {
		if   	(week.equals("일"))	return 0;
		else if (week.equals("월"))	return 1;
		else if (week.equals("화"))	return 2;
		else if (week.equals("수"))	return 3;
		else if (week.equals("목"))	return 4;
		else if (week.equals("금"))	return 5;
		else if (week.equals("토"))	return 6;
		else						return 0;
	}

	public void runPrompt() {
		
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
	
		int month = 1;
		int year = 1;
		int weekday = 1;
		
		while (true) {
			System.out.println("연도를 입력하세요(exit: -1): ");
			System.out.print("YEAR> ");
			year = scanner.nextInt();
			if ( year == -1 ) {
				break;
			}
			
			System.out.println("달을 입력하세요: ");
			System.out.print("MONTH> ");
			month = scanner.nextInt();
			if (month > 12 || month < 1 ) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			
			System.out.println("1일에 해당하는 요일을 입력하세요: ");
			System.out.print("WEEKDAY> ");
			String str_weekday = scanner.next();
			System.out.println();
			weekday = parseDay(str_weekday);
			
			cal.printCalendar(year, month,weekday);
			System.out.println();
		}
		System.out.println("\n프로그램이 종료됩니다.");
		scanner.close();
	}
	
	public static void main(String[] args) {
		// 셀 실행
		Prompt p = new Prompt();
		p.runPrompt();
	}
}
