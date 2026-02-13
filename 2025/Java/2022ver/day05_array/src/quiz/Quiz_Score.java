package quiz;

import java.util.Scanner;

/*
 * [문제3] 성적표 프로그램 작성 (배열 이용)
 * 이름, 국어, 영어, 전산점수 입력받아서 총점, 평균, 학점(평점) 구하는 프로그램 구현
 * cf) 석차 구할 수 있음.
 */

public class Quiz_Score {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		 
		String[] st = new String[3];
		String name = sc.next();
		String grade = ""; 
		st[0] = name;
		st[1] = grade;
		
		int[] arr = new int[4];
		System.out.println("KOR 점수 입력 : ");
		int kor = sc.nextInt();
		System.out.println("eng 점수 입력 : ");
		int eng = sc.nextInt();
		System.out.println("com 점수 입력 : ");
		int com = sc.nextInt();
		int total = kor+eng+com;
		int avg = total/3;
		 
		arr[0] = kor;
		arr[1] = eng;
		arr[2] = com;
		arr[3] = total;
		arr[4] = avg;
		 
		System.out.println(name);
		
		
//		
//		String[] arr = new String[7];
//		System.out.print("이름을 입력하세요 : ");
//		String name = sc.next();
////		int kor = sc.nextInt();
////		int eng = sc.nextInt();
////		int com = sc.nextInt();
////		int total = kor+eng+com;
//		
//		name = arr[0];
//		
//		System.out.println(arr[0]);
		
		
		
	}
}
