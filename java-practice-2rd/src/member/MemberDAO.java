package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import sub02_shortboard.ShortBoardDTO;

/*
DAO(Data Access Object)
	: 데이터베이스의 Data에 접근하기 위한 객체로 
	DB접근을 위한 로직으로 주로 구성된다. 
	MVC패턴에서는 M(Model)에 해당한다. 
 */
public class MemberDAO {
	
	//멤버변수
	Connection con;//커넥션ㅣ 객체를 멤버변수로 선언하여 DAO내에서 공유
	PreparedStatement psmt;
	ResultSet rs;
	
	//기본생성자를 통한 MariaDB 연결
	public MemberDAO() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/project_db";
			String id = "kosmo_user";
			String pass = "1234";
			con = DriverManager.getConnection(url,id,pass);
			System.out.println("MariaDB 연결성공");			 
		}
		catch(Exception e) {
			System.out.println("MariaDB 연결시 예외발생");
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new MemberDAO();
	}
	/*
	 	JSP에서 컨텍스트 초기화 파라미터를 읽어서 매개변수로
	 	전달하여 DB연결을 하기위한 인자 생성자
	 	 ㄴ LoginProcessMap에서 DAO객체 생성 및 DB연결하는.
	*/
	public MemberDAO(String driver, String url) {
		try {
			Class.forName(driver);			
			String id = "kosmo_user";
			String pass = "1234";
			con = DriverManager.getConnection(url,id,pass);
			System.out.println("MariaDB 연결성공");			 
		}
		catch(Exception e) {
			System.out.println("MariaDB 연결시 예외발생");
			e.printStackTrace();
		}
	}
//
////	public MemberDAO(ServletContext application) {
////		try {
////			String drv = application.getInitParameter("MariaJDBCDriver");
////			String url = application.getInitParameter("MariaConnectURL");
////			String id = application.getInitParameter("MariaUser");
////			String pwd = application.getInitParameter("MariaPass");
////			
////			Class.forName(drv);			 
////			con = DriverManager.getConnection(url, id, pwd);
////			System.out.println("MariaDB 연결성공");			 
////		}
////		catch(Exception e) {
////			System.out.println("MariaDB 연결시 예외발생");
////			e.printStackTrace();
////		}
////	}
	/*
	인자생성자2 : JSP에서 인수로 인달했던 초기화 파라미터를
	생성자 내에서 가져오기 위해 JSP에서는 application내장객체를
	매개변수로 전달한다. 그러면 메소드 내에서 web.xml에 
	접근할 수 있다. 
	 */
	public MemberDAO(ServletContext application) {
		try {
			String drv = application.getInitParameter("MariaJDBCDriver1");
			String url = application.getInitParameter("MariaConnectURL1");
	//		String id = application.getInitParameter("MariaUser0");
	//		String pwd = application.getInitParameter("MariaPass0");
			
			Class.forName(drv);			 
			con = DriverManager.getConnection(url);
			System.out.println("MariaDB 연결성공");			 
		}
		catch(Exception e) {
			System.out.println("MariaDB 연결시 예외발생");
			e.printStackTrace();
		}
	}
	//자원해제
	/*
	데이터베이스 연결을 해제할때 사용하는 메소드.
	한정된 자원을 사용하므로 사용을 마쳤다면 반드시
	연결을 해제해야 한다. 
	*/
	public void close() {
		try {
			if(rs!=null) rs.close();
			if(psmt!=null) psmt.close();
			if(con!=null) con.close();
		}
		catch(Exception e) {
			System.out.println("MariaDB 자원반납시 예외발생");
		}
	}	
	
	
	
	//그룹함수 count()를 통해 회원의 존재유무만 판단하는 메소드
	public boolean isMember(String id, String pass) {
	 
		//쿼리문 작성
		String sql = "SELECT COUNT(*) FROM member "
				+ " WHERE id=? AND pass=?";
		
		int isMember = 0;
		boolean isFlag = false;

		try {
			//쿼리문을 인수로 prepare객체를 생성한다. 
			psmt = con.prepareStatement(sql);
			//쿼리문의 인파라미터를 설정한다. DB의 인덱스는 1부터 시작함.
			psmt.setString(1, id);
			psmt.setString(2, pass);
			//select쿼리문의 실행결과는 ResultSet객체를 통해 반환받는다.
			rs = psmt.executeQuery();
			//실행결과를 얻어오기 위해 next()를 호출하여 커서를 이동시킨다.
			rs.next();
			//실행결과중 첫번째 값을 얻어오기 위해 getInt()를 사용한다. 
			isMember = rs.getInt(1);
			System.out.println("affected:"+isMember);
			if(isMember==0) //회원이 아닌경우(아이디 패스워드로 회원을 찾을수 없음)
				isFlag = false;
			else //회원인 경우(아이디, 패스워드 일치함)
				isFlag = true; 
		}
		catch(Exception e) {
			//예외가 발생한다면 확인이 불가하므로 무조건 false를 반환한다. 
			isFlag = false;
			e.printStackTrace();
		}
		return isFlag;
	}
	
	
	/*
	로그인 방법2 
		: 쿼리문을 통해 회원인증 후 MemberDTO객체에 회원정보를
		저장한 후 JSP쪽으로 반환해준다. 
	 */
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
	
	
	public Map<String, String> getMemberMap(String uid, String upass){
		
		//회원정보를 저장할 Map컬렉션 생성
		Map<String, String> maps = new HashMap<String, String>();
		
		String query = "SELECT id, pass, name FROM "
				+ " member WHERE id=? AND pass=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, uid);
			psmt.setString(2, upass);
			rs = psmt.executeQuery();
			if(rs.next()) {
				maps.put("id", rs.getString(1));//아이디
				maps.put("pass", rs.getString(2));//패스워드
				maps.put("name", rs.getString("name"));//이름
//				maps.put("tel", rs.getString("tel")); //전화번호
//				maps.put("mobile", rs.getString("mobile")); //휴대폰 번호
//				
//				maps.put("email", rs.getString("email")); //메일
//				maps.put("address", rs.getString("address")); //주소
//				maps.put("regidate", rs.getString("regidate")); //가입일
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
	
	
	
	//추후 아이디 중복확인용 ??? 210613
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
	
	
	
	
//	public void close() {
//		try {
//			if(rs!=null) rs.close();
//			if(psmt!=null) psmt.close();
//			if(con!=null) con.close();
//		}
//		catch(Exception e) {
//			System.out.println("MariaDB 자원반납시 예외발생");
//		}
//	}
	
	
	
	
	
	//회원가입 처리	
	public int insertMember(MemberDTO dto) {
		int result = 0;
		try {
			//인파라미터가 있는 insert 쿼리문 작성
			String query = "INSERT INTO member ( "
//				+ " name,id,pass,tel,mobile,email,zip) "
				+ " name,id,pass,tel,mobile,email,zip) "
				+ " VALUES ( "
			+ " ?, ?, ?, ?, ?, ?, ?)";//여기에 id 추가해야할듯..
//				+ " ?, ?, ?, ?)";//
//				+ " ?, ?, ?, ?, ?, ?, 0)";//여기에 id 추가해야할듯..
	System.out.println(query);
			//prepare객체 생성후 인파라미터 설정
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getId());
			psmt.setString(3, dto.getPass());
			psmt.setString(4, dto.getTel1()+dto.getTel2()+dto.getTel3()); 
			psmt.setString(5, dto.getMobile1()+dto.getMobile2()+dto.getMobile3());
			psmt.setString(6, dto.getEmail1()+"@"+dto.getEmail2());
			psmt.setString(7, dto.getZip1()+dto.getZip2()+dto.getZip3()+dto.getZip4());
//			 pstmt.setString(6, member.getMail1()+"@"+member.getMail2());
//				psmt.setString(8, dto.getId());
			//쿼리문 실행
			result = psmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("회원정보 입력중 예외발생");
			e.printStackTrace();
		}
		return result;
	}
	
		
}