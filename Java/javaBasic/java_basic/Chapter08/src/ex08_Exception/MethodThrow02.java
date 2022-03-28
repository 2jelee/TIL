package ex08_Exception;

// 사용자로부터 파일명을 입력받아 파일을 생성하기
// 파일 생성 : createFile()

import java.io.File;

class MethodThrow02 {
	public static void main(String[] args) {
		try {
			File file = createFile(args[0]);
			System.out.println(file.getName()+"파일이 성공적으로 생성됨");
		} catch (Exception e) {
			System.out.println(e.getMessage()+"다시 입력하시오.");
		}
	}
	
	static File createFile(String fileName) throws Exception{
		if(fileName==null || fileName.equals("")) {
			throw new Exception("파일 이름이 유효하지 않음!");
		}
		File file = new File(fileName); // File클래스의 객체 생성
//		File 객체의 createNewFile 메서드를 이용해서 실제 파일을 생성
		file.createNewFile();
		return file;
	} 
}
