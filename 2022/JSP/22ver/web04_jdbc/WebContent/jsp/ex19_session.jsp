<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Session Info</title>
</head>
<body>
<%
		Date time = new Date();
		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
%>
<h3>세션 정보</h3>
	브라우저 마다 고유하게 부여하는 Session Value : <%= session.getId() %>
<hr>
<%	time.setTime(session.getCreationTime());  %>
	세션이 생성된 시간 : <%= sdf.format(time) %>
<hr>
<% time.setTime(session.getLastAccessedTime());  %>
 	Client 마지막 접속 시간 : <%= sdf.format(time) %>
</body>
</html>






