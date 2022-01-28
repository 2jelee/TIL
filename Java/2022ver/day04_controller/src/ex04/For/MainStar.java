package ex04.For;

/*
 *  열로 출력
 */

public class MainStar {
	public static void main(String[] args) {
		
		//[1번]
		/*
		for (int i=0; i < 5; i++) { 		//row : 행
			for (int j=0; j< 5; j++) { 		//col : 열
				if(i>=j) System.out.print("*");
				else System.out.print(" ");
//				System.out.println("*");
			}
			System.out.println();
		} 
		*/
		
		/*
		for (int i=0; i < 5; i++) { 		//row : 행
			for (int j=0; j<=i; j++) { 		//col : 열
				System.out.print("*");
			}
			System.out.println();
		}
		*/
		
		/*************************************************/
		
		//[4번]
		/*
		for (int i=0; i < 5; i++) { 		//row : 행
			for (int j=0; j< 5; j++) { 		//col : 열
				if(i<=j) System.out.print("*");
				else System.out.print(" ");
//				System.out.println("*");
			}
			System.out.println();
		}
		*/
		
		/*************************************************/
		
		//[3번]		>> for문 3개 사용(1, 2? 같은 경우 왼쪽 벽에 붙어나오므로 for문 2개로 가능)
		/*
		for (int i=0; i < 5; i++) { 		//row : 행(회전수)
			for (int j=0; j<5; j++) { 		//col : 열공백출력후
				if(i+j>=4) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		*/ 
		
		/*************************************************/
		
		//[5번]
//		/*
		for (int i=0; i < 5; i++) { 		//row : 행(회전수)

		}
//		 */ 
		
		
		
	}
}
