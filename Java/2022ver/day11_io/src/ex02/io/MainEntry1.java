package ex02.io;

import java.io.IOException;
import java.io.InputStream;

public class MainEntry1 {
	public static void main(String[] args) {
//		System.in;		//표준입력		
		InputStream is = System.in;		//표준입력		

		//예외발생하므로 try구문 안에 넣어주면 error 사라짐
		//		int num = is.read();		//read() 메소드는 int타입으로 return되므로
		
		try {
			System.out.print("단일 문자입력 요망 : ");
			int num = is.read();		//read() 메소드는 int타입으로 return되므로 (return 되는 type이 int)
										//예외발생함 -> '0' ~ '9' : 48 ~ 57 (ASCII code)
			
			System.out.println(num);
			System.out.println((char)num);	//char값으로 출력되게 하겠다.
		} catch (IOException e) {
			System.out.println("user error message");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
