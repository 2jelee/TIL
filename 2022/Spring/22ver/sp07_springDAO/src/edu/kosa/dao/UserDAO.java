package edu.kosa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import edu.kosa.model.UserVO;

// 추상 클래스 
public abstract class UserDAO {
	// DB 연결과 관련된 Method 
	// 추상 메소드 
	public abstract Connection getConnection() throws Exception;
	
	// 3. 사용 (DML 명령어) 
	// insert
	public void insert(UserVO user) throws Exception {
		Connection conn = getConnection();
		String sql = "insert into users(id, name, password) values(?, ?, ?)";
		PreparedStatement pstsmt = conn.prepareStatement(sql);
		pstsmt.setString(1, user.getId());
		pstsmt.setString(2, user.getName());
		pstsmt.setString(3, user.getPassword());
		
		int result = pstsmt.executeUpdate();
		System.out.println(result + "개 입력 성공");
		
		pstsmt.close();
		conn.close();
	}
	
	// selectAll
	public void selectAll(UserVO user) throws Exception {
		Connection conn = getConnection();
		String sql = "SELECT * FROM users";
		PreparedStatement pstsmt = conn.prepareStatement(sql); 
		int result = pstsmt.executeUpdate();
		System.out.println(result);
		
		pstsmt.close();
		conn.close();
	}
	
	// selectById - 조건에 맞는 레코드 SELECT 하기 (ID)

	public void selectById(UserVO user) throws Exception {
		Connection conn = getConnection();
		String sql = "SELECT * FROM users WHERE ID=?";
		PreparedStatement pstsmt = conn.prepareStatement(sql);
		pstsmt.setString(1, user.getId());  		
		
		int result = pstsmt.executeUpdate();
		System.out.println("id = "+result);
		
		pstsmt.close();
		conn.close();
	}
	// update 
	
	// delete
	
	public void menu() {
		System.out.println("선택하세요: \n 1.insert \n");
		System.out.println("2. select \n 3. selectAll \n 4. update \n 5. delete");
	}
}
