package ex01.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connUtil.DBConnection;

public class MainEntry {
	
	
	public static void main(String[] args) throws SQLException {
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			// SQL 구문, HTML 태그는 Java/JSP/Servlet에서 문자열(" ") 취급한다.
			String sql = "CREATE TABLE KOSA_TAB(name VARCHAR2(20), age NUMBER)";
			System.out.println(sql.toString());
			stmt.executeLargeUpdate(sql); //반환값이 없는 경우
			
			sql = "INSERT INTO KOSA_TAB VALUES('aa', 20)";
			int result = stmt.executeUpdate(sql);
			
			sql = "SELECT * FROM KOSA_TAB";
			rs = stmt.executeQuery(sql); //반환값이 있는 경우 => select가 해당됨
			
			System.out.println(result + "개 추가됨");
			while(rs.next()) {
				System.out.println("name : " + rs.getString(1));
				System.out.println("age : " + rs.getInt("age"));
			}
			
			sql = "DROP TABLE KOSA_TAB";
			result = stmt.executeUpdate(sql);
			System.out.println("DROP TABLE : " + result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close(); stmt.close(); conn.close();
		}
	}
}
