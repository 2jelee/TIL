package ex06.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy1 {
	public static void main(String[] args) throws Exception {	// FileNotFound에서 Exception으로 퉁치기
		//읽기객체 - FileInputStream
		InputStream is = new FileInputStream("fileIO.JPG");
		//쓰기 객체 - FileOutputStream
		OutputStream os = new FileOutputStream("fileIO_copy.JPG");
		
		//걸리는 시간 기록
		long start = System.currentTimeMillis();		//시작 시간 저장
		
		//읽어들일 그릇
		while (true) {
			int inputData = is.read();
			if(inputData == -1) break;
			os.write(inputData);
		}
		long end = System.currentTimeMillis();			//끝나는 시간 저장
		System.out.println("작업(복사) 소요시간 측정 : "+ (end - start) + "초");		 //작업(복사) 소요시간
		// 컴파일되는 시간 매번 달라지며 copy된 것은 덮어씌워진다.
		
		//자원 닫기
		is.close();
		os.close();
		
		System.out.println("copy success!");
	}
} 