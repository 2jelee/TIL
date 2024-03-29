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
	<!-- 
	out 태그 : 영역에 저장된 변수를 출력할 때 사용함.
	 -->
	<h2>out태그</h2>
	<c:set var="htmlStr">
		<h3>h3태그로 감싼 문자열</h3>
	</c:set>


	<!--
	기본값이거나 true일때는 HTML이 해석되지 않고 태그까지 그대로 출력됨.
	JS의 innerText()와 동일함.
	  -->	
	<h3>escapeXml=true(기본값)일 때</h3>
	<c:out value="${htmlStr }" escapeXml="true" />
	<br />
	\${htmlStr } : ${htmlStr }
	
	
	<!--
	false일때는 HTML이 해석되어져 화면에 출력됨.
	JS의 innerHTML()과 동일. 
	-->
	<h3>escapeXml=false일 때</h3>
	<c:out value="${htmlStr }" escapeXml="false" />
	<br />
	\${htmlStr } : ${htmlStr }
	
	
	<!--  
	- out태그에 value속성의 값이 null일때는 default속성에 지정된 값이 출력됨.
	
	-->
	<h3>default 속성</h3>
	<h4>값이 빈 문자열 : 값이 있는 경우에 해당</h4>
	출력 : <c:out value="" default="값이 빈 문자열" />
	
	<h4>값이 null인 문자열 : 값이 없는 경우에 해당</h4>
	출력 : <c:out value="${null }" default="값이 null인 경우" />
	
	
	<!--  
	-파라미터로 전달되는 pageNum이 없는 경우에는 1로 표현되고
		있는 경우에는 해당 파라미터를 가져와서 페이지에 적용한다.
	-->
	<h3>페이지 링크에 응용하기</h3>
	<c:url value="/08Board/List.jsp?pageNum=" /><c:out value="${param.pageNum }" default="1" />
	<hr />
	<!-- 주의 :
		한줄로 붙여서 작성! 줄바꿈하면 공백이 들어감 -->
	<a href="<c:url value="/08Board/List.jsp?pageNum=" /><c:out
	value="${param.pageNum }" default="1" />"> 회원제게시판 리스트 바로가기</a>
	
	

</body>
</html>