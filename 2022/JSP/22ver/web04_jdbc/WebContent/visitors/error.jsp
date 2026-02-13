<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>   <!-- 필수 -->

<!DOCTYPE>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>에러 페이지</title>
<script>
	<!--
		function showDetail() {
			d = document.getElementById('detail');
			d.style.display = 'block';
		}
	-->
</script>

<link href="../css/mystyle.css" type="text/css" rel="stylesheet">
</head>

<body>
	<h3><%= exception.getClass().getName() %></h3>
	<div id="main">
		<%= exception.getMessage() %>
		<input type="button" onclick="showDetail()" value="상세보기" >
		<div id="detail"  style="display: none;">
			<%= exception.printStackTrace(new PrintWriter(out)) %>
		</div>
	</div>
</body>
</html>



