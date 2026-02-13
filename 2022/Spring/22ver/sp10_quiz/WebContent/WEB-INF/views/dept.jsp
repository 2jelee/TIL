<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>   
 
<!DOCTYPE html>
<html><head>
<meta charset="UTF-8">
<title>dept.jsp  LIST  Page</title>
</head>
<body>
 <h3>dept LIST Page 글쓰기</h3>
 
 	<input type="button"  value="글쓰기" onclick="javascript:window.location.href='writeForm.do' ">
 	<input type="button"  value="Update" onclick="javascript:window.location.href='updateForm.do' ">
 	<input type="button"  value="Delete" onclick="javascript:window.location.href='deleteForm.do' ">
 	
	<p>
	
	<c:forEach  items="${ dept }"  var="dept">
		${ dept.dcode }
		${ dept.dname }
		${ dept.pdept }
		${ dept.area } <hr/>
	</c:forEach>
</body>
</html>








