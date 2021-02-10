package practice;

import java.util.Scanner;

public class Prompt {
	
	public void printMenu() {
		System.out.println("+-----------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색 ");
		System.out.println("| 3. 달력 보기 ");
		System.out.println("| h. 도움말  q. 종료");
		System.out.println("+-----------------+");
	}

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
		
		printMenu();
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
	
		while (true) {
			
			System.out.println("명령 (1, 2, 3, h, q)");
			
			String cmd = scanner.next();
			if ( cmd.equals("1") ) 
				cmdRegister();
			else if ( cmd.equals("2") ) 
				cmdSearch();
			else if ( cmd.equals("3") )
				cmdCal(scanner, cal);
			else if ( cmd.equals("h") )
				printMenu();
			else if ( cmd.equals("q") ) 
				break;
		}
		System.out.println("\n프로그램이 종료됩니다.");
		scanner.close();	
	}
	
	public static void main(String[] args) {
		// 셀 실행
		Prompt p = new Prompt();
		p.runPrompt();
	}
	
	private void cmdRegister() {}
	
	private void cmdSearch() {} 
	
	private void cmdCal(Scanner s, Calendar c) {
		
		int month = 1;
		int year = 1;
		
		System.out.println("연도를 입력하세요.");
		System.out.print("YEAR> ");
		year = s.nextInt();
		
		
		System.out.println("달을 입력하세요: ");
		System.out.print("MONTH> ");
		month = s.nextInt();
		if (month > 12 || month < 1 ) {
			System.err.println("잘못된 입력입니다.");
			return;
		}
		
		c.printCalendar(year, month);
		System.out.println();
	}

}
