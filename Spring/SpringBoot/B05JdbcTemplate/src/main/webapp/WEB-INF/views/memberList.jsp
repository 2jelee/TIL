<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/bootstrap.css" />
<script src="../resources/jquery/jquery-3.6.0.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h2>회원 리스트 보기</h2>
	${memberList }
	<br />
	<c:forEach var="dto" items="${memberList }">
		${dto.id } / ${dto.name } / ${dto.pass } / ${dto.regidate } <br />
	</c:forEach>
</body>
</html>

