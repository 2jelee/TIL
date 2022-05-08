package ch01;

// 시간 복잡도 판별 원리 1 - 연산 횟수가 N인 경우 
public class Time01 {
	public static void main(String[] args) {
		int N = 100000;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			System.out.println("연산 횟수 : "+ cnt++);
		}
	}
}
