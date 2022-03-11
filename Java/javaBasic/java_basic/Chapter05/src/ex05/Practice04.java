package ex05;

/*
 * 2차원 배열 arr에 담긴 모든 값의 총합과 평균을 구하시오.
 */

public class Practice04 {
	public static void main(String[] args) {
		int[][] arr = { 
						{5, 5, 5, 5, 5},
						{10, 10, 10, 10, 10},
						{20, 20, 20, 20, 20},
						{30, 30, 30, 30, 30}				
					 };
		
		int total = 0;
		float avg = 0;
		
		for (int i = 0; i < arr.length; i++) { 
//			System.out.println(arr[i][0]);
			for (int j = 0; j < arr[i].length; j++) {
//				System.out.println(arr[i][j]);
				total += arr[i][j];
			}
//			avg = (float)total / arr[i].length;
//			avg = total / (float)arr[i].length;
		}
		// ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
//		System.out.println(arr.length);    //4
//		System.out.println(arr[0].length); //5
		avg = total / (float)(arr.length * arr[0].length);
		
		System.out.println("total : " + total);
		System.out.println("avg : " + avg);
	}
}
