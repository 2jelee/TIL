package ex04.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class FileInputEx {
	public static void main(String[] args) {
//			throws FileNotFoundException, IOException {	//예외처리 thorws~ 도 가능
		Scanner sc = new Scanner(System.in);
		
		try {
			//추상클래스 >> 자체적으로 객체생성 X
//			OutputStream os = new FileOutputStream("memo.txt"); //상대경로		//예외발생
//			OutputStream os = new FileOutputStream("C:\\00DouZone_th2\\1_Java\\workspace\\day11_io\\test.txt"); //절대경로		역슬래쉬 2번
			OutputStream os = new FileOutputStream("C:/00DouZone_th2/1_Java/workspace/day11_io/test.txt"); //절대경로		슬래쉬 1번
			
			while (true) {
				System.out.print("문자열을 입력하시오 : ");
//				String str = sc.nextLine();		//nextLine : 줄을 읽어들이는		 
				String str = sc.nextLine() + "\r\n";		// "\n" : 개행.. "\r" 파일에 넣기 위해 이 둘을 함께 써야한다.
//				if(str.toUpperCase().equals("EXIT")) {
				if(str.toUpperCase().equals("EXIT\r\n")) {
					break;		//더이상 file 안만들고 빠져나가라
				}
				//가지고 있는 길이만큼 써라
				os.write(str.getBytes());  
			}
			System.out.println("memo.txt save success!");
		} catch (FileNotFoundException e) { 
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
}
