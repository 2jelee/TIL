<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JDBC</title>
</head>
<body>
<%
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		out.print("driver load success <br>");
		
		Connection conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@jel_high?TNS_ADMIN=C:\\00DouZone_th2\\02SQL_Oracle\\JDBC\\Wallet_jel", 
						"jel", 
						"xxxxxxAt22cc" );
		out.print("connection success <br>");
	}catch(Exception e) {
		e.printStackTrace();
	} finally {
		//conn.close();
	}
%>
</body>
</html>


