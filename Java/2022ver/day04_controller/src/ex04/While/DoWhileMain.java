package ex04.While;

import java.util.Scanner;

public class DoWhileMain {
	public static void main(String[] args) {
		/*
		 * do~while문으로 작성
		 * su 정수 데이터 1개 입력받아서 0~100 사잇값만 입력 받아서 출력하는 프로그램 작성
		 */
		
		Scanner sc = new Scanner(System.in);
		int su;
		
		do {
//			int su = sc.nextInt();
			su = sc.nextInt();
			System.out.println(su);
//			su++;
		} while(su<=100 && su>=0);
		System.out.println("0~100 사잇값이 아니다.");
	}
}
