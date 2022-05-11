package edu.kosa.dao_di;

import java.sql.Connection;
import java.sql.DriverManager;

public class LConnectionMakerImpl implements ConnectionMaker { 

	@Override
	public Connection makeConnection() throws Exception {
		// 1. 드라이브 로드
		Class.forName("mysql");
		// 2. 연결 및 오픈
		Connection conn = DriverManager.getConnection(
				"mysql", 
				"kingsmile", "1234");
				
		return conn;
	}

}
