package ex06.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryCopy {	// BinaryCopy  : 낱개로 하나하나 읽겠다.
	public static void main(String[] args) {
//		File src = new File("C:\\Windows\\explorer.exe"); //절대경로 방법1
		File src = new File("C:/Windows/explorer.exe"); //절대경로 방법2
		File dist = new File("C:\\00DouZone_th2\\기타\\ie.dat"); //절대경로 방법1
		
		//읽고쓰기를 같이해야되므로
		FileInputStream fis = null;
		FileOutputStream fos = null;
		//byte 단위로 읽어들이겠다.
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		int c;
		
		try {
			fis = new FileInputStream(src);	//파일 입력바이트 스트림 연결
			fos = new FileOutputStream(dist); //파일 출력바이트 스트림 연결		//dist <= 타겟이 되는 것을 읽어 들이겠다.
			
//			binary로 읽어들일
			bis = new BufferedInputStream(fis);	//버퍼 입력스트림 연결 (임시저장할)
			bos = new BufferedOutputStream(fos); //버퍼 출력스트림 연결 (임시저장할)
			
			while((c=bis.read())!= -1) {	// read는 int type이므로 : -1의 의미 => 끝날때까지
				bos.write((char)c);
			}
			System.out.println("파일복사 성공");
		} catch (Exception e) {
			System.out.println("파일복사 문제 발생");
		} finally { 
			try {
				bis.close(); 
				bos.close();
				fis.close();
				fos.close();
			} catch (IOException e) { 
				e.printStackTrace();
			}
		}
	}
}
