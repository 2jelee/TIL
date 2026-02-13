<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>thumbnailForm.jsp - 썸네일 이미지 예제</title>
</head>
<body>
	<form action="thumbnailPro.jsp"  method="post"  enctype="multipart/form-data">
		원본 이미지 :
			<input type="file"  name="image"> <br><br>
			<input type="submit" value="썸네일 이미지 만들기">
	</form>
</body>
</html>