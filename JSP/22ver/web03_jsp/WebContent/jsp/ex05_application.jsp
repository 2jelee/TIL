<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>web.xml 설정 파일에 등록 되어 있는 내용을 application을 통해 읽어오기</title>
</head>
<body>
	<!--  <context-param> 안에서 설정하고 application read
	  web 전체에서 공통으로 사용되는 정보들....
	  웹 경로, 저장경로,....
	  IP, 계정, 패스워드 저장,...... -->
	  
<%
	Enumeration  e = application.getInitParameterNames();
	while( e.hasMoreElements() ) {
		String element = (String)e.nextElement();
		out.print( element + "<br>" );
	}
	
	String emailValue = application.getInitParameter("email");
	out.print("init param email value : " + emailValue + "<br>");
	
	String infoValue = application.getInitParameter("info");
	out.print("init param info value : " + infoValue + "<br>");
	
%>

</body>
</html>






