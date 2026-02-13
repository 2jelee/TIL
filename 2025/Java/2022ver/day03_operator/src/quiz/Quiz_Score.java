package quiz;

import java.util.Scanner;

public class Quiz_Score {
	public static void main(String[] args) {
		//성적표 입력 받아서 총점, 평균 구하기
//		System.out.println("=====성적을 입력하세요(국어, 영어, 전산, 이름)=====");
//		
//		Scanner sc = new Scanner(System.in); 	// **입력객체생성, 메모리에 할당, 생성자 함수 자동호출
//												// Scanner sc; (X) 모든 언어는 선언을 해주어 할당시켜야한다.
//		int kor = sc.nextInt();
//		int en = sc.nextInt();
//		int com = sc.nextInt();
//		String name = sc.next();		// **nextLine()이 nextInt() 뒤에 있을 경우 입력이 불가하다. 그러므로 nextLine()을 nextInt()보다 위에 둔다면 정상적으로 입력이 된다.
//		System.out.println("총점 : " + (kor+en+com));
//		System.out.println("평균 : " + (kor+en+com)/3);
//		System.out.println("이름 : " + name);
		
		
		System.out.println("====================================================");
		Scanner sc2 = new Scanner(System.in); 	// **입력객체생성, 메모리에 할당, 생성자 함수 자동호출 
		
		System.out.println("이름 : ");
		String name2 = sc2.nextLine();
	
		System.out.println("국어, 영어, 전산");
		int kor2 = sc2.nextInt();					//이는 int kor = new Scanner(System.in).nextInt();로 해도 O (?바로 입력받아 사용하는 경우)
		int en2 = sc2.nextInt();
		int com2 = sc2.nextInt();
		int total = kor2 + en2 + com2;
		double avg = total/3.0;		//avg = (double)total/3;
		
		System.out.println("\n\n**** " + name2 + "님의 성적표 ****");
		System.out.println("국어 : " + kor2 + " 영어 : " + en2 + " 전산 : " + com2);
//		System.out.printf("총점 : %d 평균 : %f \n", total, avg);
		System.out.printf("총점 : %d 평균 : %1.2f \n", total, avg);			// 평균 %1.2 >> 소숫점 뒤 2자리		이는 .2라고 해도 O (1은 의미 X )		
																			// 만약 소숫점 뒤 3자리까지 표현? => %.3

		
	}
}
