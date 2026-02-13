package etc_MAR;

/*
[문제]
옛날 옛적에 수학이 항상 큰 골칫거리였던 나라가 있었다. 이 나라의 국왕 김지민은 다음과 같은 문제를 내고 큰 상금을 걸었다.
길이가 N인 정수 배열 A와 B가 있다. 다음과 같이 함수 S를 정의하자.
S = A[0] × B[0] + ... + A[N-1] × B[N-1]
S의 값을 가장 작게 만들기 위해 A의 수를 재배열하자. 단, B에 있는 수는 재배열하면 안 된다.

S의 최솟값을 출력하는 프로그램을 작성하시오.

[입력]
첫째 줄에 N이 주어진다. 
둘째 줄에는 A에 있는 N개의 수가 순서대로 주어지고, 셋째 줄에는 B에 있는 수가 순서대로 주어진다. 
N은 50보다 작거나 같은 자연수이고, A와 B의 각 원소는 100보다 작거나 같은 음이 아닌 정수이다.

[출력]
첫째 줄에 S의 최솟값을 출력한다.

[힌트]
예제 1의 경우 A를 {1, 1, 0, 1, 6}과 같이 재배열하면 된다.
*/

//int -> String : String.valueOf(int 값); || Integer.toString(int값);
//String -> int : Integer.valueOf(String 값);


import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Main1026 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		ArrayList<Integer> arrA = new ArrayList<>();
		ArrayList<Integer> arrB = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();
			arrA.add(a);
		}
		
		for(int i = 0; i < n; i++) {
			int b = sc.nextInt();
			arrB.add(b);
		}

		Collections.sort(arrA); //오름차순 정렬
//		Collections.reverse(arrB); // X => 리스트 구성 뒤집기
		Collections.sort(arrB, Comparator.reverseOrder());
		
		for(int i = 0; i < n; i++) {
			sum += arrA.get(i) * arrB.get(i);
		}
		
		System.out.println(sum);
	}
}
