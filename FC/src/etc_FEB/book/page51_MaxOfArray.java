package etc_FEB.book;

import java.util.Scanner;

/*
[배열 요소의 최댓값을 구하는 메서드]
배열의 요소를 구하는 절차는 별도의 메서드 maxOf로 구현.
이 메서드는 인수로 받은 배열 a의 최댓값을 구하고 그 값을 반환. 

실행 결과 :
키의 최댓값을 구합니다.
사람 수 : 5
height[0] : 172
height[1] : 153
height[2] : 192
height[3] : 140
height[4] : 165
최댓값은 192입니다.
 */

class page51_MaxOfArray {
	static int maxOf(int[] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if(a[i] > max) {
				max = a[i]; 
			}
		}
		return max;
	}
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("키의 최댓값을 구합니다.");
		System.out.print("사람 수 : ");
		int num = sc.nextInt();
		
		int[] height = new int[num];
		
		for (int i = 0; i < num; i++) {
			System.out.print("height[" + i + "] : ");
			height[i] = sc.nextInt();
		}
		System.out.println("최댓값은 " +maxOf(height)+"입니다.");
	} 
}
