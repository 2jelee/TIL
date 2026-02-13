<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- <%@ include  file="/module/SubInclude.jsp" %> --%>

<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>include directive & action tag</title>
</head>
<body>
	<jsp:include page="/module/SubInclude.jsp" />
	<% int num = 200; %>
	<h3>include File Data</h3>
	SubInclude file data : <%= num %> <br>
	<% num = 900; %>
	변경 Data : <%= num %> <br>
</body>
</html>




