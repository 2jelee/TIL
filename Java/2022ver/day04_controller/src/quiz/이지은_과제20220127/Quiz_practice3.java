package quiz;

import java.util.Scanner;

/*
[과제3_문제5] 원하는 단을 입력받아서 구구단 출력하는 프로그램 작성		 
ex) 5 입력 시,
 	5 * 1 = 5
 	5 * 2 = 10
	5 * 3 = 15
*/
public class Quiz_practice3 {
	public static void main(String[] args) {
		System.out.print("출력하고 싶은 단을 입력하세요!");
		Scanner sc = new Scanner(System.in);
		int dan = sc.nextInt();
		System.out.print("*****"+dan+"단 출력하기*****\n");
		for(int i=1; i<=9; i++) {
			System.out.println(dan+" x "+i+" = "+(dan*i));
		}
	}
}
