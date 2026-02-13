<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록 삭제 페이지</title>
</head>
<link href="../css/mystyle.css" type="text/css" rel="stylesheet">

<body>
	<div id="header">
		<%@include file="header.jsp" %>
	</div>
	<div id="menu">
		<%@include file="menu.jsp" %>
	</div>
	<div id="main">
		<form action="gdeletePro.jsp" method="post">
			<table>
				<tr><td>지우고자 하는 번호</td>
					<td><input type="text" name="num"> </td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="삭 제"> &nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" value="취  소">
						<br><br><a href="gwriteForm.jsp"><font color="red"> 방명록 쓰기</font></a>
						<br><br><a href="greadForm.jsp"><font color="red"> 목록보기 </font></a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>






