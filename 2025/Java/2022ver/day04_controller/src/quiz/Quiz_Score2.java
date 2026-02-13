package quiz;

/*
[문제 3.] 전산, 영어, 국어 점수 입력 받아서 평균 60점 이상이고
각 과목 과락 40점 이하이면 과목 불합격 처리
*/

import java.util.Scanner;

/*
public class Quiz_Score2 {
	public static void main(String[] args) { 
		System.out.println("전산, 영어, 국어 순서대로 점수를 입력하세요.");
		int com = new Scanner(System.in).nextInt();
		int eng = new Scanner(System.in).nextInt();
		int kor = new Scanner(System.in).nextInt();
		int tot = com+eng+kor;
		int avg = tot/3;
		
		if(avg >= 60) {
			if(com<=40 || eng<=40 || kor<=40) {
				System.out.println("불합격");
			} else System.out.println("합격");
		} else System.out.println("불합격");
	}
}
*/

/****************************************************/

public class Quiz_Score2 {
	public static void main(String[] args) { 
		System.out.println("국어 : "); int kor = new Scanner(System.in).nextInt();
		System.out.println("영어 : "); int eng = new Scanner(System.in).nextInt();
		System.out.println("전산 : "); int com = new Scanner(System.in).nextInt();
		
//		double avg = (double)(kor+eng+com)/3;
		double avg = (kor+eng+com)/3.0;
		
		if(avg>=60) {
			if(kor>=40 && eng >=40 && com>=40) {
				System.out.printf("모든 과목이 40점 이상이며 평균이 %.2f로 \"합격\"입니다. \n", avg);
			} else {
				System.out.printf("평균은 %.2f 이지만, ", avg);
				if(kor<40) System.out.print("국어" + kor +"점");
				if(eng<40) System.out.print("영어" + eng +"점");
				if(com<40) System.out.print("전산" + com +"점");
				System.out.print("으로 \"과락탈락\"입니다. \n");
			} //in if end
		} else System.out.printf("평균이 %.2f로 \"평균미달 탈락\"입니다. \n", avg);
	} //out if end
}
