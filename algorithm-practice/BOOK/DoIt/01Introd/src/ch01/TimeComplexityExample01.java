package ch01;
 
// 시간 복잡도
/*
 * [시간 복잡도 유형]
 * 1. 빅-오메가 : 최선일 때 연산 횟수를 나타낸 표기
 * 2. 빅-세타 : 보통일 때 연산 횟수를 나타낸 표기
 * 3. 빅-오 : 최악일 때 연산 횟수를 나타낸 표기 << 코테에서는 빅-오 표기법을 기준으로 수행 시간을 계산하는 것이 좋다.
 * 
 * 시간 복잡도는 항상 최악일 때, 즉 데이터의 크기가 가장 클 때를 기준으로 한다.
 * 
 * [연산 횟수 계산 방법]
 * 연산 횟수 = 알고리즘 시간 복잡도 X 데이터의 크기 
 */
public class TimeComplexityExample01 {
	public static void main(String[] args) {
		int findNumber = (int)(Math.random()*100);
		for (int i = 0; i < 100; i++) {
			if(i==findNumber) {
				System.out.println(i);
				break;
			}
		}
	}
}
