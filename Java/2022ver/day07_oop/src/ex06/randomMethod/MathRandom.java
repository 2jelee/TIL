package ex06.randomMethod;

public class MathRandom {
	public static void main(String[] args) {
		System.out.println(Math.PI);
		System.out.println(Math.E);
		System.out.println();
		
		//random() : random메소드는 난수발생 시킨다. 0.0~1.0
		System.out.println(Math.random());	//random에는 c++과 달리 초기화 하는 게 내장되어?있어 실행할때마다 새롭게 난수 발생시킨다.
		
		//특정 값(0 ~ n-1값) 출력을 원한다면
		//출력하고 싶은 특정값 0~4
		System.out.println(Math.random()*5); 
		
		//출력하고 싶은 특정값 1~5
		System.out.println((Math.random()*5)+1);
		
		System.out.println();
		System.out.print("오늘의 당첨번호 : ");
		for(int i=1; i<7; i++) {
//			System.out.println((Math.random()*45)+1);	 
			System.out.print((int)(Math.random()*45)+1+" ");	//Lotto는 뽑는 값이 0이 나올 수 없다.	>> +1
		}
		
		/*
		[문제] Lotto 6개 번호(1~45까지) 추첨 단, 같은 수 나올 수 없다.
		 */

		
	}

}
