package ch01;

import java.util.Scanner;

public class BOJ_1546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1. 변수 N에 과목의 수 입력받기 
		int N = sc.nextInt();
		
		// 2. 길이가 N인 1차원 배열 score[] 선언하기 
		// 점수를 1차원 배열에 저장 
		int score[] = new int[N];

		// 3. for문으로 score[] 길이만큼 반복
		// 배열을 탐색하며 최고 점수와 점수의 총합을 구하기 
		for (int i = 0; i < N; i++) {
			score[i] = sc.nextInt(); // 4. score[i]에 각 점수 저장 
		}
		
		long sum = 0; // 총합 
		long maxScore = 0; // 최고 점수 
		
		// 5. for문으로 score[] 길이만큼 반복
		for (int i = 0; i < N; i++) {
			//6. 최고점은 변수 maxScore에, 총점은 변수 sum에 저장 
			if (score[i] > maxScore) {
				maxScore = score[i];
			}
			sum += score[i];
		}
		
		// 총합*100 / 최고점수 / 과목의 수 를 계산하여 다시 계산한 점수의 평균값을 출력 
		// 한 과목과 관련된 수식을 총합한 후 관련된 수식으로 변환해 로직이 간단해진다. 
		System.out.println(sum * 100.0 / maxScore / N);
	}
}
