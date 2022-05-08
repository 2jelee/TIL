package etc_FEB.book;

/*
[기수 변환] 
기수 : 수를 나타내는데 기초가 되는 수로, 10진법에서는 0~9까지의 정수를 말한다.
서수 : 사물의 순서를 나타내는 수
기수는 일, 이, 삼, ...
서수는 첫째, 둘째, 셋째, ...

10진수(Decimal) : 아래 10종류의 숫자를 사용하여 수를 나타냄
	0, 1, 2, 3, 4, 5, 6, 7, 8, 9 


실행 결과 : 
	10진수의 기수 변환
	변환하는 음이 아닌 정수 : 59
	어떤 진수로 변환? (2~36) : 2
	2진수로는 111011입니다.
	재시도? (1. 예 | 2. 아니오) : 0
 */

import java.util.Scanner;

class page69_CardConvRev {
	//정숫값 x를 r진수로 변환하여 배열 d에 아랫자리부터 넣어두고 자릿수를 반환
	static int cardConvR(int x, int r, char[] d) {
		int digits = 0;	//변환 후 자릿수
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		do {
			//x를 r로 나눈 나머지 인덱스로 하는 문자를 배열 d의 요소 d[digits]에 대입하고 digits 값을 증가시킴
			d[digits++] = dchar.charAt(x % r); //r로 나눈 나머지 저장
			x /= r;		
		} while(x!=0);	//x가 0이 될 때까지 반복
			return digits;
	}
	
 	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//변환하는 정수, 기수, 변환 후 자릿수 
		int no, cd, dno, retry;
		char[] cno = new char[32]; //변환 후 자리의 숫자를 넣어두는 문자의 배열
		
		System.out.println("10진수의 기수 변환");
		do {
			do {
				System.out.print("변환하는 음이 아닌 정수 : ");
				no = sc.nextInt();
			} while(no<0);
			
			do {
				System.out.print("어떤 진수로 변환? (2~36) : ");
				cd = sc.nextInt();
			} while(cd<2 || cd>36);
			
			dno = cardConvR(no, cd, cno); // no를 cd진수로 변환
			
			System.out.print(cd + "진수로는 ");
			//윗자리부터 차례로 나타냄
			for (int i = dno-1; i >= 0; i--) {
				System.out.print(cno[i]);
			}
			System.out.println("입니다.");
			
			System.out.print("재시도? (1. 예 | 2. 아니오) : ");
			retry = sc.nextInt();
		} while (retry == 1);
	}
}