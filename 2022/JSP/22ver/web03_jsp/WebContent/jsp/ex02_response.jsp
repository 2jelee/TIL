<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>response object 다루기</title>
</head>
<body>
일반 Response : <%= 100+200+300 %> <br />
Redirect :  <%
		//클라이언트 브라우저에게 ex01_basic.jsp 를 재요청 하도록 명령한다.
		out.print("어쩌지......:");
		response.sendRedirect("ex01_basic.jsp");
%>
</body>
</html>