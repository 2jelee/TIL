package ch01;

// 시간 복잡도 판별 원리 2 - 연산 횟수가 3N인 경우 
// 연산 횟수는 3배 차이가 나지만, 코테에서는 일반적으로 상수를 무시하므로 두 코드 모두 시간 복잡도는 O(n)으로 같다. 
/*
 * [시간 복잡도 도출 기준]
 * 1. 상수는 시간 복잡도 계산에서 제외한다. 
 * 2. 가장 많이 중첩된 반복문의 수행 횟수가 시간 복잡도의 기준이 된다. 
 */
public class Time02 {
	public static void main(String[] args) {
		int N = 100000;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			System.out.println("연산 횟수 : "+ cnt++);
		}
		for (int i = 0; i < N; i++) {
			System.out.println("연산 횟수 : "+ cnt++);
		}
		for (int i = 0; i < N; i++) {
			System.out.println("연산 횟수 : "+ cnt++);
		}
	}
}
