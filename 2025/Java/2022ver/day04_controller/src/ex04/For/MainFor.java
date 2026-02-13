package ex04.For;

/*
 *  열로 출력
 */

public class MainFor {
	public static void main(String[] args) {
		
		/*
		int dan=1, su=1;
		
		for(int i=1; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				System.out.print(dan+" x "+j+" = "+(dan*j));
			}
			System.out.println(su+" x "+i+" = "+(su*i));
		}
		*/
		
		/************************************************/
		
		for (int i = 1; i <= 9; i++) { 		//row : 행
			for (int j=1; j<= 9; j++) { 	//col : 열
//				System.out.print(j+" x "+i+" = "+(j*i) + "\t");
				System.out.printf("%d * %d = %2");
			}
			System.out.println();
		} 
	}
}
