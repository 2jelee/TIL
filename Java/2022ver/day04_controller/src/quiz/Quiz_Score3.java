package quiz;

import java.util.Scanner;

/*
 * Q. 점수는 0~100점 사이의 점수만 입력받기
 * 	  Y / N로 원하는만큼 입력받기
 */
  
public class Quiz_Score3 {	
	public static void main(String[] args) {   
		// 성적표 국어, 영어, 전산, 이름, 입력 받아서 총점, 평균
		Scanner sc = new Scanner(System.in);  // 입력 객체 생성, 메모리에 할당, 생성자함수자동호출
			
		System.out.print("name = ");
		String name = sc.nextLine();
		
		System.out.print("kor, eng, com score = ");
		int kor = sc.nextInt();		int eng = sc.nextInt();		int com = sc.nextInt();
		
		int tot = kor + eng + com;
		double avg = tot / 3.0 ;  // avg = (double)tot / 3; 
		
		// 학점(평점)  : A ~ F학점 - if 이용
//				char grade = ' ';
//				if( avg <101 && avg >= 90 ) grade = 'A';     //if( avg >= 90 ) grade = 'A';
//				else if( avg <= 89 &&  avg >= 80 ) grade = 'B';					//else if( avg >= 80 ) grade = 'B';
//				else if( avg >= 70 ) grade = 'C';
//				else if( avg >= 60 ) grade = 'D';
//				else  grade = 'F';
		
		// 학점(평점)  : A ~ F학점 - switch 이용
		char grade;
		
		switch( (int) avg / 10 ) {  //switch( total / 30 ) {
			case 10: 
			case 9 : grade = 'A'; break;
			case 8 :	grade = 'B'; break;
			case 7 : grade = 'C'; break;
			case 6 : grade = 'D'; break;
			default : grade = 'F';
	} // end switch
		
		System.out.println("\n\n****  " +name +"님의 성적표 **********");
		System.out.println("국어 : " + kor + " 영어 : " + eng + " 전산 : " + com);
		System.out.printf("총점 : %d 평균 : %.2f  %c 학점 \n", tot, avg, grade );
			
		System.out.println("계속 입력 받겠습니까? (Y/N)");
		flag = sc.next().charAt(0);		//char
		if(flag=='n'|| flag=='N') break; //탈출구문		// char type << '' 가 맞는가? 다시 확인하기 22/01/28
		
		flag = sc.next();				//String
		if(flag.equalsIgnoreCase("n")) break;			// .equalsIgnoreCase() : 대소문자 구분 X
		if(flag.equals("n")||flag.equals("N")) break;	// .equals() : 비교?
		if(flag.toUpperCase().equals("N")) break;		// .toUpperCase() : 소문자 n을 쓰든지말든지 대문자로 변환시키겠다.
		
		sc.close();
	}
}
//*/







 
