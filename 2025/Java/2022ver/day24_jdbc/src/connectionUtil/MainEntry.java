package connectionUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
1. 드라이버 로드
2. Connection & open
3. 사용(DML 명령)
4. 자원반환(닫기)
 */ 
public class MainEntry {
	public static void main(String[] args) throws ClassNotFoundException, SQLException { //예외 위임
//		1. 드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("driver load success!");
		
//		2. Connection & Open
					// driver:@IP:portNumber:SID
		// 로컬의 경우
//		String url = "jdbc:oracle:thin:@localhost:1521:orcl"; 
		
		// ?TNS_ADMIN= => 약속
		// 전자지갑(cloud)의 경우
					// driver:@IP:portNumber:SID(or 전역데이터베이스명) => "jdbc:oracle:thin:@localhost:1521:orcl";
		String url = "jdbc:oracle:thin:@jel_high?TNS_ADMIN=C:\\00DouZone_th2\\02SQL_Oracle\\JDBC\\Wallet_jel"; 
		String uid = "jel";
		String pwd = "xxxxxxAt22cc";
		
		// sql Exception 발생 => thorws로 위임
		Connection conn = DriverManager.getConnection(url, uid, pwd);
		System.out.println("connection suceess!");
		
//		3. 사용(DML 명령)
//		4. 자원반환(닫기)
	}
}
