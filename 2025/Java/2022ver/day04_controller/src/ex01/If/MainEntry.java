package ex01.If;

import java.util.Scanner;

public class MainEntry {
	public static void main(String[] args) {
		System.out.println("integer data input : ");
		int su = new Scanner(System.in).nextInt();	// ★scanner 객체 생성과 동시에 함수 호출
		
		// 짝/홀수 판정 if
		/*
		if (su%2==0) {
			System.out.println("짝수(even)");
		} else {
			System.out.println("홀수(odd)");
		}
		
		System.out.println("---------------------");
		
		// 양수, 음수 0 판정 if
		if(su>0) {
			System.out.println("양수");
		} else if (su<0) {
			System.out.println("음수");
		} else System.out.println("0");
		
		System.out.println("---------------------");
		*/
		
		if (su%2==0) {
			System.out.println("짝수(even)");
			
			if(su>0) {
				System.out.println("양수");
			} 
			else if (su<0) {
				System.out.println("음수");
			} 
		} else {
			System.out.println("홀수(odd)");
			
			if(su>0) {
				System.out.println("양수");
			} 
			else if (su<0) {
				System.out.println("음수");
			}
			else System.out.println("0이다.");
		}
	} //out if end
}
