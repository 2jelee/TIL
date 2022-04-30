<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>messageProcess.jsp - 요청 파라미터로 명령어를 전달하는 방법</title>
</head>
<body>
	전달된 결과 : 
		<%-- <c:set  var="message"   value="${ message }"/> --%>
		<font size="5" color="red"><c:out value="${ message }" /></font>
</body>
</html>