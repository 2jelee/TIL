package connectionUtil;

import java.sql.Connection;
import java.sql.DriverManager;
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
public class GiftInsert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException { 
//		1. 드라이버 로드 
		
//		2. Connection & Open
		String url = "jdbc:oracle:thin:@jel_high?TNS_ADMIN=C:\\00DouZone_th2\\02SQL_Oracle\\JDBC\\Wallet_jel"; 
		String uid = "jel";
		String pwd = "xxxxxxAt22cc";
		 
		Connection conn = DriverManager.getConnection(url, uid, pwd); 
		Statement stmt = null; 
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		
		//1. 드라이버 로드
		conn = DBConnection.getConnection();
//		conn.setAutoCommit(false); //이는 AutoCommit을 해제하겠다는 의미
		
//		3. 사용(DML 명령) 
		stmt = conn.createStatement(); 
//		rs = stmt.executeQuery("SELECT * FROM gift WHERE gno=3"); //기존
		// Statement 객체
//		String sql = "INSERT INTO gift VALUES(11, 'USB', 1000, 2000)"; //Query문 문자열 취급
//		String sql = "INSERT INTO gift VALUES(" + 12 + ",'" + USB + "'," + 100 + ", " + 2000+")"; //Query문 문자열 취급
//		String sql = "INSERT INTO gift VALUES(" + args[0] + ",'" + args[1] + "'," + args[2] + ", " + args[3]+")"; //Query문 문자열 취급
		System.out.println("상품번호, 상품명, 최고가, 최고가 입력하시오.");
		int gno = sc.nextInt();
		String sql = "INSERT INTO gift VALUES(" + gno + ",'" + sc.next() + "'," + sc.nextInt() + ", " + sc.nextInt()+")"; //Query문 문자열 취급
		
		int result = stmt.executeUpdate(sql);
		System.out.println(result + "개의 데이터가 저장되었습니다.");
		
		stmt.close();
		conn.close();
	}
}
