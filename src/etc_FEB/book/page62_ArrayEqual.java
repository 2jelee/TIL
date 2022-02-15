package etc_FEB.book;

/*
[두 배열의 비교] 
하나의 배열이 아니라 여러 배열을 처리하는 알고리즘.
두 배열의 "모든 요소의 값이 같은가"를 판단하는 메서드를 구현한 프로그램.

실행 결과 :
배열 a의 요소 수 : 5
a[0] : 10
a[1] : 73
a[2] : 2
a[3] : -5
a[4] : 42

배열 b의 요소수 : 5
b[0] : 10
b[1] : 73
b[2] : 2
b[3] : -5
b[4] : 42
배열 a와 b는 같습니다.
 */

import java.util.Scanner;

class page62_ArrayEqual { 
	// equals 메서드로 두 배열 a와 b의 모든 요소가 같은가 판단		>> 해당 메서드의 반환형(type)은 boolean형
	// 모든 요소의 값이 같으면 true, 그렇지 않으면 false 반환
	static boolean equals(int[] a, int[] b) {
		if(a.length != b.length) {
			return false;	// 두 배열 a, b의 요소수(길이)를 비교. 같지 않으면 false 반환
		}
		
		for (int i = 0; i < a.length; i++) {	// for문에서 두 배열을 처음부터 끝까지 스캔하면서 요소 a[i]와 b[i]의 값을 비교하는 것을 반복
												// 그 과정에서 값이 다른 요소를 발견하면 반환문을 실행하여 false를 반환
			if(a[i] != b[i]) {
				return false;
			}
		}
		return true;		// for문이 중단되지 않고 끝까지 실행된 경우이므로 두 배열은 같다고 판단 >> true 반환
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("배열 a의 요소수 : ");
		int na = sc.nextInt();
		int[] a = new int[na];
		
		for (int i = 0; i < na; i++) {
			System.out.print("a["+i+"] : ");
			a[i] = sc.nextInt();
		}
		
		System.out.print("배열 b의 요소수 : ");
		int nb = sc.nextInt();
		int[] b = new int[nb];
		for(int i=0; i<nb; i++) {
			System.out.print("b["+i+"] : ");
			b[i] = sc.nextInt();
		}
		
		System.out.println("배열 a와 b는 " + (equals(a,b) ? "같습니다." : "다릅니다."));
	}
}