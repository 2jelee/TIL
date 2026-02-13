<%@page import="java.util.concurrent.ExecutionException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"  %>
<!DOCTYPE>
<html><head>
<title>JDBC</title>
<style type="text/css">
	table { 
		border: 1px solid;  
		width: 400px;  
		
	}
	td, th {
		text-align: center;
		border: 1px solid;
	}
</style>
</head>
<body>
<h3>지역 부서 보기</h3>
<table>
	<tr>
		<th>부서코드</th><th>부서명</th><th>지역코드</th><th>지사명</th>
	</tr>
	<%
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"smile", 
					"oracle");
			stmt = conn.createStatement();
			//String sql = "SELECT * FROM DEPT2";
			rs = stmt.executeQuery("SELECT * FROM DEPT2");
	
			while(rs.next()) {
	%>
	<tr>
		<td><%= rs.getInt(1) %></td>
		<td><%= rs.getString(2) %></td>
		<td><%= rs.getInt(3) %></td>
		<td><%= rs.getString(4) %></td>
	</tr>
	
	<%
			} // while end
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			if( rs != null ) try{ rs.close(); }catch(Exception e){ e.printStackTrace(); }
			if( stmt != null ) try{ stmt.close(); }catch(Exception e){ e.printStackTrace(); }
			if( conn != null ) try{ conn.close(); }catch(Exception e){ e.printStackTrace(); }
		}
	%>
	</table>
</body>
</html>