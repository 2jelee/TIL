package quiz;

/*
[과제1] 논리연산, 교환알고리즘, if문 이용

숫자 3개를 입력받는다.
ex)
	3
	4
	5

단, 어떠한 순서대로 넣더라도 큰 순서대로 출력하는 프로그램 작성.
	ex) 5 4 3
*/

import java.util.Scanner;

public class Quiz_practice1 {
	public static void main(String[] args) {
		System.out.println("숫자 3개를 입력해주세요.");
		int a = new Scanner(System.in).nextInt();
		int b = new Scanner(System.in).nextInt();
		int c = new Scanner(System.in).nextInt();
		
		//총 경우의 수 : 3! = 6
		if(a>b) {
			if(a>c) { 
				if(b>c) System.out.println(a + " " + b + " " + c);	//1. a>b>c
				else System.out.println(a + " " + c + " " + b);		//2. a>c>b
			}
			else System.out.println(c + " " + a + " " + b);			//3. c>a>b
		} 
		else {
			if(c>b) System.out.println(c + " " + b + " " + a);		//4. c>b>a
			else {
				if(a>c) System.out.println(b + " " + a + " " + c);	//5. b>a>c
				else System.out.println(b + " " + c + " " + a);		//6. b>c>a
			}
		} 
	}
	
	/********************************************************************************/
	
	/*
	[과제1] 논리연산, 교환알고리즘, if문 이용
					   >> temp 변수를 통해 
	 */
}
