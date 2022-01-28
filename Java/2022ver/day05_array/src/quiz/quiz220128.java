package quiz;

import java.util.Scanner;

public class quiz220128 {
//	/*
		
		/*
		Q1.
		1차원배열에 다음과 같은 data가 있다.
		int[] a = {1, 7, 5, 7, 2, 8, 7, 9, 12, 5, 7, 99};
		int seek = 7;	>> 7의 갯수를 구해라.
		*/ 
		
	/*
	public static void main(String[] args) {

		int[] a = {1, 7, 5, 7, 2, 8, 7, 9, 12, 5, 7, 99};
		int seek = 7;
		int sum=0;								//담아줄 변수
		
		for(int i=0; i<a.length; i++) {
			if(a[i]==seek) {
				sum = sum+1;					//Java >> 계산 시 하나씩 증가 ★★★count느낌...
			}
		} 
		System.out.println(sum);
	} 
	*/	
	
	/**********************************************************/
	
	/*
	Q2.
	기상청
			1월의 평균 강수량 구하는 프로그램 작성.
	 		(단, 일수는 30일 기준)
	 
	int NUM(상수) = 3;							<<일수가 3이면 3만큼 나누면 된다.
	int[] arr = new int[30_NUM];				<< index
	*/
	
	/*
	public static void main(String[] args) {
		System.out.println("일수를 입력하세요.");
		int num = new Scanner(System.in).nextInt();		//ex. 3일을 입력하겠다.
		int[] arr = new int[num];						//	  3개크기를 생성
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = new Scanner(System.in).nextInt();
//			System.out.println(mm/num);
		}
		
	}
//	*/
	public static void main(String[] args) {
		
		int NUM = 3;
		double[] su = new double[NUM];
		double avg = 0;
		int sum = 0;
		
		for(int i=0; i<su.length; i++) {
			System.out.println((i+1)+"일 강수량은?");
			su[i] = new Scanner(System.in).nextDouble();
			sum += su[i];
		}
		
		avg = (double)(sum/su.length);
		System.out.println("강수량평균 : "+avg+"ml");
	}
} 
