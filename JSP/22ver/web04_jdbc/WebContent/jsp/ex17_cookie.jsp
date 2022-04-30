<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cookie를 이용한 한글처리</title>
</head>
<body>
<%
	Cookie korCook = new Cookie("koreaName", URLEncoder.encode("강감찬", "utf-8"));
	response.addCookie(korCook);
%>
<hr>
	한글 쿠키 값 읽기
<hr>
<%
	Cookie[] cookies = request.getCookies();
	
	if( cookies.length > 0 || cookies != null ) {
		for(int i=0; i < cookies.length; i++ ) {
			out.print(cookies[i].getName() + " : " );
			out.print(cookies[i].getValue() + "<br>" );
			out.print(URLDecoder.decode(cookies[i].getValue(), "utf-8") + "<br>" );
		}
	}
%>
</body>
</html>






