package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/*
JNDI(Java Naming and Directory Interface)
	: 디렉토리 서비스에서 제공하는 데이터 및 객체를 찾아서
	 참고(lookup)하는 API로,
	 쉽게 말하면 외부에 있는 객체를 '이름으로 찾아오기' 위한 기술임.
	 
DBCP(DataBase Connection Pool : 커넥션풀)
	: DB와 연결된 커넥션 객체를 미리 민들어 풀(Pool)에 저장해두었다가
	필요할때 가져다쓰고 반납하는 기법을 말함.
	DB의 부하를 줄이고 자원을 효율적으로 관리할 수 O.
	게임에서는 풀링시스템(Pooling System)이라는 용어로 사용함.
*/
public class ConnectionPool {

	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	public ConnectionPool() {
		try {
			//1. initialContext객체를 생성함.
			Context initCtx = new InitialContext();
			/*
			2. 앞에서 생성한 객체를 JNDI서비스 구조의 초기 ROOT디렉토리를 얻어옴.
			여기서 얻어오는 톰켓의 루트 디렉토리명은 java:comp/env로 이미 정해져있으므로
			그대로 사용하면 됨.
			*/
//			Context ctx = (Context)initCtx.lookup("java:comp/env");
			/*
			3. server.xml에 등록한 네이밍을 lookup하여 DataSource를 얻어옴.
			해당 데이터소스는 DB에 연결된 정보를 가지고 있다.
			*/
//			DataSource source = (DataSource)ctx.lookup("dbcp_myoracle");
			
			//(주석처리한)위 2,3은 이와같이 하나로 합칠 수 있음
			DataSource source =
					(DataSource)initCtx.lookup("java:comp/env/dbcp_myoracle");
			
			//4. 커넥션풀에 톰켓이 생성해놓은 커넥션 객체를 가져다가 사용함.
			con = source.getConnection();
			System.out.println("DB ConnectionPool 연결성공");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB ConnectionPool 연결실패");
		}
	}
	
	//사용했던 connection객체 반납 (자원반납)
	public void close() {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(psmt!=null) psmt.close();
			if(con!=null) con.close();
		}
		catch (Exception e) {
			System.out.println("DB ConnectionPool 자원반납 시 예외발생");
		}
	}
	
	
}
