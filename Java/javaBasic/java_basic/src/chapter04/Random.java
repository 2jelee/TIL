package chapter04;

/*
임의의 정수 만들기
Math.random() - 0.0과 1.0사이의 임의의 double값을 반환
0.0 <= Math.random() < 1.0

[원하는 범위 안에 있는 값을 얻고 싶을 때]
	원하고자 하는 값 ex. 1~3 사이의 정수
	1. 각 변에 '3'을 곱함			>> 곱하는 숫자는 원하는 개별값의 "갯수"	>> 즉, 1,2,3을 얻고 싶으므로 총 3개
		0.0 <= Math.random() * 3 < 3.0
	2. 각 변을 int형으로 변환한다
  		(int)0.0 <= (int)(Math.random() * 3) < (int)3.0
	3. 각 변에 1을 더한다								>> 덧셈/뺄셈으로 범위 바꿔준다.
		0+1 <= (int)(Math.random() * 3) +1 < 3+1
 		1 <= (int)(Math.random() * 3) + 1 < 4
*/
public class Random {
	public static void main(String[] args) {
		int num=0;
		
		/*
		//[Quiz] 1~10 사이의 난수를 20개 출력하시오.
		for(int i=1; i<=20; i++) {
//			System.out.println(Math.random());
//			System.out.println(Math.random() * 10); // 0.0<=x<1.0
//			System.out.println((int)(Math.random() * 10)); // 0.0<=x<10.0
			
			//1~10을 구하고 싶을 때
			System.out.println((int)(Math.random() * 10)+1); // 1<=x<11, 1~10
		}
		*/

		//[Quiz] -5~5 사이의 난수를 20개 출력하시오.
//		for(int i=-5; i<=10; i++) {		//10개 X : -5, -4, -3, ... , 0, 1, 2, 3, ..., 5 >> 11개임
//			System.out.println(((Math.random())*10)+1); // 1<=x<11, 1~10
//		}
		for(int i=1; i<=20; i++) {
//			System.out.println((Math.random()*11)+1); //0<=x<11, 0~10
			System.out.println((int)(Math.random()*11)-5); //-5<=x<6, -5~5		>> 덧셈/뺄셈으로 범위 바꿔준다.
		}

		/*
		[예제]
//		//괄호 {} 안의 내용을 5번 반복
//		for(int i=0; i<=5; i++) {
//			System.out.println(Math.random());
////			num=(int)(Math.random()*6)+1;
////			System.out.println(num);
//		}
		*/
	}	//end of Main
}