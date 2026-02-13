<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<!-- 컨트롤러 : TransactionController -->
	<h3>트랜잭션(Transaction)</h3>
	<li>
		<a href="transaction/buyTicketMain.do" target="_blank">
			티켓구매하기1 (트랜잭션 메니져 사용)
		</a>
	</li>

	<li>
		<a href="transaction/buyTicketTpl.do" target="_blank">
			티켓구매하기2 (트랜잭션 템플릿 사용)
		</a>
	</li>
</body>
</html>
