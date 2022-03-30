package etc_MAR;

import java.util.Scanner;

public class JEL_Baekjoon1439 {
	public static void main(String[] args) {
		int zero = 0;
		int one = 0;
		Scanner sc = new Scanner(System.in); 
		String s = sc.nextLine();
		String[] arr = s.split("");
		
		if(arr[0].equals("0")) {
			zero++;
		} else {
			one++;
		}
		
		for (int i = 1; i < arr.length; i++) {
			if(!arr[i-1].equals(arr[i])) {
				if(arr[i].equals("0")) {
					zero++;
				} else {
					one++;
				}
			}
		}
		System.out.println(Math.min(zero, one)); 
	}
}
