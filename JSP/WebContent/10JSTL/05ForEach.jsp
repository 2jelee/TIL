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
	<h2>일반 for문 형태의 forEach태그</h2>
	
	<!-- 
	forEach 태그의 첫 번째 문법 : 일반 for문
		형식 begin : 시작값
			end : 종료값
			step : 증가치(제외할 경우 1로 고정됨)
			var : 반복 시 사용할 변수
	 -->
	<h3>JSTL 및 EL로 Hn태그 출력하기</h3>
	<c:forEach begin="1" end="6" var="i">
		<h${i }>난 H${i }태그 입니다.</h${i }>
	</c:forEach>
	
	<!--  
	일반 for문에서의 varStatus 속성
		: 반복과 관련된 정보를 추상화한 클래스인
		LoopTagStatus 객체를 통해 정보를 반환함.
		
		count : 실제 반복횟수(1~마지막)
		index : 변수 i의 변화하는 값
		first : loop의 처음일때 true 반환
		last : loop의 마지막일 때 true 반환
		current : 현재 loop의 변수값(var 속성에 지정된 변수)
	-->
	<h3>varStatus 속성 살펴보기</h3>
	<c:forEach begin="3" end="5" var="i" varStatus="loop">
		<h4>${loop.count }번째 반복입니다.</h4>
		<ul>
			<li>index : ${loop.index }</li>
			<li>first : ${loop.first }</li>
			<li>last : ${loop.last }</li>
			<li>current : ${loop.current }</li>
		</ul>
	</c:forEach>
	
	<h3>1에서 100까지 정수중 홀수의 합</h3>
	<c:forEach begin="1" end="100" var="a">
		<c:if test="${a mod 2 ne 0 }">
			<c:set var="sum" value="${sum+a }" />
		</c:if>
	</c:forEach>
	1~100사이의 정수 중 홀수의 합은? ${sum }
	
	
	
	
	<h3>중첩된 for문 활용하기</h3>
	<!-- 
	연습문제] 아래 모양을 출력하시오. 단 JSTL의 forEach와 if문을 
	활용하시오.
	1 0 0 0 0
	0 1 0 0 0
	0 0 1 0 0
	0 0 0 1 0
	0 0 0 0 1
	-->
	<h4>if문 사용하기 -1. if태그로 작성하기</h4>
	<c:forEach begin="1" end="5" var="i">
		<c:forEach begin="1" end="5" var="j">
<%-- 			<c:if test="${i eq j }"> --%>
			<c:if test="${i eq j }" var="result">
				1&nbsp;
			</c:if>
<%-- 			<c:if test="${i ne j }"> --%>
			<c:if test="${not result }">
				0&nbsp;
			</c:if>
		</c:forEach>
		<br />
	</c:forEach>
	
	<h4>if문 사용하기 -2. choose태그로 작성하기</h4>
	<c:forEach begin="1" end="5" var="i">
		<!-- 주석 1 -->
		<c:forEach begin="1" end="5" var="j">
			<!-- 주석 2 -->
			<c:choose>
				<%-- 주석 3 : error 발생 << choose와 when사이에는 HTML주석<!--을 사용하면 error발생--%>
				<c:when test="${i==j }"> <!-- == 대신에 eq써도 O -->
					<!-- 주석 4 -->
					1&nbsp;
				</c:when>
				<c:otherwise>
					0&nbsp;
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<br />
	</c:forEach>
	
	
	
	<h2>구구단 출력하기</h2>
	<!-- 
	시나리오] JSTL의 forEach문을 이용하여 구구단을 출력하시오.
		table태그를 사용해야 하고, 짝수행에 마우스 오버시 빨간색으로
		홀수행에 마우스 오버시 노란색으로 바뀌게 코드를 작성하시오.
	 -->
	<h3>JSTL로 출력하기</h3>
	<table border="1">
	<c:forEach begin="2" end="9" var="dan" varStatus="gugudan">
		
		<c:choose>
			<c:when test="${gugudan.count mod 2 eq 0 }">
			<!-- 짝수인 경우, 빨간색으로 지정 		주석 위치 잘보기! 이것보다 하나 윗칸이면 error-->
				<c:set var="color" value="red" />
			</c:when>
			<c:otherwise>
			<!-- 홀수인 경우, 노란색으로 지정 -->
				<c:set var="color" value="yellow" />
			</c:otherwise>
		</c:choose>
			
		<!-- choose에서 선택한 color를 배경색으로 지정 -->
		<tr onmouseover="this.style.backgroundColor='${color}';" 
				onmouseout="this.style.backgroundColor='white';"> <!-- tr : 단 출력  | td : 숫자 출력-->
		<c:forEach begin="1" end="9" var="su">
			<td>${dan }*${su }=${dan*su }</td>
		</c:forEach>
		</tr>
	</c:forEach>
	</table>
	
	
	
	
</body>
</html>