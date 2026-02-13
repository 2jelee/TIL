package ex05;

/*
 * 배열 arr에 담긴 모든 값을 더하는 프로그램을 구현하시오.
 */

public class Practice03 {
	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50};
		int sum = 0;
		
//		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
			sum += arr[i];
		}
		System.out.println("sum = " + sum);
	}
}
