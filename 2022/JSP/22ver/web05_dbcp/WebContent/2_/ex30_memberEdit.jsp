<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
  <%@ page import="java.sql.*" %>
 <%@ page import="dbconn.util.*" %>
  <%@ page import="dbclose.util.*" %>
  
  <% 
	  if ( session.getAttribute("userid")  == null   ||
				!session.getAttribute("userid").equals("admin") ) {
			//다른 페이지로 강제 이동...
			out.print("<script>");
			out.print("location.href='ex29_login.jsp' ");
			out.print("</script>");	
		} //if end
		
		String id = request.getParameter("id");
		
		Connection conn = null;
  		PreparedStatement pstmt = null;
  		ResultSet rs = null;
  		
  		try{
  			conn = ConnectionUtil.getConnection("oracle");
  			String sql = "SELECT ID, PWD, NAME, AGE, GENDER, EMAIL FROM KOSTAMEMBER WHERE ID = ?";
  			pstmt = conn.prepareStatement(sql);
  			pstmt.setString(1, id);
  			rs = pstmt.executeQuery();
  			rs.next();  //데이터 한건인 경우....
  %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="ex30_memberEditProcess.jsp" method="post">
	<center>
		<table border="1">
			<tr><td>아이디</td><td>
				<input type="text" name="id" value="<%= rs.getString(1) %>"  readonly >
				</td></tr>
			<tr><td>비번</td><td><%= rs.getString(2) %></td></tr>
			
			<tr><td>이름</td><td>
				<input type="text" name="name" value="<%= rs.getString(3) %>"   style="background-color: yellow;" >
				</td></tr>
				
			<tr><td>나이</td><td><%= rs.getInt(4) %></td></tr>
			<tr><td>성별</td><td><%= rs.getString(5) %></td></tr>
		
			<tr><td>이메일</td><td>
				<input type="text" name="email" value="<%= rs.getString(6) %>"   style="background-color: yellow;" >
				</td></tr>
				
			<tr>
				<td  colspan="2">
					<input type="submit"  value="수정하기">
					<a href='ex30_memberList.jsp' >리스트로 이동</a>
				</td>
			</tr>
		</table>
	</center>
</form>
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
  

