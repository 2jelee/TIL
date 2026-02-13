<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
웹 어플리케이션을 구성하는 모든 JSP(Servlet)에서 String형의 상수를 공유할
목적으로 사용한다.
web.xml에 <context-param>엘리먼트를 통해 등록함.
이를 컨텍스트 초기화 파라미터라고 함.
 --%>
<h3>web.xml에 설정한 내용 읽어오기</h3>
<ul>
	<li>오라클 드라이버 :
	<%=application.getInitParameter("JDBCDriver") %></li>
	<li>오라클 URL :
	<%=application.getInitParameter("ConnectionURL") %></li>
	
</ul>

<%--
컨텍스트 초기화 파라미터의 <param-name> 속성 전체를 가져온다.
반환형은 열거형 데이터인 Enumeration 객체이다.  		Enumeration 뜻 : 단계적인 묘사나 열거
 --%>
<h3>컨텍스트 초기화 파라미터명 전체목록보기</h3>
<ul>
<%
Enumeration<String> names = application.getInitParameterNames();
while(names.hasMoreElements()){ //hasMoreElements을 통해 있는지 확인
	//<param-name> 엘리먼트를 가져옴
	String name = names.nextElement(); //nextElement : 값을 추출
	//<param-value> 엘리먼트를 가져옴
	String value = application.getInitParameter(name);
%>
	<li><%=name %> : <%=value %></li>
<%
}
%>
</ul>

<%--
ServletContext의 메소드인 getRealPath()로
	서버의 물리적(절대)경로를 얻어올 수 있다.
사용 시, 컨텍스트루트를 제외한 /로 시작하는 절대경로를 입력해야 한다.
컨텍스트 루트는 프로젝트명이 된다.
 --%>
<h2>서버의 물리적 경로(=절대경로) 얻어오기</h2>
<ul>
	<li>application내장 객체 :
		<%=application.getRealPath("/images") %></li> 
	<li>request 내장 객체 :
		<%=request.getServletContext().getRealPath("/images") %></li>
	<li>request 내장 객체(주로 서블릿에서 사용) :
		<%=request.getRealPath("/images") %></li>
	<li>session내장 객체 :
		<%=session.getServletContext().getRealPath("/images") %></li>
	<li>config내장 객체 :
		<%=config.getServletContext().getRealPath("/images") %></li>
	<li>this키워드(주로 선언부에서 사용) :
		<%=this.getServletContext().getRealPath("/images") %></li>


<h2>선언부에서 물리적 경로 사용하기</h2>
<%!

String getRealPath(){
	return
	this.getServletContext().getRealPath("/images");
}
String getRealPath(ServletContext app1){
	return app1.getRealPath("/images");
}

ServletContext app2;
String getRealPathString(){
	return app2.getRealPath("/images");
}
%>

<ul>
	<li>this 키워드로 사용 : <%=getRealPath() %></li>
	<li>매개변수로 전달 : <%=getRealPath(application) %></li>
	<%
	this.app2 = application;
	%>
	<li>멤버변수 : <%=getRealPathString() %></li>
</ul>
</ul>
</body>
</html>