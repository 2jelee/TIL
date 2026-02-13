package quiz;

/*
[과제2] 사칙연산 프로그램 작성하기(예외처리하기)
숫자 2개 입력받고, 연산자(+,-,*,/) 1개 입력받아서
(if, switch 이용, 예외처리)

ex)
	3
	5
	+

3 + 5 = 8
*/

import java.util.Scanner;

public class Quiz_practice2 {
	public static void main(String[] args) {
		
		try {
			System.out.println("숫자 2개를 입력해주세요.");
			int a = new Scanner(System.in).nextInt();
			int b = new Scanner(System.in).nextInt();
			System.out.println("계산할 연산자를 입력하세요(선택 : +,-,*,/)");
			String c = new Scanner(System.in).next();
			int result = 0;		//담을 변수 선언

			switch (c) {
				case "+":
					result = a+b; 
					break;
				case "-":
					result = a-b;
					break;
				case "*":
					result = a*b;
					break;
				case "/":
					result = a/b;
					break; 
				default:
					System.out.println("제대로 입력해주세요.");
					break;
			}
			System.out.println(a +" "+ c +" "+ b + " = " + result);
			
		} catch(Exception e) {
			System.out.println("예외 발생! : " + e); 
		}
	}
}
