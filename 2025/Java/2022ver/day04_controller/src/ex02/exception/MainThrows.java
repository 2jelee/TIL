package ex02.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/* Throws >> 로직에 치중하겠다면, */
/* Class Throwable >> lang 패키지이므로 import 필요 X */


public class MainThrows {
	
	//예외를 발생시키겠다는 의미.		>> throws Exception
//	public static void main(String[] args) throws Exception {
	
	
	//예외를 발생시키겠다는 의미.		>> throws Exception
//	>> 예외처리 위임
	public static void main(String[] args) 
			throws ArithmeticException, InputMismatchException {	//몇개든 상관 X (이들 일일이 지정하기 싫 -> 최상위인 Exception 사용 O)
		Scanner sc = new Scanner(System.in);
		int x, y, result = 0;

		System.out.println("integer data 2 input : ");

		x = sc.nextInt(); 
		y = sc.nextInt();
		
		result = x / y;			//문제발생 있음
		System.out.println(x + " / " + y + " = " + result);
		
	} 
}

/*****
[class]
java.lang.Object			<< Object 가장 최상위
	java.lang.Throwable
		java.lang.Exception

------

public class Exception
extends Throwable

*****/
