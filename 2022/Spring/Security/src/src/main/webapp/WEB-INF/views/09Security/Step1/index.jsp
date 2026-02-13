<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/bootstrap.css" />
<script src="../resources/jquery/jquery-3.6.0.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h2>스프링 시큐리티 Step1</h2>
	
	<h3>기본설정으로 구현하기</h3>
	
	<h4>USER 권한 획득 후 접속할 수 있는 페이지입니다.</h4>
	
	<!-- 시큐리티에서 제공하는 taglib으로 <form>태그를 구성한다. -->
	<form:form method="post" action="../logout">
		<input type="submit" value="로그아웃" />
	</form:form>
</div>
</body>
</html>