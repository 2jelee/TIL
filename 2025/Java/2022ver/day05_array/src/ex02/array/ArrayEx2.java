package ex02.array;

import java.util.Scanner;

public class ArrayEx2 {
	public static void main(String[] args) {
		int[][] a = new int[2][3];
		Scanner sc = new Scanner(System.in);

//		int x=sc.nextInt();
//		System.out.println("x = "+x);
		
		System.out.println("array data 2row(행), 3col(열)");
		
		//input
		for(int i=0; i<2; i++) {
			for(int j=0; j<3; j++) {
				System.out.print("a["+i+"]["+j+"] = ");
				a[i][j] = sc.nextInt();
			} //j end
		} //i end
		System.out.println();
		
		
		//output
		for(int i=0; i<2; i++) {
			for(int j=0; j<3; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
}
