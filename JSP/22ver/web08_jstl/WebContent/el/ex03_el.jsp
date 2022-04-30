<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
   
 <fmt:requestEncoding  value="UTF-8" />
 
<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ex03_el.jsp</title>
</head>
<body>
<form action="ex03_el.jsp"  method="post">
	<ul>
		<li>
				<label for="name">이름 </label>
				<input type="text" id="name" name="name" value="${ param['name'] }">
		</li>
		<p>이름은 : ${ param.name } 이시군요. </p>
	</ul>
</form>
</body>
</html>






