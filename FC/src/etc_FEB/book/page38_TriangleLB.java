package etc_FEB.book;

import java.util.Scanner;

/*
[직각 이등변 삼각형 출력] 
이중 루프를 응용하면 기호를 늘어놓아 삼각형이나 사각형 모양으로 출력할 수 있다.
왼쪽 아래가 직각인 이등변 삼각형을 출력하는 프로그램
변수 n에 입력하는 값을 양수로 제한한다.

왼쪽 아래가 직각인 이등변 삼각형을 출력합니다.

실행 결과 :
몇 단 삼각형입니까? 5
*
**
***
****
*****

 */

public class page38_TriangleLB {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		
		System.out.println("왼쪽 아래가 직각인 이등변 삼각형을 출력합니다.");
		
		do {
			System.out.println("몇 단 삼각형입니까?");
			n = sc.nextInt();
		} while(n <=0 );
		
		for (int i = 1; i <= n; i++) {
			for(int j=1; j<=i; j++) 
				System.out.print("*"); 
			System.out.println();
		}
	}
}