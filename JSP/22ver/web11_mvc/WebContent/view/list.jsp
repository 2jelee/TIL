<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<fmt:requestEncoding value="UTF-8"/>

<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List View Page</title>
</head>
<body>
	<h2>List page 입니다.</h2>
	<c:set  value="${ message }"  var="message" />
	<c:out  value="${ message }" />
	<p>
	<a href="write.do">글쓰기</a>
</body>
</html>