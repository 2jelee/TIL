<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ page import="java.sql.*" %>
 <%@ page import="dbconn.util.*" %>
  <%@ page import="dbclose.util.*" %>
  
  <%
  		/* db작업
  		select * from kostaMember
  		관리자 페이지 ==> admin
  		로직 (관리자 권한 - 비회원/회원)
  		1. 관리자인지..? */
  		String adminID = null;
  		if ( session.getAttribute("userid")  == null   ||
  				!session.getAttribute("userid").equals("admin") ) {
  			//다른 페이지로 강제 이동...
  			out.print("<script>");
  			out.print("location.href='ex29_login.jsp' ");
  			out.print("</script>");	
  		} //if end
  		
  		Connection conn = null;
  		PreparedStatement pstmt = null;
  		ResultSet rs = null;
  		
  		try{
  			conn = ConnectionUtil.getConnection("oracle");
  			String sql = "SELECT ID FROM KOSTAMEMBER";
  			pstmt = conn.prepareStatement(sql);
  			rs = pstmt.executeQuery();
  %>
  
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Member List</title>
</head>
<body>
<center>
	<table border="1">
		<tr><th colspan="2">회원 리스트 </th></tr>
		<% while( rs.next() ) { %>
		<tr>
			<td width="100px">
				<a href='ex30_memberInfo.jsp?id=<%= rs.getString(1) %>' ><%= rs.getString(1) %></a>
			</td>
			
			<td width="100px">
				<a href='ex30_memberDelete.jsp?id=<%= rs.getString(1) %>' >삭제하기</a>
			</td>
			
			<td width="100px">
				<a href='ex30_memberEdit.jsp?id=<%= rs.getString(1) %>' >수정하기</a>
			</td>
		</tr>
		<% } //while end %>
	</table>
	
	<hr>
	<form action="ex30_memberSearch.jsp"  method="post" >
			회원명 : <input type="text" name="search" >
			<input  type="submit"  value="회원명 검색">
	</form>
	
</center>
</body>
</html>
<%	
  		}catch (Exception e){
  			e.printStackTrace();
  		}finally{
  			CloseUtil.close(rs);
  			CloseUtil.close(pstmt);
  			CloseUtil.close(conn);
  		}
  %>
  
  
  
  