<%@page import="dbconn.util.ConnectionUtil"%>
<%@page import="dbclose.util.CloseUtil"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"  %>
<!DOCTYPE html>
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Login Process</title>
</head>
<body>
<%
		String id = request.getParameter("id");
		String pwd = request.getParameter("pass");
		//out.print(id + "/ " + pwd);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = ConnectionUtil.getConnection("oracle");
			String sql ="SELECT ID, PWD FROM KOSTAMEMBER WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			while( rs.next() ){
				if( pwd.equals(rs.getString(2))) {
					// 서버에 접속하는 사용자마다 고유하게 부여되는 변수
					session.setAttribute("userid", rs.getString(1));
					
					out.print("<script>");
					out.print("location.href='ex29_mainPage.jsp' ");
					out.print("</script>");
				}
			}// while end
			
			out.print("<script>");
			out.print("location.href='ex29_joinForm.jsp' ");
			out.print("</script>");
			
		} catch( Exception e ){
			e.printStackTrace();
		} finally {
			CloseUtil.close(rs);
			CloseUtil.close(pstmt);
			CloseUtil.close(conn);
		}
		
%>

</body>
</html>