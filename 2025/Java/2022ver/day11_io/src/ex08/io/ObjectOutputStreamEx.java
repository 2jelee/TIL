package ex08.io; 

/*
 * Object type
 */

import java.io.*;

public class ObjectOutputStreamEx {
	public static void main(String[] args) throws IOException {
		Grade vo = new Grade();
//		vo.setSubject("회계");
//		vo.setScore(80);
		vo.setScore(90);
		vo.setSubject("금융");
		
		System.out.println(vo);	//화면 출력
		
		OutputStream os = new FileOutputStream("grade.txt");	//dat도 txt로 읽을 수 있음
		//Object type		>> 말 그대로 객체로 움직이는
		ObjectOutputStream oos = new ObjectOutputStream(os);
		
		oos.writeObject(vo);   //파일로 쓰기(출력)
		oos.close();
	}
} 

