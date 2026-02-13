<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="edu.kosta.ex13.Emp" %>
<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>useBean Action Tag</title>
</head>

	<!-- new로 객체 생성했던 것을 tag로 객체 생성하기 위해.... 액션 태그 -->
	<jsp:useBean id="emp"  class="edu.kosta.ex13.Emp" />

<body>
<%
	/* 기본에 객체를 사용했던 방법 */
	Emp e = new Emp();
	e.setEmpno(1004);
	e.setName("이도연");
	e.setPay(9999);	
	
	out.print(e.getEmpno() + "\t");
	out.print(e.getName() + "\t");
	out.print(e.getPay() + "\t"); 
%><hr>
<%= e.toString() %><hr>
<%= emp.toString() %>
</body>
</html>