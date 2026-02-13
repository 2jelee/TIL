package edu.kosa.dao_xml;

import java.sql.Connection;
import java.sql.DriverManager;

public class SConnectionMakerImpl implements ConnectionMaker {

	@Override
	public Connection makeConnection() throws Exception {
		// 1. 드라이브 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2. 연결 및 오픈
		Connection conn = DriverManager.getConnection(
				/*
				"jdbc:oracle:thin:@192.168.2.36:1521:orcl", 
				"kingsmile", 
				"1234"
				*/
				"jdbc:oracle:thin:@jel_high?TNS_ADMIN=/Users/ijieun/02Workspaces/02SQL/New/Wallet_jel", 
				"jel", 
				"xxxxxxAt22cc" 
			);
				
		return conn;
	}

}
