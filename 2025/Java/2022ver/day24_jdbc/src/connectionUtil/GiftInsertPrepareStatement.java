package connectionUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DBConnection;

/*
[순서]
1. 드라이버 로드
2. Connection & open
3. 사용(DML 명령)
4. 자원반환(닫기)
 */ 

//statement를 상속 받아서 만든 것은 PreparedStatement -> query문 바뀔 때마다 값 일일이 넣어주지 않고 ?로 변수 처리해주는 방법
//SQL Developer와 다르게 Java는 Auto Commit
public class GiftInsertPrepareStatement {
	public static void main(String[] args) throws ClassNotFoundException, SQLException { 
//		1. 드라이버 로드 
		
//		2. Connection & Open
		String url = "jdbc:oracle:thin:@jel_high?TNS_ADMIN=C:\\00DouZone_th2\\02SQL_Oracle\\JDBC\\Wallet_jel"; 
		String uid = "jel";
		String pwd = "xxxxxxAt22cc";
		 
		Connection conn = DriverManager.getConnection(url, uid, pwd); 
		PreparedStatement ps = null; 
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		
		//1. 드라이버 로드
		conn = DBConnection.getConnection();
//		conn.setAutoCommit(false); //이는 AutoCommit을 해제하겠다는 의미
		
//		3. 사용(DML 명령) 
		// ?로 변수처리
		ps = conn.prepareStatement("INSERT INTO gift VALUES(?, ?, ?, ?)");  
		System.out.println("상품번호, 상품명, 최고가, 최고가 입력하시오.");
		int gno = sc.nextInt();
		String gname = sc.next();
		int g_s = sc.nextInt();
		int g_e = sc.nextInt();
		
//		ps.setXXX(1, 2) //1번째 인자 : 순번 / 2번째 인자 : 데이터값
//			  자료형
		ps.setInt(1, gno);
		ps.setString(2, gname);
		ps.setInt(3, sc.nextInt()); //sc로 넣어도 직접 받아도 O
		ps.setInt(4, g_e);
		
		//반드시 Update하겠다는 메서드가 필요하다
//		ps.executeUpdate(); //세팅 작업완료 되었다는 의미
		
		int result = ps.executeUpdate();
		System.out.println(result + "개의 데이터 추가 성공!");
		System.out.println(gname + " 상품이 추가되었습니다.");
		
		ps.close();
		conn.close();
	}
}
