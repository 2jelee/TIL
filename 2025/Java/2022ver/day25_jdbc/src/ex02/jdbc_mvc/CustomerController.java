package ex02.jdbc_mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;

import connUtil.DBConnection;

public class CustomerController {

	static Scanner sc = new Scanner(System.in);
	static Statement stmt = null;
	static ResultSet rs = null;
	static Connection conn = null;
	
	static PreparedStatement pstmt = null;
	
	public static void connect() {
		try {
			conn = DBConnection.getConnection();  
			stmt = conn.createStatement();  
			conn.setAutoCommit(false); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	 
	public static void close() {
		try { 
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null) {  
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void menu() throws SQLException {
		Customer customer = new Customer();
		while(true) {
			System.out.println("\t 0. ROLLBACK ");
			DBConnection.menu(); 
			
			switch (sc.nextInt()) {
			case 0:
				System.out.println("Commit 하시겠습니까? (Y/N)");
				System.out.println("안하시려면 ROLLBACK 됩니다.");
				if(sc.next().equalsIgnoreCase("Y")) {
					commit();
					selectAll(customer.getClassName());
				} else {
					rollback();
					selectAll(customer.getClassName());
				}
				break;
			case 1:
				selectAll(customer.getClassName());
				insert();
				selectAll(customer.getClassName());
				break;
			case 2:
				update();
				break;
			case 3:
				selectAll(customer.ClassName);
				break;
			case 4:
				selectCon();
				break;
			case 5:
				delete();
				break; 
			case 6:
				close();
				System.out.println("프로그램 종료합니다.");
				System.exit(0);  

			default:
				break;
			}
		}
	}
 
	public static void selectAll(String className) throws SQLException {
		rs = stmt.executeQuery("SELECT * FROM "+ className);  
		ResultSetMetaData rsmd = rs.getMetaData();
		int count = rsmd.getColumnCount();
		
		while(rs.next()) {
			for (int i = 1; i <= count; i++) {  
				switch (rsmd.getColumnType(i)) {  
				case Types.NUMERIC:  
				case Types.INTEGER:  
					System.out.println(rsmd.getColumnName(i)+ " : " + rs.getInt(i)+ " ");
					break;
				case Types.FLOAT: //Types.
					System.out.println(rsmd.getColumnName(i)+ " : " + rs.getFloat(i)+ " ");
					break;
				case Types.DOUBLE: //Types.
					System.out.println(rsmd.getColumnName(i)+ " : " + rs.getDouble(i)+ " ");
					break;
				case Types.CHAR: //Types.
					System.out.println(rsmd.getColumnName(i)+ " : " + rs.getString(i)+ " ");
					break;
				case Types.DATE: //Types.
					System.out.println(rsmd.getColumnName(i)+ " : " + rs.getDate(i)+ " ");
					break;
				default:
					System.out.println(rsmd.getColumnName(i)+ " : " + rs.getString(i)+ " ");
					break;
				}
			}
			System.out.println();
		}
	}
	
	private static void insert() {
		System.out.println("code : ");
		String code = sc.next();
		System.out.println("name : ");
		String name = sc.next();
		System.out.println("email : ");
		String email = sc.next();
		System.out.println("phone : ");
		String phone = sc.next();
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO customers values(?, ?, ?, ?)");
			
			pstmt.setNString(1, code);
			pstmt.setNString(2, name);
			pstmt.setNString(3, email);
			pstmt.setNString(4, phone);
			 
			int result = pstmt.executeUpdate();
			System.out.println(result+"개 데이터가 추가되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void update() {
		System.out.println("바꿀 고객의 번호는?");
		System.out.print("번호 : ");
		String phone = sc.next();
		
		try { 
			stmt = conn.createStatement();
			String sql;
			System.out.print("바꿀 고객의 정보는? 1. 고객고유번호 | 2. 이름 | 3. 이메일");
			switch (sc.nextInt()) {
			case 1:
				System.out.println("code의 정보");
				String code = sc.next();			
				sql = ("UPDATE customers SET code="+code+" WHERE phone="+ phone);
				break;
			case 2:
				System.out.println("고객의 정보");
				String name = sc.next();
				sql = ("UPDATE customers SET name="+name+"WHERE phone=" + phone);
			case 3:
				System.out.println("고객의 이메일 정보");
				String email = sc.next();
				sql = ("UPDATE gift SET email="+email+" WHERE phone="+phone);
			default:
				break;
			}
			int result = pstmt.executeUpdate();
			System.out.println(result+"개 데이터가 Update 되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void commit() throws SQLException {
		conn.commit();
		System.out.println("Commit 성공");
	}

	private static void rollback() throws SQLException {
		conn.rollback();
		System.out.println("Rollback 성공");
	}

}
