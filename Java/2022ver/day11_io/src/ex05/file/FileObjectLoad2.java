package ex05.file; 

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class FileObjectLoad2 {
	public static void main(String[] args) throws Exception {
		String name = null;
		String position = null;
		String part = null;
		boolean con = true;

		/*
		 * FileObjectLoad도 Save와 마찬가지로 수업시간에 한 코드와 대부분 비슷합니다. try-catch문에서
		 * catch문만 살짝 바꿔주면 간단히 해결됩니당
		 */

		File f = new File("members2.txt");
		FileInputStream fis = null;
		ObjectInputStream bis = null;

		try {
			fis = new FileInputStream(f);
			bis = new ObjectInputStream(fis);

			System.out.println("    >> 회원 정보 << \n");
			System.out.println("이름 \t 직급 \t 부서");

			while (con) {

				name = (String) bis.readObject();
				position = (String) bis.readObject();
				part = (String) bis.readObject();
				System.out.print(name + "\t" + position + "\t" + part + "\t");
				System.out.println();
			}

			/*
			 * 이부분에서 (String) bis.read()등 bis객체를 통해 읽을것이 더 있는지 확인하면 입력값이 하나씩 밀려서
			 * 입력됩니다.
			 */ 
		} catch (EOFException e) {	//End of File
			// 파일의 끝에 도달하면 EOFException이 발생합니당
			// 그 예외를 처리해주면 정상적으로 처리됩니다!
			System.out.println();
			System.out.println("Success Load File!");
		} finally { 	//finally로 다 사용하면 열었던 것 close로 닫아주자! (DB 등...)
			bis.close();	
		} // try end
	}
} 