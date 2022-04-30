<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>forward action tag</title>
</head>
<body>
<form action="../module/SubForwardSample.jsp" method="post">
	<select name="code">
		<option value="A"> Hello World</option>
		<option value="B"> Java World</option>
		<option value="C"> Jsp World</option>
	</select>
	<input type="submit"  value="전송">
</form>
</body>
</html>