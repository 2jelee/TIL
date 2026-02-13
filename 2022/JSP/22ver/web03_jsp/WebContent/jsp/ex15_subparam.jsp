<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sub Param</title>
</head>
<body>
<%
	String subID = request.getParameter("userid");
	String pwd = request.getParameter("pwd");
	String type = request.getParameter("Type");
%><br>
	SubParam page <br>
	subID request value : <%= subID %> <br>
	pwd request value : <%= pwd %> <br>
	type request value : <%= type %> <br><hr />
	
	name 파라메터 List <br>
	<ul>
		<%
		//http://localhost:9999/web03_jsp/jsp/ex15_subparam.jsp?Type=B&userid=doyeon&userid=kingsmile&pwd=oracle
			
				String[] name = request.getParameterValues("userid");
				for(String n : name) {
		%>
				<li><%= n %></li>
		<% } // for end %>
	</ul> <hr />
	
	<%
			if( type.equals("A")) {
				out.print("당신이 요청한 데이터는 제품 : " + type);
			} else if( type.equals("B")) {
				out.print("당신이 요청한 데이터는 제품 : " + type);
			} 
	%>
</body>
</html>




