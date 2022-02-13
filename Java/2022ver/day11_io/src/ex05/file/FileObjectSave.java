package ex05.file;

import java.io.*;

public class FileObjectSave {
	public static void main(String[] args) throws IOException {
		String name = null;
		String id = null;
		String pwd = null;
		boolean gender = true;
		int age =0;
		String phone = null;
		String temp = null;
		
		/*InputStream is = System.in;
		Reader reader = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(reader);*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ObjectOutputStream  oos = null;
		File f = new File("members.txt"); // 1
		
		// 4 패키지에서 실습해본건 새로 컴파일 돌려서 한다면 계속해서 덮어쓰는데,
		try {
			// true함으로써 파일을 덮어쓰지 않고 계속해서 추가 생성되게 된다.
			FileOutputStream fos = new FileOutputStream(f, true);  //append mode
			//생성한 파일 객체를 넣어주겠다.
			oos = new ObjectOutputStream(fos); // 2 	  1->2 읽어서 파일로 저장하겠다.
			
			System.out.println("--------------------회원 정보 입력 하기---------------------------");
			System.out.print("이름 >> ");  		 name = br.readLine();
			System.out.print("ID >> "); 		 id = br.readLine();
			System.out.print("Password >> "); 	 pwd = br.readLine();
			
			System.out.print("성별(M/F) >> ");  		temp = br.readLine();
			//만약 대문자로 넣으면 소문자로 바꾸겠다.
//			if( temp.toLowerCase().equals("m"))   	gender = true;
			// or equalsIgnoreCase로 처리
			if( temp.equalsIgnoreCase("m"))   	gender = true;
			else 		gender = false;
			
			System.out.print("나이 >> ");  		age = Integer.parseInt( br.readLine() );	//숫자문자로 읽
			System.out.print("전화번호 >> ");  	phone = br.readLine();
			//writeObject로 입력받은 변수값을 쓰겠다(기재).
			oos.writeObject(name);
			oos.writeObject(id);
			oos.writeObject(pwd);
			oos.writeObject(gender);
			oos.writeObject(age);
			oos.writeObject(phone);
			
			System.out.println("members.txt  save!!!");		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			oos.close();
		} // try end
	}
}  