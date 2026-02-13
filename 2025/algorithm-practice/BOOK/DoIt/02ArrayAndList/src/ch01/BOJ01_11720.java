package ch01;

import java.util.*;

public class BOJ01_11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1. N값 입력받기 
		int	N = sc.nextInt();
		
		// 2. 길이 N의 숫자를 입력받아 String형 변수 cNum에 변환하여 저장 
		// 입력값을 String형 변수 sNum에 저장한 후 char[]형 변수로 변환하기 
		String sNum = sc.next();
		
		// 3. sNum을 다시 char []형 변수 cNum에 변환하여 저장 
		char[] cNum = sNum.toCharArray();
		
		// 4. int형 변수 sum 선언 
		int sum = 0;
		
		// 5. for문으로 cNum의 길이만큼 반복 
		for (int i = 0; i < cNum.length; i++) {
			// 6. 배열의 각 자릿값을 정수형으로 변환하며 sum에 더하여 누적 
			sum += cNum[i] - '0'; // cNum[i]를 정수형으로 변환하면서 sum에 더하여 누적하기
		}
		System.out.println(sum);
	}
}
