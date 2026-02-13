package ex07.io;

import java.io.*;

/*
 * data type io
 */

public class DataOutputStreamEx {
	public static void main(String[] args) throws Exception { //예외처리 위임
		
		File file = new File("example.txt");
		FileOutputStream fos = new FileOutputStream(file);
		// data type으로 기재
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.writeBoolean(true);
		dos.writeChar(65);  	// ASCII code --> 'A'
		dos.writeShort(100);
		dos.writeInt(5000);
		dos.writeLong(888000);
		dos.writeFloat(8.8f);
		dos.writeDouble(12.3456870);
		dos.flush(); 		// flush 역할 : buffer 비우기
		
		System.out.println("example.txt 파일에 " + dos.size() + "byte save"); //dos.size() : 해당하는 byte 수를 알아낼 수 있다.
		dos.close(); 
	}
}  