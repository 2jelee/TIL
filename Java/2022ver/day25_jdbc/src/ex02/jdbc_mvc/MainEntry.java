package ex02.jdbc_mvc;

import java.sql.SQLException;

// View 역할
public class MainEntry {
	public static void main(String[] args) throws SQLException {
		
		//연결
		GiftController.connect(); //연결메소드 호출
		GiftController.menu(); 	  //메뉴 호출  쿼리 관련이므로 error => throws
		
	}
}
