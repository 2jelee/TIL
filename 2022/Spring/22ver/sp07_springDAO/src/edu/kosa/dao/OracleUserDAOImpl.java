package edu.kosa.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleUserDAOImpl extends UserDAO {

	@Override
	public Connection getConnection() throws Exception { 
		// 1. 드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// pom.xml 에 오라클 사용하겠다. dependency 추가 
		
		System.out.println("Driver load 성공!");
		
		// 2. 연결 및 오픈 
//		Connection conn = DriverManager.getConnection(url, user, password);
//		Connection conn = DriverManager.getConnection("jdbc:oracle.thin:@192.168.2.36:1521", "jel", "xxxxxxAt22cc");
		Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@jel_high?TNS_ADMIN=/Users/ijieun/02Workspaces/02SQL/New/Wallet_jel", 
					"jel", 
					"xxxxxxAt22cc"
				);
		
		System.out.println("Driver connect 성공!");
		
		return conn;

		// 3. 사용 -> UserDAO.java에 기술 
	}

}
