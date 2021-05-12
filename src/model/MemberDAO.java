package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	
}
