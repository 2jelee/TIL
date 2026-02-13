<%@page import="dbclose.util.CloseUtil"%>
<%@page import="dbconn.util.ConnectionUtil"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원 가입 처리 </title>
</head>
<body>
 <%
		//데이터 받기
		request.setCharacterEncoding("euc-kr");
 	
 		String id = request.getParameter("id");
 		String pwd = request.getParameter("pwd");
 		String name = request.getParameter("name");
 		int age = Integer.parseInt(request.getParameter("age"));  //
 		String gender = request.getParameter("gender");
 		String email = request.getParameter("email");
 		
 		//out.print(id + "/" + pwd + "/ " + name + "/" + age + "/" + gender + "/" + email);	
 %>
 <%
     	Connection conn = null;
 		PreparedStatement pstmt = null;
 		
 		try {
 			conn = ConnectionUtil.getConnection("oracle");
 			
 			String sql = "INSERT INTO KOSTAMEMBER(ID,PWD,NAME,AGE,GENDER,EMAIL) VALUES(?, ?, ?, ?, ?, ?)";
 			pstmt = conn.prepareStatement(sql);
 			
 			pstmt.setString(1, id);
 			pstmt.setString(2, pwd);
 			pstmt.setString(3, name);
 			pstmt.setInt(4, age);
 			pstmt.setString(5, gender);
 			pstmt.setString(6, email);
 			//pstmt.executeUpdate();  //
 			int result = pstmt.executeUpdate();
 			//out.print(result);
 			out.print("데이터 삽입 성공");
 			
 			if( result != 0 ) {
 				out.print("<script>");
 				out.print("location.href='ex29_login.jsp' ");
 				out.print("</script>");
 			}else {
 				out.print("<script>");
 				out.print("alert('가입 실패') ");
 				out.print("</script>");
 			}
 			
 		}catch ( Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(pstmt);   CloseUtil.close(conn);
		}
 %>
 
 
 
</body>
</html>