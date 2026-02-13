<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>writeForm Page</title>
</head>
<body>
	<h3>방명록 글쓰기</h3>
	<!-- post 방식으로 보안! -->
	<form action="write.do" method="post">
		번호 : <input type="number" name="no"> <br />
		이름 : <input type="text" name="name"> <br />
		이메일 :<input type="text" name="email"> <br />
		홈페이지 : <input type="text" name="home"> <br />
		내용 : <input type="text" name="contents"> <br />

		<input type="submit" value="글쓰기"> &nbsp;&nbsp;&nbsp;
		<input type="reset" value="취소"> &nbsp;&nbsp;&nbsp;
		<input type="button" value="목록보기" onclick="location.href='list.do' ">   
	</form>
	
</body>
</html>