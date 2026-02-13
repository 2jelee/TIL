<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Basic</title>
</head>
<body>
<form action="jsonDismantle.ok" method="post">
    <textarea name="jsonText" rows="5" cols="100">      ${requestScope.jsonStr }
    </textarea><br>
    <input type="submit" value="전송">
</form>
</body>
</html>