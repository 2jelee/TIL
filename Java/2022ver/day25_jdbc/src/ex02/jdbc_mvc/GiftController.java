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

public class GiftController {

	static Scanner sc = new Scanner(System.in);
	static Statement stmt = null;
	static ResultSet rs = null;
	static Connection conn = null;
	
	//for update
	static PreparedStatement pstmt = null;
	
	//연결
	public static void connect() {
		try {
			conn = DBConnection.getConnection(); //연결 끝 => Connection 객체가 가진 getConnecton 가져와라.
			stmt = conn.createStatement(); //완료하겠다, rollback도 하겠다는 의미
			conn.setAutoCommit(false); //자동 commit 끄기
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//닫기
	public static void close() {
		try {
			//작은 순서대로 닫기
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null) { //connection은 가장 나중에 닫는다. => 연결을 끊으므로
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void menu() throws SQLException {
		Gift gift = new Gift(); //Gift.java의 객체 생성
		while(true) {
			System.out.println("\t 0. ROLLBACK ");
			DBConnection.menu();
//			System.out.println("메뉴를 선택하세요.");
			
			switch (sc.nextInt()) {
			case 0:
				System.out.println("Commit 하시겠습니까? (Y/N)");
				System.out.println("안하시려면 ROLLBACK 됩니다.");
				if(sc.next().equalsIgnoreCase("Y")) {
					commit();
					selectAll(gift.getClassName());
				} else {
					rollback();
					selectAll(gift.getClassName());
				}
				break;
			case 1:
				selectAll(gift.getClassName()); //화면을 먼저 보여줘
				insert();
				selectAll(gift.getClassName()); //화면을 보여줘
				break;
			case 2:
				update();
				break;
			case 3:
				selectAll(gift.ClassName);
				break;
			case 4:
				update();
				break;
			case 5:
				update();
				break;
				
				
			case 6:
				close();
				System.out.println("프로그램 종료합니다.");
				System.exit(0); // 종료

			default:
				break;
			}
		}
	}

	//selectAll
	public static void selectAll(String className) throws SQLException {
		rs = stmt.executeQuery("SELECT * FROM "+ className); //테이블명으로 넣어놨으므로 
		ResultSetMetaData rsmd = rs.getMetaData();
		int count = rsmd.getColumnCount();
		
		while(rs.next()) {
			for (int i = 1; i <= count; i++) { //why? 테이블은 무조건 1부터 시작 => 각 타입별로 출력하기
				switch (rsmd.getColumnType(i)) { //1~4까지
				case Types.NUMERIC: //Types. 열거형
				case Types.INTEGER: //Types.
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
		System.out.println("GNO : ");
		String gno = sc.next();
		System.out.println("GNAME : ");
		String gname = sc.next();
		System.out.println("G_START : ");
		String g_start = sc.next();
		System.out.println("G_END : ");
		String g_end = sc.next();
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO gift values(?, ?, ?, ?)");
			
			pstmt.setNString(1, gno);
			pstmt.setNString(2, gname);
			pstmt.setNString(3, g_start);
			pstmt.setNString(4, g_end);
			
			//반드시 DB저장을 위해 완료시켜주자.
//			pstmt.executeUpdate();
			int result = pstmt.executeUpdate();
			System.out.println(result+"개 데이터가 추가되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void update() {
		System.out.println("바꿀 상품의 번호는?");
		System.out.print("GNO : ");
		String gno = sc.next();
		
		try { 
			System.out.print("바꿀 상품의 정보는? ");
			System.out.println("1. GNAME | 2. G_START | 3. G_END");
			switch (1) {
			case 1:
				System.out.println("GNAME의 정보");
				String gname = sc.next();			
				pstmt = conn.prepareStatement("UPDATE gift SET (gname=?) WHERE (gno=?)");
				break;
			case 2:
				System.out.println("G_START에 넣을 정보");
				String g_start = sc.next();
				pstmt = conn.prepareStatement("UPDATE gift SET (g_start=?) WHERE (gno=?)");
			case 3:
				System.out.println("G_END");
				String g_end = sc.next();
			default:
				break;
			}
			pstmt = conn.prepareStatement("UPDATE gift SET (gname=?) WHERE (gno=?)");
			
//			pstmt.setNString(1, gno);
//			pstmt.setNString(2, gname);
//			pstmt.setNString(3, g_start);
//			pstmt.setNString(4, g_end);
			
			//반드시 DB저장을 위해 완료시켜주자.
//			pstmt.executeUpdate();
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
