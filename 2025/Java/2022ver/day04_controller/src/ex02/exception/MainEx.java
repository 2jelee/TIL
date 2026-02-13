package ex02.exception;

import java.util.Scanner;

public class MainEx {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x, y, result=0;

		System.out.println("integer data 2 input : ");
		x = sc.nextInt();		 
		y = sc.nextInt();

		try {
			result = x / y;			//문제발생 있음
			
			System.out.println(x + " / " + y + " = " + result);
			
		} 
		catch(Exception e) {
			e.printStackTrace();				 
		}
		finally {		//문제가 생기든 안생기든 무조건 출력되는 (즉, 정상종료/비정상종료 모두 출력)
			System.out.println("finally 무조건 출력");
		}
	} 
	
	
}
