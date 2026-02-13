<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<c:import url="date.jsp"  var="today" />
<fmt:requestEncoding  value="UTF-8" />

<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL, core, fmt 라이브러리 - requestEncodign......</title>
</head>
<body>
<c:if test="">

</c:if>
${ today } <br>
<hr>
파라미티 : <c:out value=" ${ param.id }" /> <br>
				<c:out value="${ param['id'] }" /> <br><br><br>
				
<form action="ex02_jstl.jsp"  method="post">
	<input type="text" name="id">
	<input type="submit"  value="확인">
</form>
</body>
</html>





