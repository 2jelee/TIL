package edu.kosa.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dbclose.util.CloseUtil;
import edu.kosa.model.GiftVO; 

// Controller
public class GiftDAO {
	
	private static GiftDAO instance = new GiftDAO();
	
	public static GiftDAO getInstance() {
		return instance;
	}
	
	private GiftDAO() { } 
	
	public Connection getConnection() throws Exception {
		//연결은 JNDI & Pool 형태로 연결 객체 생성해서 리턴 할것임
		Context ctx = new InitialContext();
		Context env = (Context)ctx.lookup("java:comp/env");
		DataSource ds = (DataSource)env.lookup("jdbc:GiftDB");
		
		return ds.getConnection();
	} // getConnection() end
	
	// DB 연결
	
	// DML - Select
	public ArrayList<GiftVO> selectAll() throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT gno, gname, g_start, g_end FROM gift" );
//		sb.append(" ");
		
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		ResultSet rs = pstmt.executeQuery();
		
		GiftVO vo = null;
		ArrayList<GiftVO> list = new ArrayList<>();
		
		while( rs.next() ){
			vo = new GiftVO();
			vo.setGno(rs.getInt("gno"));
			vo.setGname(rs.getString("gname")); 
			vo.setG_start(rs.getInt("g_start"));
			vo.setG_end(rs.getInt("g_end"));
			
			list.add(vo);
		}
		CloseUtil.close(rs);			CloseUtil.close(pstmt);	
		
		return list;
	} //selectAll() end
	
}


