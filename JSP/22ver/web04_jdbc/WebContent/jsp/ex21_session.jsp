<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String id = request.getParameter("uid");
	String pwd = request.getParameter("pwd");
	boolean loginState = false;
	
	// db 연결 확인...
	// id == pwd 같으면 회원이라고 가정하면,....
	
	if( id.equals(pwd) ) {
		session.setAttribute("uid", id);
		loginState = true;
	}
%>
<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Session check</title>
</head>
<body>
<% String UserID = (String)session.getAttribute("uid"); %>
<%= UserID %> <br><br>

<%
		if( loginState == true ) {
			out.print(id + "님 로그인한 상태");
		} else {
			out.print("로그인 되어 있지 않은 상태");
		}
	
		//session 제거
		session.invalidate(); 
%>
</body>
</html>




