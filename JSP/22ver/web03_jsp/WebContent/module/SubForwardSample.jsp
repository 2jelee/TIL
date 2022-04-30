<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sample page</title>
</head>
<body>
	<%
		String code = request.getParameter("code");
		String viewURI = null;
		
		if(code.equals("A")){
			viewURI = "/module/a.jsp";
		}else if(code.equals("B")){
			viewURI = "/module/b.jsp";
		}else if(code.equals("C")){
			viewURI = "/module/c.jsp";
		}
		
	%>
	<jsp:forward page="<%= viewURI %>"></jsp:forward>
</body>
</html>