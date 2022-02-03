package ex04.sort;

import java.util.Arrays;

public class ArraysSort {
	public static void main(String[] args) {
		int[] a = {7, 3, 5, 2, 8}; //1차원배열
		int temp; //빈값
		
		//배열이므로 for문으로 출력
		System.out.println("===sort 전 출력===");
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+"\t");
		}

		//sort 
		Arrays.sort(a);	//정렬 알고리즘이 이미 내부적으로 처리되어 있는 메소드
		
		//배열이므로 for문으로 출력
		System.out.println("=== sort 후 출력 ===");
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+"\t");
		}
		
		System.out.println("내림차순");
		for(int i=a.length-1; i>=0; i--) {
			System.out.print(a[i]+"\t");
		}
	}
} 
