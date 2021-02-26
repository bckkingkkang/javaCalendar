package practice;

import java.util.Scanner;

import java.text.ParseException;

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
	private void cmdRegister(Scanner s, Calendar c) throws ParseException {
		System.out.println("[ 새 일정 등록 (날짜를 입력해주세요 YYYY-MM-DD) ] : ");
		String date = s.next();
		String text = "";
		s.nextLine();
		System.out.println("일정을 입력해주세요 : ");
		text = s.nextLine();
		c.registerPlan(date, text);
	}
	
	
//	private void cmdRegister(Scanner s, Calendar c) throws ParseException {
//        System.out.println("[새 일정 등록]");
//        System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
//        String date = s.next();
//        String text = "";
//        s.nextLine(); //ignore one newline
//        System.out.println("일정을 입력해 주세요.");
//        text = s.nextLine();
//
//        c.registerPlan(date, text);
//    }
	
	
	
	private void cmdSearch(Scanner s, Calendar c) {
		System.out.println("[ 일정 검색 (날짜를 입력해주세요 YYYY-MM-DD) ] : ");
		String date = s.next();
		String plan = "";
		
		try {
			plan = c.searchPlan(date);
			System.err.println("일정 검색 중 오류 발생");
		} catch (ParseException e) {
			e.printStackTrace();
		}
			
		System.out.println(plan);
	} 
	
	
	public void runPrompt() throws ParseException {
		
		printMenu();
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
	
		while (true) {
			
			System.out.println("명령 (1, 2, 3, h, q)");
			
			String cmd = scanner.next();
			if ( cmd.equals("1") ) 
				cmdRegister(scanner, cal);
			else if ( cmd.equals("2") ) 
				cmdSearch(scanner, cal);
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
	
	public static void main(String[] args) throws ParseException {
		// 셀 실행
		Prompt p = new Prompt();
		p.runPrompt();
		
	}
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
