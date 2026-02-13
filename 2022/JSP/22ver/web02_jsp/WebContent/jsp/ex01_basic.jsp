<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Basic</title>
</head>
<body>
<h1>안녕하세요.</h1>
<p>tag 이용한 웹 브라우저에 출력합니다 </p>
<hr>
<%
	String str = "안녕!!! JSP를  이용한 웹 브라우저에 출력합니다.";
	out.print(str);
%>

</body>
</html>