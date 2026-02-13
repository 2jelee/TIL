package quiz;

import java.util.Scanner;

public class Quiz_Score {
	public static void main(String[] args) {
	//성적표 국어, 영어, 전산, 이름 받아서 출력
	Scanner sc = new Scanner(System.in);
	
	System.out.print("name = ");
	String name = sc.nextLine();
	
	System.out.println("kor, eng, com, score = ");
	int kor = sc.nextInt();
	int eng = sc.nextInt();
	int com = sc.nextInt();
	
	int tot = kor + eng + com;
	double avg = tot / 3.0; //avg =(double)tot / 3;
	
	//학점(평점) : A ~ F학점 	-Q.if 이용하기
	char grade = '';	//학점 저장할 변수
	/*
	if (avg >= 90) {
		System.out.println("A");
	} if (avg >= 80) {
		System.out.println("B");
	} if (avg >=70) {
		System.out.println("C");
	} if (avg >=60) {
		System.out.println("D");
	} if (avg < 60) {
		System.out.println("F");
	}
	*/
	
	/******************************/
	
	if(avg>=90) grade='A';			//if(avg < 101 && avg >= 90) grade='A';
	else if(avg>=80) grade='B';		//else if(avg<=89 && avg >=80) grade='B';
	else if(avg>=70) grade='C';		
	else if(avg>=60) grade='D';
	else grade='F';

	/******************************/

	System.out.println("\n\n**** " + name + "님의 성적표 ****");
	System.out.println("국어 : " + kor + " 영어 : "+ eng + " 전산 : " + com);
	System.out.printf("총점 : %d 평균 : %.2f %c학점 \n", tot, avg, grade);
	
	}
}
