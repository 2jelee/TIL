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
	<h2>스프링 시큐리티 Step2</h2>
	
	<h3>해당 페이지에 대한 권한이 없는 경우, 자동으로 로케이션 되는 페이지입니다.</h3>
	
	<h4>내 파일명 : accessDenied.sjp</h4>
	
	<jsp:include page="/resources/common_link.jsp" />
</div>
</body>
</html>