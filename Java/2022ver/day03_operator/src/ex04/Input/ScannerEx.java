package ex04.Input;

import java.util.Scanner;

public class ScannerEx {
	public static void main(String[] args) {
		System.out.println("next() vs nextLine()");
		System.out.println("string input : ");
		Scanner sc = new Scanner(System.in);	// () : default 생성자 함수(매개변수를 아무것도 안가지고 있는)
//		String s1 = sc.next();		//next는 공백을 인식 X >> 만약 console에 Lee Jieun이라고 치면 Lee만 나온다.
		String s2 = sc.nextLine();
		System.out.println(s2);
		
		System.out.println("=========================");
		
	}
}
