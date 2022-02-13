package ex08.io;

import java.io.*;

public class ObjectInputStreamEx {
	public static void main(String[] args) 
			throws FileNotFoundException, IOException, ClassNotFoundException {
		
		InputStream is = new FileInputStream("grade.txt");
		ObjectInputStream oos = new ObjectInputStream(is);  //객체로 읽어들임
		
		Grade vo = (Grade)oos.readObject();	// return 타입 자체가 Object이므로 Grede로 형변환하기
		System.out.println("result output : " + vo);	//읽은 것을 화면 출력하기
		oos.close();
		
	}
}
