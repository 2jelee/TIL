<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ex02_result.jsp</title>
</head>
<body>

<%-- <% request.setCharacterEncoding("utf-8"); %> --%>
<fmt:requestEncoding  value="UTF-8" />

<h3>${ sessionScope.msg }</h3>

<h3>${ param.name }</h3>
<h3>${ param.search }</h3>

<h3>${ param['name'] }</h3>
<h3>${ param['search'] }</h3>

<hr>
<%
 		request.setCharacterEncoding("utf-8");
 		String search = request.getParameter("search");
 		String name = request.getParameter("name");
 		
 		out.print(search + "<br>");
 		out.print(name + "<br>");
 	%>
</body>
</html>