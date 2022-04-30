<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
    
 <%@ page import="java.util.* , java.io.*,  java.sql.* " %>
 <%@ page import="java.util.Date" %>
  <%@ page import="java.io.File" %>
<%!  %>  

<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>page : import & out 객체 & buffer</title>
</head>
<body>
<%
	boolean  b = true;
	if( 10 > 5 ) {
%>
	값은 : <font color="blue"><%= b %></font>
<%  } else {
		b = false;		
%>
	값은 : <font color="red"><%= b %></font>
<%  }	// if end  %>

<hr />
<h3> Buffer 관련 메소드 (out 객체를 통해서......)</h3>
	버퍼 : <%= out.getBufferSize() %> Byte <br />
	남은 크기 : <%= out.getRemaining() %> Byte <br />
	버퍼 설정 정보 : <%= out.isAutoFlush() %>
</body>
</html>





