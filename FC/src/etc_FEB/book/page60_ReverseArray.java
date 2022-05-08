package etc_FEB.book;

import java.util.Random;
import java.util.Scanner;

/*
[난수 사용해 배열의 요솟값 설정하기] 

실행 결과 :
키의 최댓값을 구합니다.
사람 수 : 5
height[0] : 172
height[1] : 137
height[2] : 168
height[3] : 189
height[4] : 113
최댓값은 189입니다.
 */

class page60_ReverseArray {
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1]; a[idx1] = a[idx2]; a[idx2]=t;
	}
	
	static void reverse(int[] a) {
		for (int i = 0; i < a.length / 2; i++) {
			swap(a, i, a.length-i-1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("요소 수 : ");
		int num = sc.nextInt();
		
		int[] x = new int[num];
		
		for (int i = 0; i < num; i++) {
			System.out.print("x["+i+"] : ");
			x[i] = sc.nextInt();
		}
		
		reverse(x); //배열 a의 요소를 역순으로 정렬
		
		System.out.println("요소를 역순으로 정렬했습니다.");
		for (int i = 0; i < num; i++) {
			System.out.println("x["+i+"] = " + x[i]);
		}
	}
}