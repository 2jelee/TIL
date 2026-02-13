<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Mybatis 사용하기</h2>

	<c:forEach var="dto" items="${userList}">
	    ${dto.id} / ${dto.pass} / ${dto.name}<br>
	</c:forEach>

</body>
</html>

