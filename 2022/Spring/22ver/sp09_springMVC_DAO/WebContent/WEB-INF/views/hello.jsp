<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
<meta charset="UTF-8">
<title>Hello Page</title>
</head>
<body>
	인사 합시다 :
	<h3>${ greeting }</h3>
	
	그 동안 완전 고마웠다요~~~ 
	
	<input type="button"  value="List Page" onclick="javascript:window.location.href='list.do' ">&nbsp;
	<input type="button"  value="WriteFormPage" onclick="javascript:window.location.href='writeForm.do' "> 
</body>
</html>