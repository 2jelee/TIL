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

class page54_MaxOfArrayRand {
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
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("키의 최댓값을 구합니다.");
		System.out.print("사람 수 : ");
		int num = sc.nextInt();
		
		int[] height = new int[num];

		System.out.println("키 값은 아래와 같다.");
		for (int i = 0; i < num; i++) {
			height[i] = 100 + rand.nextInt(90);			//요소의 값을 난수로 결정
			System.out.println("height[" + i + "] : " + height[i]);
		}
		System.out.println("최댓값은 " +maxOf(height)+"입니다.");
	} 
}