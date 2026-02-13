package ex16exception;

import java.io.IOException;
/*
예외처리방법3
	: 예외가 발생한 위치에서는 처리하지 않고 외부로 던진다.
	대신 함수를 호출한 지점에서 예외객체를 받은후 처리한다. 
	이때 예외발생과 상관없이 finally절은 실행된다. 
 */
public class Ex03ExceptionCase3 {

	static void compileFunc() throws IOException {		
		try {
			System.out.print("하나의 문자를 입력하세요:");
			int userChar = System.in.read();
			System.out.println("입력된 문자는 :"+(char)userChar);
			int result = 10 / 0;/*
				해당 문장이 실행되면 ArithmeticException이 발생한다. 
				따라서 main의 try문에서는 해당 예외를 처리할수 없어 
				실행이 중간에 멈추게된다. 이 경우 여러개의 catch절이
				필요하다.
			*/
		}
		finally {
			System.out.println("예외가 발생하든 말든 난 항상 실행됨~!!");
		}
	}	
	
	public static void main(String[] args) {
		try {
			compileFunc();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("끝~~~");
	}
}
