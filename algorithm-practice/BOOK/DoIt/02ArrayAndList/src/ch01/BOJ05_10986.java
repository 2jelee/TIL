package ch01;
 
import java.io.IOException;
import java.util.Scanner;

public class BOJ05_10986 {	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 수열의 갯수 
		int M = sc.nextInt(); // 나누어 떨어져야하는 갯수 
		long[] S = new long[N]; // 합 배열 
		long[] C = new long[M]; // 같은 나머지의 인덱스를 카운트하는 배열 
		long answer = 0;
		
		S[0] = sc.nextInt();
		for (int i = 1; i < N; i++) { // 수열 합 배열 만들기 
			S[i] = S[i-1] + sc.nextInt(); // 합 배열 저장 : S[i] = S[i-1] + A[i]
		}
		
		for (int i = 0; i < N; i++) {
			int remainder = (int)(S[i] % M); // 합 배열을 M으로 나눈 나머지 값 
			if (remainder==0) {
				answer++; // 정답을 1 증가 
			}
			C[remainder]++; // C[remainder]의 값을 1 증가 
			
		}
		for (int i = 0; i < M; i++) {
			if(C[i] > 1) { // C[i] (i가 나머지인 인덱스의 갯수)에서 2가지를 뽑는 경우의 수를 정답에 더하기 
				answer = answer + (C[i] * (C[i]-1)/2);
			}
		}
		System.out.println(answer);
	}
}
