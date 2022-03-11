package ex05;

import java.util.Arrays;

public class ArraysEx04 {
	public static void main(String[] args) {
		int[] ball = new int[45]; //45개의 정수값 저장할 배열 생성
		
		for (int i = 0; i < ball.length; i++) {
			ball[i] = i+1; 		// ball[0]에 1이 저장됨
		}
		
		int temp=0;
		int j=0; //임의의 값을 얻어서 저장할 변수
		
		for (int i = 0; i < 6; i++) {
			j = (int)(Math.random()*45); // Math~ 괄호로 반드시 묶어주자
			temp = ball[i];
			ball[i] = ball[j];
			ball[j] = temp;
		}
//		System.out.println(Arrays.toString(ball));
		
		// 배열 ball의 앞에서부터 6개의 요소 출력
		for (int i = 0; i < 6; i++) {
			System.out.printf("ball[%d]=%d%n", i, ball[i]);
		}
	}
}
