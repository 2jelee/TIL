<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jstl/core_rt"  %>

<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>간단한 컨트롤러 뷰 페이지</title>
</head>
<body>
	전달된 결과 :
			<c:set  value="${ result }"  var="result" />
			<h2><c:out value="${ result }" /></h2>
</body>
</html>