<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page import="java.util.*" %>
<%-- <c:import url="java.util.*" /> --%>

<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL core 라이브러리 사용 예제</title>
</head>
<body>
 <!-- 스크립트릿과 JSTL 비교 -->
 <p>1번 JSTL</p>
 <c:forEach var="j"  begin="1" end="10" step="2">
 		<b>${ j }</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 </c:forEach>
  <p>1번 스크립트릿</p>
  <%
  		for(int i=0; i < 10; i++) {
  			if( i % 2 == 1 ) {
  %>
  		<b><%= i %></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <%
  			} // if end
  		} // for end
  %>
 <hr>
 <h2>1 ~ 100 까지의 합은 ?</h2>
<%--  <c:set var="sum">0</c:set> --%>   <c:set var="sum"   value="0" />

<c:forEach  var="i" begin="1" end="100" >
		<c:set var="sum"  value="${ sum + i }" />
</c:forEach>
<font color="red"  size="5">	합은 : ${ sum }  </font>
<hr>
<h2>구구단</h2>
 <c:forEach var="i" begin="1" end="9">
  		<c:forEach var="j" begin="1" end="9">
  				${ i } * ${ j } = ${ i*j } <br>
  		</c:forEach>
  </c:forEach>
  <hr>
<%
		String[] sports ={ "축구", "야구", "농구", "골프", "수영", "볼링" };
		HashMap map = new HashMap();
		map.put("name", "kingsmile");
		map.put("age", 13);
		map.put("tel", "010-9872-0202");
		map.put("date", new java.util.Date());
%>
<h1>스포츠 배열 2번째 값부터 3개만 출력</h1>
<c:set var="sportsArray"  value="<%= sports %>" />
<c:forEach var="i"  items="${ sportsArray }" begin="1"  end="3" step="1" varStatus="status">
		
		i 값 : ${ i } <br>
		루프 실행 현재 인덱스 값 : ${ status.index } <br>
		루프 실행 횟수 : ${ status.count } <br>
		begin 값 : ${ status.begin } <br>
		end 값 : ${ status.end } <br>
		step 값 : ${ status.step } <br>
		
</c:forEach>
<hr>
<c:set  var="memberMap"   value="<%= map %>" />
<c:forEach  var="i" items="${ memberMap }">
		${ i.key } : ${ i.value } <br>
</c:forEach>
<hr>
  <p>2번 스크립트릿</p>
  <%
  		String a = "a, b, c, d, e, f, g, h, i, j, k";
  		String[] alphabet = a.split(",");
  		
  		for(int i= 0; i < alphabet.length; i++ ) {
  %>
  		<b><%= alphabet[i] %></b>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <%	} // for end  %>
  
  <p>3번 JSTL </p>
  <c:set  var="data"  value="을지문덕, 김유신, 강감찬, 서효진, 이유경, 한수, 승범, 민석" />
  
  <c:forTokens var="varData" items="${ data }" delims=",">
  			<b>${ varData }</b>
  </c:forTokens>
  <hr>
  <%
  		String data = "을지문덕, 김유신, 강감찬, 서효진, 이유경, 한수, 승범, 민석" ;
  		String[] varData = data.split(",");
  		for(int i =0; i < varData.length; i++ ) {
  %>
  		<b><%= varData[i] %></b>
  <% }  %>
</body>
</html>











