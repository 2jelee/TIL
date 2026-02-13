<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%  session.setAttribute("msg", "Session Test 3284729374b242374 ");  %>

<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL Test</title>
</head>
<body>
<form action="ex02_result.jsp"  method="post">
	<table border="1">
		<tr>
			<td>검색 : </td>
			<td><input type="search" placeholder="검색어를 쓰세요" name="search"></td>
		</tr>
		
		<tr>
			<td>이름 : </td>
			<td><input type="tel" placeholder="이름을 쓰세요" name="name"></td>
		</tr>
		
		<tr>	
			<td colspan="2" align="center"><input type="submit" value="전송" > </td>
		</tr>
	</table>
</form>
</body>
</html>




