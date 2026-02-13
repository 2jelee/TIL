package ex04.file;

import java.io.File;
import java.util.Date;

public class FileInformation {
	public static void main(String[] args) throws Exception {
		File file = null;
		byte[] fileName = new byte[100];
		String strName;
		System.out.print("file name = "); //상대경로로 읽었다(작업하는 공간을 기준으로 읽는)
		//확장자까지 써주자  ex. sample.txt
		
		//read method는 원래 예외 발생하므로 throws~.. (위임)
		System.in.read(fileName);	//예외발생
		strName = new String(fileName).trim(); //읽어들인 fileName을 받아서 공백(space) 제거 
		
		file = new File(strName);	//file 생성하여 strName
		//try~catch를 걸면 {} 가 닫히면 메모리 사라지므로 위임 처리했다. 
		
		System.out.println("절대경로 : " + file.getAbsolutePath());
		System.out.println("표준경로 : " + file.getCanonicalPath());
		System.out.println("최종 수정일 : " + file.lastModified());
		System.out.println("최종 수정일(Date함수) : " + new Date(file.lastModified()));
		System.out.println("파일 크기: " + file.length()); 
		System.out.println("읽기속성 : " + file.canRead());
		System.out.println("쓰기속성 : " + file.canWrite());
		System.out.println("파일의 경로(실제 위치) : " + file.getPath());
		System.out.println("숨김속성 : " + file.isHidden()); 
	}
}
