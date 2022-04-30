<%@ page  language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page buffer="1kb"  autoFlush="false" %>

<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>page - buffer 사용하기</title>
</head>
<body>
<%
		//default : buffer size : 8kb
		//default : autoFlush : true
		for(int i=0; i < 1000 ; i++ ) {
%>
		hello~~~~
<% } // for end %>
</body>
</html>





