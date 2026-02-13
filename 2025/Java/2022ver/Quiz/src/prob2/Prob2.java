package prob2;

import java.util.Random;

public class Prob2 {
	public static void main(String[] args) {
		int num = generateRandom();
		System.out.println("생성된 정수 : " + num);
		if (primeNumber(num)) {
			System.out.println("---> 소수입니다.");
		} else {
			System.out.println("---> 소수가 아닙니다.");
		}
	}

	private static int generateRandom() {
		// 구현하세요.
		Random random = new Random();
		random.nextInt();
		
		
		return random;
	}

	private static boolean primeNumber(int num) {
		if(num%2==0) {
			return false;
		} else {
			return true;
		}
//		return false;
	}
}