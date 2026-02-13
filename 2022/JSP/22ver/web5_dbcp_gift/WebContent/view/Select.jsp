
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Basic</title>
</head>
<body>
<%
		//out.print("access success");
		//1. 드라이버 로드 
		Class.forName("oracle.jdbc.OracleDriver"); 
		Connection conn = null;
		Statement  stmt = null;
		ResultSet rs = null;
		
		try {
			//2.연결 및 오픈
			conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@jel_high?TNS_ADMIN=C:\\00DouZone_th2\\02SQL_Oracle\\JDBC\\Wallet_jel", 
		            	"jel", 
		            	"xxxxxxAt22cc" );
			//3. 사용(DML명령 등등)
			stmt = conn.createStatement();
			String sql = "SELECT * FROM GIFT";
			rs = stmt.executeQuery(sql);  // 반환값 
			
%>
		gno &nbsp;&nbsp; gname &nbsp;&nbsp; g_start &nbsp;&nbsp; g_end <br>	
			
<%
		while( rs.next() ) {
			out.print(rs.getString(1) + "\t");   // rs.getString("dcode")
			out.print(rs.getString(2) + "\t");
			out.print(rs.getString(3) + "\t");
			out.print(rs.getString(4) + "<br>");
		} // while end
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			//4. 닫기
			//conn.close();  
		}
%>
</body>
</html>