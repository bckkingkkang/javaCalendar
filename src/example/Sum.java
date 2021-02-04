package example;
import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		
		int a, b;
		
		System.out.println("두 수를 입력하세요.");
		
		Scanner scanner = new Scanner(System.in); //System.in : 키보드로 입력을 받는다.
		
		String s1, s2;
		s1 = scanner.next();
		s2 = scanner.next();
		
		a = Integer.parseInt(s1);
		b = Integer.parseInt(s2);
		
		// System.out.println(a + ", " + b);
		
		System.out.println("두 수의 합은 "+ (a + b) + "입니다.");
		// System.out.printf("두 수의 합은 %d입니다.", a+b );
		
		scanner.close();
	}
}
 