package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

/*
DAO (Data Access Object)
	: 데이터베이스의 Data에 접근하기 위한 객체로,
		DB접근을 위한 로직으로 주로 구성된다.
		MVC패턴에서는 M(model)에 해당함. 
*/
public class MemberDAO {

	//멤버변수
	Connection con; //Connection 객체를 멤버변수로 선언하여 DAO내에서 공유
	PreparedStatement psmt;
	ResultSet rs;
	
	//생성자 >> java DBConnect.java에서 가져옴 + if문 삭제 + id의 hr계정을 kosmo 계정으로 변경
	//기본생성자를 통한 오라클 연결
	public MemberDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "kosmo";
			String pass = "1234";
			//전역변수 con
			con = DriverManager.getConnection(url,id,pass);
			
			System.out.println("Oracle 연결성공");
		}
		catch(Exception e) {
			System.out.println("Oracle 연결 시 예외발생");
			e.printStackTrace();
		}
	}
	
	//자원해제
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
	
	
	
	
	
	/*
 	JSP에서 컨텍스트 초기화 파라미터를 읽어서 매개변수로
 	전달하여 DB연결을 하기위한 인자 생성자
	*/
	public MemberDAO(String driver, String url) {
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
	
	
	//그룹함수 count()를 통해 회원의 존재유무만 판단하는 메소드
	public boolean isMember(String id, String pass) {
		
		//쿼리문 작성
		String sql = "SELECT COUNT(*) FROM member WHERE id=? AND pass=?"; //? << 인파라미터로 바꿔주기 위해
					//select count(*) from member where id='test' and pass='1234';
					//문자열 구분 >> 예약어 : 대문자 
		
		int isMember = 0;
		boolean isFlag = false;
		
		try {
			psmt = con.prepareStatement(sql); //쿼리문을 인수로 prepare객체를 생성함.
			psmt.setString(1, id); //쿼리문의 인파라미터를 설정함. DB에서의 인덱스는 1부터 시작하므로 1<<
			psmt.setString(2, pass);
			rs = psmt.executeQuery(); //select 쿼리문의 실행결과는 ResultSet객체를 통해 반환받는다.
			rs.next(); //실행결과를 얻어오기 위해 next()를 호출하여 커서를 이동시킴.
			
			isMember = rs.getInt(1); //실행결과 중 첫번째 값을 얻어오기 위해 getInt()를 사용함.
			System.out.println("affected:"+isMember);
			if(isMember==0) //회원이 아닌 경우(id, pw로 회원을 찾을 수 없음)
				isFlag=false;
			else //회원인 경우(is, pw 일치)
				isFlag =true;
		}
		catch (Exception e) {
			isFlag = false; //예외 결과가 떨어지면(예외가 발생한다면) 확인이 불가하므로 무조건 false를 반환
			e.printStackTrace();
		}
		return isFlag;
	}
	/*
	로그인 방법2 : 쿼리문을 통해 회원인증 후 MemberDTO객체에 회원정보를
		저장한 후 JSP 쪽으로 반환해준다. 
	 * */
	public MemberDTO getMemberDTO(String uid, String upass) {
		
		//회원정보 저장을 위해 DTO객체 생성
		MemberDTO dto = new MemberDTO();
		
		//회원정보 조회를 위한 쿼리문 작성
		String query = "SELECT id, pass, name FROM "
				+ " member WHERE id=? AND pass=?";
		try {
			//prepared객체 생성
			psmt = con.prepareStatement(query);
			//인파라미터 설정
			psmt.setString(1, uid);
			psmt.setString(2, upass);
			//쿼리문 실행
			rs = psmt.executeQuery();
			//오라클이 반환해준 ResultSet객체를 통해 결과값이 있는지 확인
			if(rs.next()) {
				//결과가 있다면 DTO객체에 회원정보 저장
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
			}
			else {
				System.out.println("결과셋이 없습니다.");
			}
		}
		catch(Exception e) {
			System.out.println("getMemberDTO오류");
			e.printStackTrace();
		}
		
		return dto;
	}
	
//	public Map<String, String>  getMemberMap(String uid){
	public Map<String, String>  getMemberMap(String uid, String upass){
		
		//회원정보를 저장할 Map컬렉션 생성
		Map<String, String> maps = new HashMap<String, String>();
		
		String query = "SELECT id, pass, name FROM "
				+ " member WHERE id=? AND pass=?";	
//		+ " member WHERE id=? AND pass=?";		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, uid);
//			psmt.setString(2, upass);
			rs = psmt.executeQuery();
			if(rs.next()) {
				maps.put("id", rs.getString(1));//아이디
				maps.put("pass", rs.getString(2));//패스워드
				maps.put("name", rs.getString("name"));//이름
			}
			else {
				System.out.println("결과셋이 없습니다.");
			}
		}
		catch (Exception e) {
			System.out.println("getMemberMap오류");
			e.printStackTrace();		
		}
		
		//Map컬렉션에 저장된 회원정보 반환
		return maps;
	}
	
	
	
	public Map<String, String> getMemberMap(String uid){
		
		//회원정보를 저장할 Map컬렉션 생성
		Map<String, String> maps = new HashMap<String, String>();
		
		String query = "SELECT id, pass, name FROM "
				+ " member WHERE id=?";		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, uid);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				maps.put("id", rs.getString(1));//아이디
				maps.put("pass", rs.getString(2));//패스워드
				maps.put("name", rs.getString("name"));//이름
			}
			else {
				System.out.println("결과셋이 없습니다.");
			}
		}
		catch (Exception e) {
			System.out.println("getMemberMap오류");
			e.printStackTrace();		
		}
		
		//Map컬렉션에 저장된 회원정보 반환
		return maps;
	}
}
