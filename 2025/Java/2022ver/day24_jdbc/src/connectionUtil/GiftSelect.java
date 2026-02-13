package connectionUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
[순서]
1. 드라이버 로드
2. Connection & open
3. 사용(DML 명령)
4. 자원반환(닫기)
 */ 
public class GiftSelect {
	public static void main(String[] args) throws ClassNotFoundException, SQLException { //예외 위임
//		1. 드라이버 로드
//		Class.forName("oracle.jdbc.Oracle.Driver"); // -> error : 대소문자 구분 필요함
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		System.out.println("driver load success!");
		
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
		
		// sql Exception 발생 => throws로 위임
		Connection conn = DriverManager.getConnection(url, uid, pwd);
//		System.out.println("Connection suceess!");
		
//		Connection conn = null;
		Statement stmt = null; //statement를 상속 받아서 만든 것은 PreparedStatement -> query문 바뀔 때마다 값 일일이 넣어주지 않고 ?로 변수 처리해주는 방법
		ResultSet rs = null;
		
//		3. 사용(DML 명령)
		//받아올 객체 -> statement
		stmt = conn.createStatement();
		rs = stmt.executeQuery("SELECT * FROM gift");
//		rs = stmt.executeQuery("SELECT * FROM gift WHERE gno=3");
		
		System.out.println("상품번호\t상품명\t최저가\t최고가");
		
		//데이터 1개만 가져오면 if에서도 rs.next() 사용
		//rs.next() : 다음 레코드로 넘어가라(내려가라) | 이전으로 넘어가라 previous
		while(rs.next()) {
			// getXXX 메서드 : 반환값을 가져올 때 (-> executeQuery() : 반환값이 있을 때)
			/*
			 * rs.getXXX(); <- XXX : 자료형
			 * 또는 rs.getString(필드명) / rs.getInt(필드번호 1, 2, 3, ...)
			 * 
			 * rs.getXXX("필드명") or rs.getXXX(인덱스번호);
			 * 		 자료형
			 */ 
			int gno = rs.getInt(1);
			String gname = rs.getString("gname"); //필드번호로 가져오는 것보다는 get 자료형("필드명"); << 권장
			int g_s = rs.getInt(3);
			int g_e = rs.getInt(4);
			
			System.out.println(gno+"\t"+gname+"\t"+g_s+"\t"+g_e);
		}
//		String sql = "SELECT * FROM gift;";
		
//		4. 자원반환(닫기)
		rs.close();
		stmt.close();
		conn.close();
	}
}
