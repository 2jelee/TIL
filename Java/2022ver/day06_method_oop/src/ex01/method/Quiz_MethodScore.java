package ex01.method;

import java.util.Scanner;

/*
[문제5]
성적처리 프로그램 함수로 분할(분리)할 것
입력함수 input() - 이름, 국어, 영어, 전산 점수
총점함수 total(~~) - 총점 구하는 함수
평균함수 average(~~) - 평균 구하는 함수
평점(학점) grade(~~) - 학점 구하는 함수
출력 함수 output() - 결과를 출력하는 함수
*/

public class Quiz_MethodScore {
	
	public static void input(int kor, int eng, int com) {
		Scanner sc = new Scanner(System.in);
		kor = sc.nextInt();
		eng = sc.nextInt();
		com = sc.nextInt();
//		return kor, eng, com;
	} 
	
	public static void total() {
		input(kor, eng, com);
		sum = kor + eng + com;
	}
	
	public static void main(String[] args) { 
		int kor, eng, com;
		System.out.println(input(kor, eng, com));
		System.out.println(sub(4, 3));
		System.out.println(mul(3, 3));
		System.out.println(div(1, 4));		
	}
	
	/******************************************************************/
	
	
}
