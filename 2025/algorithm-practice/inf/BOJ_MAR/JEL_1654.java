package etc_MAR;

import java.util.Scanner;

public class JEL_1654 { 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
 
		int K = sc.nextInt(); //가지고 있는 랜선의 갯수
		int N = sc.nextInt(); //필요한 개수
		int max = 0;
		int[] arr = new int[K];
		
		for (int i = 0; i < K; i++) { //랜선 길이가 최댓값인지 확인
			arr[i] = sc.nextInt();
			if(max < arr[i]) {
				max = arr[i]; //max 갱신
			}
		}   
		max++; // ***반드시 max에서 +1 값
 
		int min = 0;
		int mid = 0; 
 
		/**************************************/
		while (min < max) {  
			mid = (max + min) / 2; //중간 길이
			int count = 0;
			
			for (int i = 0; i < arr.length; i++) {
				count += (arr[i] / mid);
			}
			 
			if(count < N) {
				max = mid;
			}
			else {
				min = mid + 1;
			} 
		} 
		System.out.println(min - 1);
	}
} 