package ex05;

import java.util.Arrays;

/*
 * 1~9사이의 중복되지 않은 숫자로 이루어진 3자리 숫자를 만들어내는 프로그램을 완성시켜라.
 */

public class Practice05 {
	public static void main(String[] args) {
		int[] ballArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] ball3 = new int[3];
		
		// 배열 ballArr의 임의의 요소를 골라서 위치를 바꾼다.
		for (int i = 0; i < ballArr.length; i++) {
			int j = (int)(Math.random()*ballArr.length);
			int temp = 0;
			
			// 구현 1
			temp = ballArr[i];
			ballArr[i] = ballArr[j];
			ballArr[j] = temp;
		}
		
		//배열 ballArr의 앞에서 3개의 수를 배열 ball3으로 복사한다.
		// 구현 2
//		ball3 = Arrays.copyOfRange(ballArr, 0, 4);
		System.arraycopy(ballArr,0, ball3,0,3);
		
		for (int i = 0; i < ball3.length; i++) {
			System.out.print(ball3[i]);
		}
	}
}
