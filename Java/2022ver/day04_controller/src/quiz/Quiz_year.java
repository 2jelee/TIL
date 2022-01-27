package quiz;

/*
[문제 2.] 윤년/평년 판점 프로그램 작성
if(year % 4 ==0)		>>필수
if(year % 100 != 0)||if(year % 400 == 0)	>>여기까지 둘 다 만족 시 윤년
*/

import java.util.Scanner;

/*
public class Quiz_year {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in).nextInt();
		int year = new Scanner(System.in).nextInt();
		
		if(year%4==0) {
			if(year%100 !=0 || year %400==0) {
				System.out.println("윤년입니다.");
			}
		} else System.out.println("평년입니다.");
	}
}
*/

/********************************************************/

public class Quiz_year {
	public static void main(String[] args) {
		//1. 변수선언
		int year;
		String str = "";
		boolean flag = false;		//flag를 통해 T/F 구분하여 출력하는 방식
		
		//2. 메세지 출력 및 입력받기
		System.out.println("연도 입력하시오.");
		year = new Scanner(System.in).nextInt();
		
		//3. 처리(계산)
		if ((year%4 == 0) && (year%100 != 0 || year%400 == 0)) { 
			flag = true;
		} //if end
		
		/*
		if(year%4==0) {
			if(year%100 !=0) || (year%400==0)
				flag = true;
		} //if end
		*/
		
		str = (flag == true) ? "윤년" : "평년";
		
		//4. 결과출력(화면)
		System.out.println(year + "년 => " + str);
	}
}

/********************************************************/

/*
public class Quiz_year {
	public static void main(String[] args) {
		System.out.println("연도 입력하시오.");
		int year = new Scanner(System.in).nextInt();
		
		if ((year%4==0) && (year%100 !=0 || year %400==0)) {
			System.out.println("윤년");
		} else System.out.println("평년");
	}
}
*/