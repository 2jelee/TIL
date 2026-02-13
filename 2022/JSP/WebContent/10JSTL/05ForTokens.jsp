<%@page import="java.util.StringTokenizer"%>
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
	<h2>forTokens 태그</h2>
	<%
	String colors = "red,green,blue,gray";
	
	/*  
	StirngTokenizer 클래스
		: 문자열을 구분자로 나눠서 출력할 대사용.
		
		countTokens() : 토큰의 갯수를 반환함
		hasMoreTokens() : 꺼내올 토큰이 있으면 true 반환
		nextToken() : 해당 토큰을 꺼내옴
	*/
	StringTokenizer tokens = new StringTokenizer(colors, ",");
	out.println("<h3>StringTokenizer클래스 사용</h3>");
	out.println("<h4>토큰 수 : "+tokens.countTokens()+"</h4>");
	while(tokens.hasMoreTokens()){
		String token = tokens.nextToken();
		out.println("<h5 style='color:"+token+"'>토큰</h5>");
	}
	
	
	/* 
	String클래스의 split() 메소드
		: 문자열을 구분자로 잘라서 문자열 배열로 반환해줌.
		javaScript에서도 동일한 함수가 존재,
		다른 웹프로그래밍 언어에서도 많이 사용됨.
		
	String클래스에서  >> split 						<< 사용도 매우 높
						replace
						substr 
						indexOf 		함수들 제공
	*/
	String[] colorArr = colors.split(",");
	out.println("<h3>String클래스 사용</h3>");
	for(String color:colorArr){
		out.println("<h5 style='color:"+color+"'>TOKEN</h5>");
	}
	%>
	
	
	<!--  
	forTokens 태그의 속성
		items : 구분자를 포함한 문자열
		delims(delimiter) : 구분자 (여러가지 특수기호 사용할 수 O)	 << 사전적 의미 : 구획/구분 문자
		var : 구분자를 통해 잘라낸 토큰을 저장
	-->
	<h3>JSTL의 forTokens 태그 사용</h3>
	<c:forTokens items="<%=colors %>" delims="," var="color">
		<h5 style="color:${color };">JSTL 좋아요</h5>
	</c:forTokens>

</body>
</html>