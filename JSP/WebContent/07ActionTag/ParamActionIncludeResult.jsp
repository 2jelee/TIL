<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ParamActionIncludeResult.jsp</title>
</head>
<body>
	<h2>인클루드된 페이지</h2>
	
	<!-- 
	ParamAvetion.jsp에서 <param 액션태그로 전달된 값 2개와
	브라우저 URL창에 "query=값" 형태로 입력한 값 1개가 아래에 출력됨.
	 -->
	<h3>param액션태그로 전달된 값 출력하기</h3>
	<ul>
		<li>queryString : <%=request.getParameter("query") %></li>
		<li>name : <%=request.getParameter("name") %></li>
		<li>id : <%=request.getParameter("id") %></li>
	</ul>
	
	<!-- 
		MemberDTO객체에 오버라이딩한 toString()메소드가 있다면 	<< 이는 DTO객체에서 마우스 우클릭>source>generate toString()으로 자동생성 했음.
		해당 내용이 출력된다.
		오버라이딩 하지 않았다면 객체의 참조값(주소값)이 출력됨.
	 -->
	
	<h2>영역에 저장된 데이터 읽기</h2>
	<%=request.getAttribute("member") %>
</body>
</html>