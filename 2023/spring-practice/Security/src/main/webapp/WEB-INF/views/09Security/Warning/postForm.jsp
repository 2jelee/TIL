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
	<h2>스프링 시큐리티 사용시 주의할점</h2>
	
	<!-- 시큐리티 설정과 상관없이 폼값을 전송할 경우, 인터셉트 당한다. -->
	<h3>&lt;form:form&gt; 적용 안했을때</h3>
	<form method="post" name="loginFrm" action="">
		아이디 : <input type="text" name="id" />
		<br />
		패스워드 : <input type="text" name="pass" />
		<br />
		<button type="submit" class="btn btn-warning">
			로그인
		</button>
	</form>
	
	
	<%--
	웹 애플리캐이션에 스프링 시큐리티를 적용할 경우, <form을 사용할 때는
	인증이 필요없는 페이지에서도 반드시 <form:form 태그 라이브러리를 사용해야 한다.
	해당 태그를 사용하면 _csrf라는 hidden 박스가 자동으로 삽입되고
	시큐리티는 이 값을 사용하여 정상적으로 내부에서 전송된 폼값인지를 확인한다.
	--%>
	<h3>&lt;form:form&gt; 적용 했을때</h3>
	<!-- 정상적으로 인증절차 없이 폼값 전송됨. -->
	<form:form method="post" name="loginFrm" action="">
		아이디 : <input type="text" name="id" />
		<br />
		패스워드 : <input type="text" name="pass" />
		<br />
		<button type="submit" class="btn btn-warning">
			로그인
		</button>
	</form:form>

</body>
</html>