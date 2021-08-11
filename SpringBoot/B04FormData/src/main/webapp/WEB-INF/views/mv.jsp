<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>ModelAndView 사용하기</h2>
	<p>
		당신의 이름은 ${name} 입니다.
	</p>
	
	<h3>컬렉션 출력1</h3> 
	<div>
		${lists}
	</div>
  
  	<h3>컬렉션 출력2</h3>
	<c:forEach var="mylist" items="${lists}">
	    ${mylist} <br>
	</c:forEach>
</body>
</html>
