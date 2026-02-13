<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>useBean Login</title>
</head>
<jsp:useBean id="emp" class="edu.kosta.ex13.Emp" scope="page" />
<jsp:setProperty property="name" name="emp"  value="강감찬" />
<jsp:setProperty property="pay" name="emp"  value="6000" />
<jsp:setProperty property="empno" name="emp"  value="8877" />


<jsp:setProperty property="*" name="emp"/>
이름 : <jsp:getProperty property="name" name="emp"/>
사번 : <jsp:getProperty property="empno" name="emp"/>
급여 : <jsp:getProperty property="pay" name="emp"/>
<hr />
<body>
<h3>useBean Property</h3>
	사번 : <%= emp.getEmpno() %> <br>
	이름 : <%= emp.getName() %> <br>
	급여 : <%= emp.getPay() %> <br>
<hr>
<%
		Date today = new Date();
		out.print(today);
%>
<hr />
useBean 이용해서 객체 생성하기 <br />
<jsp:useBean id="now" class="java.util.Date" />
<%= now %>
</body>
</html>


