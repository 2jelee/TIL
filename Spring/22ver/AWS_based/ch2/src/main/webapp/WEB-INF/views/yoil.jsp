<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>yoil.jsp</title>
</head>
<body> 
<!-- $ ~  : EL(Expression Language) -->
<h2> View를 분리하여 JSP 파일로 출력하기 </h2>

year = <%= request.getParameter("year") %>
<%-- <P> ${year }년 ${month }월 ${day }일은 ${yoil }입니다. </P> --%>
<P> ${myDate.year }년 ${myDate.month }월 ${myDate.day }일은 ${yoil }입니다. </P>


</body>
</html>
