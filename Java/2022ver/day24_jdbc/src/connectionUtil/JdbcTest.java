package connectionUtil;

import java.sql.Connection;
import java.sql.DriverManager;

/*
1. 드라이버 로드
2. Connection & open
3. 사용(DML 명령)
4. 자원반환(닫기)
 */ 
public class JdbcTest {
    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testConnection() {
        try (Connection con =
                     DriverManager.getConnection(
                             "jdbc:oracle:thin:@jel_high?TNS_ADMIN=C:\\00DouZone_th2\\02SQL_Oracle\\JDBC\\Wallet_jel",
                             "jel",
                             "xxxxxxAt22cc"
                     )) {
           System.out.println("connection success!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
