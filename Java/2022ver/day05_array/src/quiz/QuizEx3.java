package quiz;

/*
 * rererererererererere
 */

import java.util.Scanner;

public class QuizEx3 {
	public static void main(String[] args) {
		int[][] a = new int[3][4];
		Scanner sc = new Scanner(System.in);
		
		System.out.println("array data 3row(행), 4col(열)");
		
		//input
		for(int i=0; i<3; i++) {		//행
			for(int j=0; j<4; j++) {	//열
				System.out.print("a["+i+"]["+j+"] = ");
				a[i][j] = sc.nextInt();
			} //j end
		} //i end
		else {
			for(int j=0; i<4;j++) {
				b[i][j] = b[i-2][j] + b[i-1][j];
			}
		}
		System.out.println();
		
		
		//output
		for(int i=0; i<3; i++) {
			for(int j=0; j<4; j++) {
				System.out.print(a[i][j] + "\t");
			} 
			System.out.println();
		}
		System.out.println();
	}
}
