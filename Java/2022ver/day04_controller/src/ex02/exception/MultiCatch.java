package ex02.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/* Catch문은 다중으로 사용 가능하다! */

public class MultiCatch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x, y, result=0;

		System.out.println("integer data 2 input : ");

		try {
			x = sc.nextInt();		//웬만해서는 try 안에 넣는다. (제외: 선언하는거)	 
			y = sc.nextInt();

			result = x / y;			//문제발생 있음
			System.out.println(x + " / " + y + " = " + result);
			
		// ★ Exception사용한다면 다(퉁쳐서) 수행한다.		<< 예외처리의 최상위는 Exception
		// ★ 하위 Error는 코드의 위에, (최)상위 Error는 하단에 둔다.
		} 
		catch (InputMismatchException e) {				//하위 error(예외) 위치
			System.out.println("InputMismatchException에서 걸렸다.");
		} 
		catch (ArithmeticException e) {					//하위 error(예외) 위치
			System.out.println("ArithmeticException에서 걸렸다.");
		} 
		catch (RuntimeException e) {					//상위 error(예외) 위치	
			System.out.println("RuntimeException에서 걸렸다.");
		} 
		catch (Exception e) {							//최상위 error(예외) 위치	
			System.out.println("Exception에서 걸렸다.");
		} 
		finally {		//즉, 정상종료/비정상종료 모두 출력
			System.out.println("finally 무조건 출력!");
		}
	} 
	
	/*****
	finally의 필요성 :  
		exception가 발생하든 발생하지 않든, 무조건 수행하는 부분이 바로 finally 영역.
		이는 뒤에서 Database처리나 File처리를 한다면 꼭 필요한 부분임.
		이유? Database를 열었다거나 or File을 열었다면 꼭 닫아주고 Prog가 종료되어야 하기 때문.
	*****/
	
	
}
