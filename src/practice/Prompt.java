package practice;

import java.util.Scanner;

public class Prompt {
	
	private final static String PROMPT = "cal> ";

	public void runPrompt() {
		
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
	
		int month = 1;
		
		while (true) {
			System.out.println("달을 입력하세요: ");
			System.out.print(PROMPT);
			
			month = scanner.nextInt();
			if (month == -1) {
				break;
			}
			if (month > 12 ) {
				continue;
			}
			System.out.printf("%d월은 %d일까지 있습니다.\n", month, cal.getMaxDaysOfMonth(month));
			
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
