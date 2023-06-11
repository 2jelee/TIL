package etc_FEB.book;

import java.util.Scanner;

/*
 * [한 해의 경과 일수를 계산하는 프로그램]
 * 
 * 2차원 배열을 활용하여 어떤 날짜의 "그 해의 경과 일 수를"를 구해보자.
 * ex. 4/15일을 예로 들어 그 해의 경과 일 수 계산법
 * 		: 1월의 일 수 + 2월의 일 수 + 3월의 일 수 + 15
 * 
 * 일반적으로 나타내면 m월 n일의 그 해 결과 일수는
 * 	: 1월, 2월, ... m-1월의 일 수의 합 + d
 * 
 * 단, 2월의 일 수는 평년은 28일, 윤년은 29일로 해에 따라 달라진다.
 * 2행 12열의 2차원 배열 mdays에 각 달의 일 수를 저장할 수 있다.
 * 
 * 평년의 각 달의 일수
 * 	: mdays[0][0], mdays[0][1], ... , mdays[0][11]
 * 윤년의 각 달의 일수
 * 	: mdays[1][0], mdays[1][1], ... , mdays[1][11]
 * 
 * 윤년 구하는 방법 => %4 = 0 윤년
 * 					   %100 = 0, %400 != 0 평년
 * 
 * static int[][] mdays = {
 * 	{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, //평년
 *  {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}  //윤년
 * }
 * 
실행 결과 :    
	그 해 경과 일수 구하기
	연도 : 2019
	월 : 3
	일 : 15
	그 해 74일째입니다. 
	다시 알아보기? (1 : 예 / 0 : 아니오)
	0
 */

class page82_DayOfYear {
	//각 달의 일수
	static int[][] mdays = {
		{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, //평년
		{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}  //윤년
	};
	
	// 해당 method는 매개변수(year)로 전달받은 연도가 윤년이면 1을, 평년이면 0을 반환
	static int isLeap(int year) {
		return (year%4 == 0 && year%100 != 0 || year%400 == 0) ? 1 : 0;
	}
	
	static int dayOfYear(int y, int m, int d) {
		int days = d;
		
		//1월 ~ (m-1)월의 일 수를 더함
		for(int i=1; i<m; i++) 
			days += mdays[isLeap(y)][i-1]; //윤년:1, 평년:0 
		return days;
	}

//public class page82_DayOfYear {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int retry;
		
		System.out.println("그 해 경과 일수 구하기");
		
		do {
			System.out.print("연도 : "); int year = sc.nextInt(); //연
			System.out.print("월 : "); int month = sc.nextInt(); //월
			System.out.print("일 : "); int day = sc.nextInt(); //일
			
			System.out.printf("그 해 %d일째입니다. \n", dayOfYear(year, month, day));
			
			System.out.println("다시 알아보기? (1 : 예 / 0 : 아니오)");
			retry = sc.nextInt();
		} while(retry==1);
	}
}