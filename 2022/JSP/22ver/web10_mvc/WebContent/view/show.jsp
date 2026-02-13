<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<fmt:requestEncoding value="UTF-8"/>

<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show View Page</title>
</head>
<body>
	서블릿으로 부터 받은 데이터 처리하기 :
	<c:set  value="${ message }"  var="message" />
	<c:out  value="${ message }" />
</body>
</html>