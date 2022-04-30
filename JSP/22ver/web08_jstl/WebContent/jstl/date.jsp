<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>오늘 날짜 출력하기</title>
</head>
<body>
<%
		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy년MM월dd일");
		String strDate = sdf.format(new Date());
%>
	일반적인 jsp 페이지의 형태로 아래와 같이 현재 날짜를 제공합니다. <br>
	현재 날짜 <%=strDate %> 입니다.
</body>
</html>