package ex04controlstatement;
/*
문제1) 다음과 같은 모양을 출력하는 프로그램을 while문으로 작성하시오.
파일명 : Qu_04_06.java
*
* *
* * *
* * * *
* * * * *


 */
public class Qu_04_06 {

	public static void main(String[] args) {

		System.out.println("방법1");
		int i=1;
		while(i<=5) {			
			int j=1;
			while(j<=5) {//무조건 25번 반복하여 실행함.
				if(i>=j) {
					System.out.print("* ");
				}
				j++;
			}			
			System.out.println();
			i++;
		}
		
		
		System.out.println("방법2");
		i=1;//동일한 지역에 동일한 변수는 생성할수 없다.
		while(i<=5) {			
			int j=1;
			while(j<=i) {//j는 i의 크기만큼 반복하므로 15번만 반복하면 됨.
				System.out.print("* ");				
				j++;
			}			
			System.out.println();
			i++;
		}
	}
}
