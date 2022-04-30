<%@page import="dbconn.util.ConnectionUtil"%>
<%@page import="dbclose.util.CloseUtil"%>
<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>JDBC  </title>
<style type="text/css">
	table { border: 1px solid ;  width: 600px; }
</style>
</head>
<body>
	<h3>회원 명단 보기 </h3>
	<table>
		<tr>
			<th>ID</th><th>비밀번호</th><th>이름</th><th>나이</th><th>성별</th><th>e-mail</th>
		</tr>
		<%
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				try{
					conn = ConnectionUtil.getConnection("oracle");
					stmt = conn.createStatement();
					String sql = "SELECT * FROM KOSTAMEMBER";
					rs = stmt.executeQuery(sql);
					
					while( rs.next() ) {
			%>
				<tr>
					<td><%= rs.getString(1) %> </td>
					<td><%= rs.getString(2) %> </td>
					<td><%= rs.getString(3) %> </td>
					<td><%= rs.getInt(4) %> </td>
					<td><%= rs.getString(5) %> </td>
					<td><%= rs.getString(6) %> </td>
				</tr>
			<%
					} // while end
					
				} catch(Exception e) {
					e.printStackTrace();
				} finally {
					CloseUtil.close(rs);   CloseUtil.close(stmt);  CloseUtil.close(conn); 
				}
		%>
	</table>
</body>
</html>







