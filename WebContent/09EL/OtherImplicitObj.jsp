<%@page import="utils.CookieManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
//쿠키매니져 클래스를 통해 쿠키를 생성함. 유효시간은 10초로 설정 //10초 이후 날아감
CookieManager.makeCookie(response, "ELCookie", "EL좋아요", 10);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL-그외 내장객체</title>
</head>
<body>
	<!-- EL의 내장객체 cookie를 통해 쿠키를 읽어옴.  -->
	<h3>쿠키값 읽기</h3>
	<li>ELCookie값 : ${cookie.ELCookie.value }</li>
	
	<!-- 
	속성명에 -(하이픈)이 삽입된 경우에는 .을 통해서 읽을 수 X
	반드시 '배열'형태로 읽어야 된다!!
	-->
	<h3>HTTP헤더 읽기</h3>
	<ul>
		<li>host : ${header.host }</li>
		<li>user-agent : ${header['user-agent'] }</li> <!-- []형태로 읽어옴  -->
		<li>user-agent : ${header.user-agent }</li> <!-- 헤더명에 하이픈이 있는 속성을 .으로 사용하면 결과값이 0으로 출력됨 -->
		<li>cookie : ${header.cookie }</li>
	</ul>
	
	<h3>컨텍스트 초기화 파라미터 읽기</h3>
	<li>OracleDriver : ${initParam.JDBCDriver }</li>
	
	<h3>컨텍스트 루트 경로 읽기</h3>
	<li>${pageContext.request.contextPath }</li>
</body>
</html>