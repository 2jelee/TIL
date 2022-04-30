<%@page import="org.eclipse.jdt.internal.compiler.apt.dispatch.HookedJavaFileObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ex04_loginOK.jsp  result page </title>
</head>
<body>
<%
	/* 
	1. 한글처리
	 method ="post"
	 request.setCharacterEncoding("euc-kr");
	
	2. 한글처리 
	method = "get"
	URL
	http://localhost:9999/web02_jsp/jsp/ex04_loginOK.jsp?userId=888&pwd=18888&hobby=soccer&hobby=basketball
	
	<Connector URIEncoding="UTF-8" connectionTimeout="20000" port="9999" protocol="HTTP/1.1" redirectPort="8443"/>
	*/
	
  	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("userId");
	String pw = request.getParameter("pwd");
	
	//String[] hobbys = request.getParameterValues("hobby");
	Map map = request.getParameterMap(); // JSP가 JSP로 처리한 경우
	String[] hobbys = (String[])map.get("hobby");
%>

	당신의 id : <%= id %> <br>
	당신의 password : <%= pw %> <br>
	당신의 취미는 : 
<%
		if( hobbys != null ) {
			for(int i=0; i < hobbys.length; i++ ) {
%>
	<%= hobbys[i] %> &nbsp; &nbsp; &nbsp;
<%				
			} // for end
		} // if end
%>
</body>
</html>






