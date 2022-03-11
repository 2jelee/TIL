package ex05;

import java.util.Arrays;

public class Arrays01 {
	public static void main(String[] args) {
		int[] iArr1 = new int[10];
		int[] iArr2 = new int[10];
		int[] iArr3 = {100, 95, 80, 70, 60};
		char[] chArr = {'a', 'b', 'c', 'd'};
		
		for (int i = 0; i < iArr1.length; i++) {
			// 1~10까지의 숫자를 순서대로 배열에 넣기
			iArr1[i] = i + 1;
//			System.out.println(iArr1[i]);
		}

		for (int i = 0; i < iArr2.length; i++) {
			// 1~10까지의 값을 배열에 저장
			iArr2[i] = (int)(Math.random()*10)+1;
//			System.out.println(iArr2[i]);
		}
		
		for (int i = 0; i < iArr1.length; i++) {
			System.out.print(iArr1[i]+", ");
		}
		System.out.println();
		
		System.out.println("iArr2 : " + Arrays.toString(iArr2));
		System.out.println("iArr3 : " + Arrays.toString(iArr3));
		System.out.println("chArr : " + Arrays.toString(chArr));
		System.out.println("iArr3 : " + iArr3);
		System.out.println(chArr);
	}
}
