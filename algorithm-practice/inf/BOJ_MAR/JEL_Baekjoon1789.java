package etc_MAR; 

import java.util.Scanner;

public class JEL_Baekjoon1789 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if(sum > n) {
				break;
			}
			sum += i;
			cnt++;
		}
		System.out.println(cnt-1);
	}
}
