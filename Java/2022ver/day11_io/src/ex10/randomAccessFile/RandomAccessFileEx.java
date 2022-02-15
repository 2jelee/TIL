package ex10.randomAccessFile; 
import java.io.*;

public class RandomAccessFileEx {
	public static void main(String[] args) throws FileNotFoundException,IOException { //예외처리 위임
		
		RandomAccessFile raf = 
				new RandomAccessFile("example2.txt", "rw");  //예외발생
		
		for (int i = 0; i <= 10; i++) { // 0~11까지
			raf.seek(i * 100);  //예외발생		// seek : 위치값 지정
//			raf.writeInt(i);
			raf.writeUTF(i + ", hello"); 
		}
		
		System.out.println("성공!!!");
		raf.close();
		
	}
}
