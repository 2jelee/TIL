<%@page import="edu.kosta.el.Calculator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="hap"  uri="/WEB-INF/tlds/el_function.tld"  %>

<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>userEL.jsp 사용자가 만든 태그 라이브러리 이용, 함수 호출하기</title>
</head>
<body>
<h3>표현 언어에서 함수 사용하기 - 두수의 합을 구하는 함수 호출</h3>
<p>
<form action="userEL.jsp" method="post">
	x : <input type="text" name="x" value="${ param['x'] }"> <br>
	y : <input type="text" name="y" value="${ param['y'] }"> <br>
		
		<input type="submit"  value="더하기 눌러봐">
</form>
<br><br><br>
<p>
<h3> 합은 : ${ hap:add( param['x'] , param['y'] ) } 입니다.</h3> <br>

<h3><%= Calculator.add("3", "5") %></h3>
</body>
</html>





