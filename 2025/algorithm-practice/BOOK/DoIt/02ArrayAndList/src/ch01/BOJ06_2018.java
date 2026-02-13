package ch01;

import java.util.Scanner;

public class BOJ06_2018 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		// 사용 변수 초기화 (4가지)
		int count = 1;
		int start_index = 1;
		int end_index = 1;
		int sum = 1;
		
		while (end_index != N) {
			if (sum == N) {
				count++;
				end_index++;
				sum = sum + end_index; // sum값 변경 
			} else if (sum > N) {
				sum = sum - start_index; // sum값 변경 
				start_index++;
			} else {
				end_index++;
				sum = sum + end_index; // sum값 변경 
			}
		}
		System.out.println(count);
	}
}
