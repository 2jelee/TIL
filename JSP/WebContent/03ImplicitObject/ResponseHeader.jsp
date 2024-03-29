<%@page import="java.util.Collection"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/* 
응답헤더 설정하기
	:새로운 내용을 DB에 추가했는데도 변경된 내용이 웹브라우저에 출력되지 않는다면
	이는 캐시에 저장된 내용을 출려하고 있기 때문임.
	아래 설정은 캐시를 사용하지 않고 매번 새로고침(F5)한 것처럼
	새로운 정보로 갱신하겠다는 응답헤더 설정이다.
*/
// HTTP/1.0에서의 설정 (현재는 사용하지 않지만 호환성을 위해 남겨둠)
response.setHeader("Pragma", "no-cache");
// HTTP/1.1에서의 설정 (현재 사용중.)
response.setHeader("cache-control", "no-cache");


/* 
파일 다운로드 구현시 사용하는 설정
	: 웹브라우저가 인식하지 못하는 MIME타입으로 설정하면
	웹브라우저는 파일다운로드창을 통해 파일을 다운로드 시킨다.
	jpg와 같은 이미지 파일은 웹브라우저가 인식하는 MIME 타입이므로 다운로드를
	위해서는 아래와 같은 설정이 필요하다.
*/
//response.setContentType("binary/octect-stream");
/* 
	=> 실행 시 주석으로 처리하지 않으면 해당 파일이 다운로드 된다.
*/

/* 
응답헤더 추가/설정하기
	add 계열 : 기존의 헤더명이 존재할 경우 기존의 값을 유지하면서 계속 추가함.
				없을 때에는 새롭게 생성함.
	set 계열 : 기존 헤더명이 존재할 경우 기존값이 변경됨.
				없을때에는 새롭게 생성한다.
*/
long time = new Date().getTime();
System.out.println(time);
response.setDateHeader("currentDate", time); //새롭게 추가

SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm");
time = simple.parse("2017-12-31 10:30").getTime();
System.out.println(time);
response.addDateHeader("currentDate2", time); //새롭게 추가

response.addIntHeader("numberOfCrew", 100); //새롭게 추가
response.setIntHeader("numberOfCrew", 99); //같은 이름이므로 기존의 헤더 덮어쓰기(수정)
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ResponseHeader.jsp</title>
</head>
<body>
	<h2>응답헤더 정보 출력하기</h2>
	<%
	/* 
	getHeaderNames() : 응답헤더의 이름을 얻어온다.
		반환타입은 Collection형이다.
	*/
	Collection<String> headerNames = response.getHeaderNames();
	
	//foreach문을 통해 얻어온 응답헤더를 전체 출력함.
	for(String headerName : headerNames) {
		String headerValue = response.getHeader(headerName);
	%>
		<li><%=headerName %> : <%=headerValue %></li>
	<%
	}
	%>
	
	<h2>응답헤더명 존재여부 확인하기</h2>
	<h3>currentDate 응답헤더명</h3>
	<%=response.containsHeader("currentDate") ? "존재함" : "존재하지 않음" %>
</body>
</html>