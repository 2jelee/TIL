<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ex04_login.jsp</title>
</head>
<body>
<form action="ex04_loginOK.jsp" method="get">
	ID : <input type="text" name="userId"> <br />
	PWD : <input type="password" name="pwd"> <br />
	Hobby : 
		<input type="checkbox" name="hobby" value="baseball"> Baseball
		<input type="checkbox" name="hobby" value="soccer"> Soccer
		<input type="checkbox" name="hobby" value="basketball"> Basketball
		<br />
	<input type="submit"  value="로그인" >
</form>
</body>
</html>