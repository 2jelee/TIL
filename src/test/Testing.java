package test;

import java.util.InputMismatchException;
import java.util.Scanner;

//무한루프 내에서 예외처리후 생기는 문제 해결방법
public class Testing {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while(true) {		
			
			try {
				System.out.println("메뉴를 입력하세요:");
				int in = scanner.nextInt();				
				if(in==9) break;	
			}
			catch (InputMismatchException e) {}
						
			System.out.println("게임계속...");
		}		
		System.out.println("끄읕~~~");
	}
}