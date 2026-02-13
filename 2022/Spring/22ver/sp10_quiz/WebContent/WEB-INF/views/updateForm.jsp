<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>writeForm Page</title>
</head>
<body>
	<h3>명부 추가</h3> 
	
	<form action="write.do" method="post">
		DCODE : <input type="number" name="dcode"> <br />
		DNAME : <input type="text" name="dname"> <br />
		PDEPT :<input type="number" name="pdept"> <br />
		AREA : <input type="text" name="area"> <br /> 

		<input type="submit" value="글쓰기"> &nbsp;&nbsp;&nbsp;
		<input type="reset" value="취소"> &nbsp;&nbsp;&nbsp;
		<input type="button" value="목록보기" onclick="location.href='dept.do' ">   
	</form>
	
</body>
</html>