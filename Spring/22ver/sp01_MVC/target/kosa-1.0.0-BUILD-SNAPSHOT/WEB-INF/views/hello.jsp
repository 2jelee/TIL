<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<%-- <c:set var="path" value="${ pageContext.request.contextPath }" /> --%>
${ pageContext.request.contextPath } <br>
${ pageContext.request.requestURL } <br>
${ pageContext.request.requestURI } <br>
<%-- <%= pageContext.servletContext.contextPath %> --%>

<html>
<head>
	<title>Hello Page</title>
</head>
<body> 
<h1>Hello World</h1>
<h4>Path</h4>
<hr>

<h4>Image Page</h4>
	<img alt="yuna.jpg" src="/resources/1.jpg" /> <br />
	<img alt="집" src="/resources/2.jpg" /> <br /> 
	<img alt="길.jpg" src="/resources/3.jpg" /> <br /> 
</body>
</html>
