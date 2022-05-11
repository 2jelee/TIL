package edu.kosa.dao_di;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import edu.kosa.model.UserVO;

public class UserDAO {  
		
	private ConnectionMaker  connectionMaker;
	
	public UserDAO(ConnectionMaker  connectionMaker) {  // DI
		this.connectionMaker = connectionMaker; 
	}
		
	// 3. 사용(DML 명령어)
	// insert
	public void insert(UserVO user) throws Exception {
		Connection conn = connectionMaker.makeConnection();  // db 연결
		String sql = "INSERT INTO USERS(ID, NAME, PASSWORD) VALUES(?, ?, ?)";
		PreparedStatement  ps = conn.prepareStatement(sql);
		
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		int result = ps.executeUpdate();
		System.out.println(result + " 개 입력 성공했습니다.");
		
		ps.close();
		conn.close();
	}
	
	// selectAll
	public void selectAll() throws Exception {
		Connection conn = connectionMaker.makeConnection();
		Statement  stmt = conn.createStatement();
		ResultSet  rs = stmt.executeQuery("SELECT * FROM USERS");
		
		System.out.println("ID \t  Name  \t   PWD");
		
		while(rs.next()) {
			String id = rs.getString("id");
			String name = rs.getString("name");
			String pwd = rs.getString("password");
			
			System.out.println(id +"\t" + name + "\t" + pwd);
		}
	}
	
	// selectById - 조건에 맞는 레코드 select 하기(id)  : 코딩
	
	// update  : 코딩 
	
	// delete
	
	public void menu() {
		System.out.println("선택하세요 : \n1.insert");
		System.out.println("2.select\n3.selectAll\n4.update\n5.delete");
		
	}
	
}







