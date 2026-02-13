package edu.kosta.members;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dbclose.util.CloseUtil;

public class MemberDAO {  // Controller

		private static MemberDAO instance = new MemberDAO();
		
		public static MemberDAO getInstance() {
			return instance;
		}
		
		private MemberDAO() { } 
		
		public Connection getConnection() throws Exception {
			//연결은 JNDI & Pool 형태로 연결 객체 생성해서 리턴 할것임
			Context ctx = new InitialContext();
			Context env = (Context)ctx.lookup("java:comp/env");
			DataSource ds = (DataSource)env.lookup("jdbc:MemberDB");
			
			return ds.getConnection();
		} // getConnection() end
		
		// insert 처리 - 회원 가입 처리 메소드(삽입)
		public void insert( MemberVO vo ) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt=null;
			
			StringBuffer sb = new StringBuffer();
			sb.append("INSERT INTO MEMBERS(ID, PASSWD, NAME, JUMIN1, JUMIN2, ");
			sb.append(" EMAIL, BLOG, REG_DATE) VALUES(?, ?, ?, ?, ?, ?, ?, ? ) ");
			
			conn = getConnection();  // DB 연결
			pstmt = conn.prepareStatement(sb.toString());
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPasswd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getJumin1());
			pstmt.setString(5, vo.getJumin2());
			pstmt.setString(6, vo.getEmail());
			pstmt.setString(7, vo.getBlog());
			pstmt.setTimestamp(8, vo.getReg_date());
			
			int result = pstmt.executeUpdate();
			//System.out.println("result : " + result);
			CloseUtil.close(pstmt);
			CloseUtil.close(conn);
		} // insert() end
		
		//userCheck(id, pwd) - 로그인시 사용할 메소드 id/password 체크함
		public int userCheck(String id, String pwd) throws Exception {
			String sql = "SELECT PASSWD FROM MEMBERS WHERE ID = ?";
			String dbpwd = "";
			int result = -1;
			
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet  rs = pstmt.executeQuery();
			
			if( rs.next() ) {  // id check
				dbpwd = rs.getString("passwd");
				if( dbpwd.equals(pwd) ) result = 1;  // 인증성공
				else result = 0;    // 비번 틀림
			} else {
				result = -1;   // 해당 아이디가 없음
			} // if end
			
			CloseUtil.close(rs);			CloseUtil.close(pstmt);			CloseUtil.close(conn);
			
			return result;
		} // userCheck(id, pwd) end
		
		//selectAll() - 회원 리스트 보기
		public ArrayList<MemberVO> selectAll() throws Exception {
			StringBuffer sb = new StringBuffer();
			sb.append("SELECT ID, NAME, JUMIN1, EMAIL, BLOG, " );
			sb.append(" REG_DATE FROM MEMBERS ORDER BY NAME DESC ");
			
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sb.toString());
			ResultSet rs = pstmt.executeQuery();
			
			MemberVO vo = null;
			ArrayList<MemberVO> list = new ArrayList<>();
			
			while( rs.next() ){
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setJumin1(rs.getString("jumin1"));
				vo.setEmail(rs.getString("email"));
				vo.setBlog(rs.getString("blog"));
				vo.setReg_date(rs.getTimestamp("reg_date"));
				
				list.add(vo);
			}
			CloseUtil.close(rs);			CloseUtil.close(pstmt);	
			
			return list;
		} //selectAll() end
		
		//confirmID(id) - 회원 가입시 id 중복 체크 할때 사용할 메소드
		public int confirmID(String id) throws Exception {
			String sql = "SELECT ID FROM MEMBERS WHERE ID= ?";
			int result = -1;
			
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet  rs = pstmt.executeQuery();
			
			if( rs.next() ) result = 1 ;   // 해당 아이디가 있음
			else result = -1;
			
			CloseUtil.close(rs);			CloseUtil.close(pstmt);			CloseUtil.close(conn);
			
			return result;
		} // confirmID(id) end
		
		//getMember(id) - update시 입력된 데이터를 보여줄 때 사용할 함수
		public MemberVO getMember(String id) throws Exception {
			String sql = "SELECT * FROM MEMBERS WHERE ID = ?";
			MemberVO vo = null;
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if( rs.next() ) {
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setJumin1(rs.getString("jumin1"));
				vo.setJumin2(rs.getString("jumin2"));
				vo.setEmail(rs.getString("email"));
				vo.setBlog(rs.getString("blog"));
				vo.setReg_date(rs.getTimestamp("reg_date"));	
			} // if end			
			CloseUtil.close(rs);			CloseUtil.close(pstmt);			CloseUtil.close(conn);
			return vo;
		} // getMember(id) end
		
		//update(vo) - 회원 정보 수정 완료
		public void update(MemberVO vo) throws Exception {
			String sql = "UPDATE MEMBERS SET PASSWD=?, NAME=?, EMAIL=? , BLOG=? WHERE ID = ?";
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getPasswd());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getBlog());
			pstmt.setString(5, vo.getId());
			
			pstmt.executeUpdate();
			
			CloseUtil.close(pstmt);			CloseUtil.close(conn);
		} // update() end
		
		//delete(id, pwd) - 회원 탈퇴시 사용 함수
		public int delete(String id, String pwd) throws Exception {
			
			String sql ="SELECT PASSWD FROM MEMBERS WHERE ID = ?";
			String dbpwd= ""; 
			int result = -1;
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next() ) {
				dbpwd = rs.getString("passwd");
				
				if( dbpwd.equals(pwd) ) {
					pstmt = conn.prepareStatement("DELETE FROM MEMBERS WHERE ID = ?");
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					
					result = 1;  //회원 탈퇴 성공
				}else {
					result = 0 ; // 비번 틀림...
				}
			}
			
			CloseUtil.close(rs);   CloseUtil.close(pstmt);  CloseUtil.close(conn);
			
			return result;
		} // delete(id, pwd) end
}












