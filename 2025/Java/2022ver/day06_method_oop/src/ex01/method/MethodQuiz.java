package ex01.method;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
[문제4]
add(x, y), sub(-), mul(*), div(/)
 */

public class MethodQuiz {
//	/*
	Scanner sc = new Scanner(System.in);
	
	public static int add(int x, int y) {
		int sum = x+y;
		return sum;
	}

	public static int sub(int x, int y) {
		int sub = x-y;
		return sub;
	}

	public static int mul(int x, int y) {
		int gop = x*y;
		return gop;
	}
	
	public static void div(String result) {
		try {		
			result = x/y;
//			int div = x/y;
		} 
		catch (Exception e) {				//하위 error(예외) 위치
			System.out.println("예외처리");
		}
		
		return result;
	}
	 
	
	public static void main(String[] args) { 
		System.out.println(add(1, 3));
		System.out.println(sub(4, 3));
		System.out.println(mul(3, 3));
		System.out.println(div(1, 4));		
	}
//	*/
	
	/******************************************************************/
	
	
}
