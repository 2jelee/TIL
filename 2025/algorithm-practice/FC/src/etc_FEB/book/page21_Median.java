package etc_FEB.book;

import java.util.Scanner;

/*
[세 값의 중앙값] 
세 정수의 중앙값을 구한다.

실행 결과 :
a의 값 : 1
b의 값 : 3
c의 값 : 2
 */

class page21_Median {
	static int med3(int a, int b, int c) {
		if(a>=b)
			if(b>=c)
				return b;
			else if (a<=c)
				return a;
			else
				return c;
		else if(a>c)
			return a;
		else if(b>c)
			return c;
		else
			return b;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("세 정수의 값을 구합니다.");
		System.out.print("a의 값 : ");
		int a = sc.nextInt();
		System.out.print("b의 값 : ");
		int b = sc.nextInt();
		System.out.print("c의 값 : ");
		int c = sc.nextInt();
		
		System.out.println("중앙값은 " + med3(a,b,c)+ "입니다.");
	}
}
