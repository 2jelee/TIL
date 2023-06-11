package etc_MAR;

// 실패

import java.util.HashMap;
import java.util.Scanner;

public class JEL_2776 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int T = sc.nextInt();
		for(int i = 0; i < T; i++){
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			int num1 = sc.nextInt();
			for(int j = 0; j < num1; j++){
				int n1 = sc.nextInt();
				map.put(n1, 1);
			}
			
			int num2 = sc.nextInt();
			for(int j = 0; j < num2; j++){
				int n2 = sc.nextInt();
				if(map.containsKey(n2)) {
					System.out.println(1);
				}
				else {
					System.out.println(0);
				}
			}
		}
	}
}