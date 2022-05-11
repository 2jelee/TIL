package edu.kosa.dao_xml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import edu.kosa.model.UserVO;

public class UserDAO {		// Controller

	private ConnectionMaker connectionMaker;

	public UserDAO(ConnectionMaker connectionMaker) {  // DI
		this.connectionMaker = connectionMaker;
	}
	
	// insert
	// selectAll
	// selectById
	public UserVO selectById(String id) throws Exception {
		Connection conn = connectionMaker.makeConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM USERS WHERE ID = ?");
		ps.setString(1, id);
		ResultSet  rs = ps.executeQuery();
		rs.next();
		UserVO vo = new UserVO();
		vo.setId(rs.getString("id"));
		vo.setName(rs.getString("name"));
		vo.setPassword(rs.getString("password"));
		
		return vo;
	} 
}
