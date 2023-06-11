package ch01;

/*
 *  [합 배열 공식]
 *  S[i] = S[i-1] + A[i]
 *  배열 A, 합 배열 S
 *  
 *  [구간 합 공식]
 *  S[j] + S[i-1]
 */
import java.io.*;
import java.util.StringTokenizer;

public class BOJ03_11659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 1. suNo : 숫자 갯수 | quizNo : 질의 갯수 저장하기 
		int suNo = Integer.parseInt(st.nextToken());
		int quizNo = Integer.parseInt(st.nextToken());
		long[] S = new long[suNo + 1];
		st = new StringTokenizer(br.readLine());
		
		// 2. for문으로 숫자 갯수만큼 반복 
		for (int i = 1; i <= suNo; i++) {
			// 3. 합 배열 생성하기 : S[i] = S[i-1] + A[i]
			S[i] = S[i-1] + Integer.parseInt(st.nextToken());
		}
		
		// 4. 질의 갯수만큼 반복 
		for (int q = 0; q < quizNo; q++) {
			// 5. 질의 범위 받기(i ~ j) 
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			// 6. 구간 합 출력하기 
			System.out.println(S[j] - S[i-1]);
		}
	}
}
