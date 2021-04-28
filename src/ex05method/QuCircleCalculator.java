package ex05method;
/*
문제5-2) 파일명 : QuCircleCalculator.java (난이도:중)
원의 반지름을 파라메타로 전달하면 원의넓이와 둘레를 계산하여 반환하는 
메소드를 각각 정의하자. 이를 호출하는 main 메소드를 정의하라.

 */
public class QuCircleCalculator {
	//원의 넓이와 둘레는 원주율 3.14를 곱해야 하므로 
	//반환형은 실수로 정의한다.
	
	//넓이
	static double circleArea(double rad) {
		double result = 3.14 * rad * rad;		
		return result;
	}	
	//둘레
	static double circleRound(double rad) {
		return 2 * 3.14 * rad;
	}	
	
	public static void main(String[] args) {
		System.out.println("원의넓이:"+ circleArea(10.2));
		System.out.println("원의둘레:"+ circleRound(12.5));
	}
}

