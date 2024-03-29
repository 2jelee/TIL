<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IncludeAction.jsp</title>
</head>
<body>
<%
//include할 페이지의 경로를 String으로 설정
String directivePath="./include/DirectivePage.jsp";
String actionTagPath="./include/ActionTagPage.jsp";

//페이지, 리퀘스트 영역에 속성을 저장
pageContext.setAttribute("pageVar", "페이지 영역에 저장");
request.setAttribute("requestVar", "리퀘스트 영역에 저장");
%>

<h2>include 액션태그</h2>

<h3>include 지시어로 페이지 포함하기</h3>
<!-- 
	지시어(Directive)를 통한 include는 '표현식'을 사용할 수 없다.
	반드시 문자열로 기술해야 한다. 				>> 표현식 ?
 -->
<%-- <%@ include file="<%=directivePath %>"%>       에러발생--%>
<%@ include file="./include/DirectivePage.jsp" %>

<!-- 
	액션태그의 경우에는 표현식, String 두 가지 모두 사용할 수 있다.
 -->
<h3>include 액션태그로 페이지 포함하기</h3>
<jsp:include page="<%=actionTagPath %>" />
<jsp:include page="./include/ActionTagPage.jsp" />

<!-- 
include 지시어와 액션태그의 차이점
[지시어]
	- jsp 소스를 그대로 포함시킨 후 페이지를 실행(컴파일)한다.
	  즉, 현재 페이지와 같은 페이지를 의미함.
[액션태그]
	- jsp소스를 '먼저 실행'한 후 '실행된 결과'를 포함시킨다. 	순서 : 컴파일 -> (그 결과를)삽입
	- 따라서 기존페이지에서 선언된 변수는 포함시킨 페이지에서 사용할 수 없다.
	- 다른 페이지를 의미하므로 page영역은 공유되지 않는다.
	- 하지만 forward 같이 request 영역은 공유된다.
 -->
<h2>각각의 포함된 페이지 안에서 선언한 변수 사용하기</h2>

<h3>디렉티브 페이지에서 선언한 변수 사용</h3>
변수출력 : <%=dirString %>

<h3>액션태그 페이지에서 선언한 변수 사용</h3>
변수출력 : <%--=actionString --%>



<!--
	결론적으로 JSP코드가 있는 jsp를 포함시킬 때에는
	지시어를 사용하고
	JSP 코드가 없는 jsp를 포함시킬 때에는 액션태그를 사용한다.
-->
</body>
</html>