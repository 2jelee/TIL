package db;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
//연결관련 import java.sql.~
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//연결관련 code
public class DBConnection  {
	private static Connection conn;
	
	//Singleton
	private DBConnection() { }
	
	static {
		//환경설정 파일 읽어오기 위한 객체생성
		Properties prop = new Properties();
		Reader reader;
		try {
			//reader 객체 생성
			//절대경로로 기재했음
			reader = new FileReader("C:\\00DouZone_th2\\1_Java\\workspace\\day24_jdbc\\src\\db\\oracle.properties"); // " " 안에 있는 파일 읽어와라 (읽을 파일 지정)
//			reader = new FileReader("/src/ib/oracle.properties"); // 상대경로
			
			prop.load(reader); //load : 읽어온다.
		} catch (IOException e) {
			e.printStackTrace();
		}	
//		} catch (ClassNotFoundException e) { //해당하는 class 못찾을 때
//			System.out.println("예외 발생(지정한 파일을 찾을 수 없습니다) : " + e.getMessage());
//			e.printStackTrace();
//		} catch (SQLException e) { // 쿼리문에 문제가 있을 때
//			e.printStackTrace();
//		}
		
		String driverName = prop.getProperty("driver");
		String url = prop.getProperty("url");
		String user = prop.getProperty("user");
		String pwd = prop.getProperty("password");
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection Success!");
		} catch (ClassNotFoundException e) {
			System.out.println("예외! 드라이버 로드 실패 : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("예외! Connection fail : " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return conn;
	}
	
	public static void main(String[] args) {
		getConnection();
		String sql = "select * from emp2;";
		
//		System.out.println("");
	}
}