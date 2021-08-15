package ex16exception;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
	/*	
	 	컴파일에러
		
		런타임에러    
	*/
		
		int a = 10;
		//Int b = 20;
		Scanner scanner = new Scanner(System.in);
		
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();
		
		System.out.println("num1/num2="+ (num1/num2));
		
	}

}




