<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sub Param Main</title>
</head>
<body>
<%
	String type = request.getParameter("Type");
	String userID = request.getParameter("userid");
	String pwd = request.getParameter("pwd");
	
	out.print(type + " / " + userID + " / " + pwd);
	out.print("Main Page");
%>
<hr>
<h3> Include page information</h3>
	<jsp:include page="ex15_subparam.jsp">
		<jsp:param value="<%= type %>" name="Type"/>
		<jsp:param value="1004" name="userid"/>
		<jsp:param value="oracle" name="pwd"/>
	</jsp:include>
</body>
</html>






