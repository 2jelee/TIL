package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BoardDAO {
	
	//DAO(Database Access Object)의 '기본' 멤버변수
	Connection con; //DB연결
	PreparedStatement psmt; //쿼리전송 및 실행 //2가지가 존재하는데 psmt(PreparedStatement) 객체(동적쿼리?)를 많이 사용한다.
	ResultSet rs;	//select 결과 반환
	
	/*
	인자 생성자 1 : JSP에서 web.xml에 등록된 컨텍스트 초기화 파라미터를
	 				가져와서 생성자 호출 시 파라미터로 전달하여 DB에 연결한다.
	*/
	public BoardDAO(String driver, String url) {
		try {
			Class.forName(driver);			
			String id = "kosmo";
			String pass = "1234";
			con = DriverManager.getConnection(url,id,pass);
			System.out.println("Oracle 연결성공");			 
		}
		catch(Exception e) {
			System.out.println("Oracle 연결시 예외발생");
			e.printStackTrace();
		}
	}
	/*
	데이터 베이스 연결을 해제할 때 사용하는 메소드.
	한정된 자원을 사용하므로 사용을 마쳤다면 반드시 연결을 해제해야 한다!
	*/

	public void close() {
		try {
			if(rs!=null) rs.close();
			if(psmt!=null) psmt.close();
			if(con!=null) con.close();
		}
		catch (Exception e) {
			System.out.println("Oracle 자원반납 시 예외발생");
		}
	}
}
