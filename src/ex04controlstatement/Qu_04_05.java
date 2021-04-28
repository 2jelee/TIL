package ex04controlstatement;
/*
문제5) 아래 코드를 삼항연산자를 사용하지 말고 if~else문으로 변경해보자.
파일명 : Qu_04_05.java

 */
public class Qu_04_05 {

	public static void main(String[] args) {
		int num1=50, num2=100;
		int big, diff;

		//big = (num1>num2)? num1:num2; //조건?참:거짓;
		if(num1>num2) {
			big = num1;
		}
		else {
			big = num2;			
		}
		
		System.out.println(big);

		//diff = (num1>num2)? num1-num2: num2-num1;
		if(num1>num2) 
			diff = num1-num2;
		else
			diff = num2-num1;
		//if문의 실행문장이 1개일때는 중괄호를 생략할수있다.
			
		System.out.println(diff);
	}

}
