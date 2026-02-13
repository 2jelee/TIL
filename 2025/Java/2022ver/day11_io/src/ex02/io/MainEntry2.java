package ex02.io;

import java.io.IOException;
import java.io.InputStream;

public class MainEntry2 {
	public static void main(String[] args) { 
		InputStream is = System.in;		//표준입력		

		//예외발생하므로 try구문 안에 넣어주면 error 사라짐
		//		int num = is.read();		//read() 메소드는 int타입으로 return되므로
		
		try {
			System.out.print("단일 문자입력 요망 : ");	// read는 단일한 문자를 읽어들인다.
			int num1 = is.read() - 48;		//48을 빼면 숫자 그대로 출력됨
			
			//발생한 문제 해결 : java에서 '문자' 2byte처리 되므로 is.read를 2번 코드 작성
			is.read();	//2바이트 처리하므로 2번 써주면 됨
			is.read();	 
			
			int num2 = is.read() - 48;		 
			
			System.out.println(num1 + num2); // read는 단일한 문자를 읽어들인다.
			
		} catch (IOException e) {
			System.out.println("user error message");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
