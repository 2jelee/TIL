<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
 
<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL core - set, out, remove</title>
</head>
<body>
<h3>JSTL core - set, out, remove</h3>
<p>browser 변수 값 설정
<c:set var="browser"  value="${ header['user-agent'] }" /> <br>
<c:out value="${ browser }" />
</p>

<p>browser 변수 값 제거 후
<c:remove var="browser"/>
<c:out value="${ broswer }" />
</p>
</body>
</html>






