package ex06.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy2 {
	public static void main(String[] args) throws Exception {	 
		InputStream is = new FileInputStream("fileIO.JPG"); 
		OutputStream os = new FileOutputStream("fileIO_copy.JPG");
		
		//배열로 처리하기 - 도구 생성
//		byte[] buffer = new byte[100]; 		//[]안 커질수록 속도 ↑↑↑
		byte[] buffer = new byte[1024 * 8];
		 
		long start = System.currentTimeMillis();		 
		 
		while (true) {
			int inputData = is.read(buffer);		// buffer 크기만큼 data 읽어라
			if(inputData == -1) break;
//			os.write(inputData);
					//배열명 //시작점  //얼마만큼 읽어들일거야?
			os.write(buffer, 0, inputData);
		}
		long end = System.currentTimeMillis();			 
		System.out.println("작업(복사) 소요시간 측정 : "+ (end - start) + "초");		 
		 
		is.close();
		os.close();
		
		System.out.println("copy success!");
	}
} 