package project1.ver09;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	public static void main(String[] args) {
		try {
			
			//1.오라클용 JDBC 드라이버를 메모리에 로드
			Class.forName("oracle.jdbc.OracleDriver");
			
			//2.오라클 연결을 위한 커넥션URL, 계정아이디, 패스워드
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "kosmo";
			String pass = "1234";
					
			//3.DriverManager 클래스의 메소드를 통해 오라클에 연결
			Connection con = DriverManager.getConnection(url,id,pass);
			if(con!=null) {
				System.out.println("Oracle 연결성공");
			}
			else {
				System.out.println("Oracle 연결실패");
			}
		}
		catch(Exception e) {
			System.out.println("Oracle 연결시 예외발생");
			e.printStackTrace();
		}
	}
}
