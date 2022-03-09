package ex04;

import java.util.Scanner;

public class DoWhile {
	public static void main(String[] args) {
		int input = 0, answer = 0;
		
		answer = (int)(Math.random()*100)+1;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.print("1~100사이의 정수를 입력하세요. : ");
			input = sc.nextInt();
			
			if(input > answer) {
				System.out.println("더 작은 수로 재시도하시오. ");
			} else if (input < answer){
				System.out.println("더 큰 수로 재시도하시오. ");
			}
		} while(input!=answer);
		System.out.println("정답입니다.");
	}
}
