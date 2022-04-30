<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.kosta.visitors.*" %>
<%@ page import="dbclose.util.* , dbconn.util.*" %>
<%@ page import="java.sql.*" %>

<%@ page errorPage="error.jsp" %>

<% request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="vo" class="com.kosta.visitors.BookVO" />
<jsp:setProperty property="*" name="vo"/>

<!DOCTYPE>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>업데이트 처리</title>
</head>
<body>
	<h3>방명록 업데이트</h3>
	<%
		Connection conn = BookDAO.loadOracleDriver();
		BookDAO.update(conn, vo);
	%>
	
<p> 감사합니다. 성공적으로 Update 되었습니다.
<p> 방명록 읽기 위해서는 <a href="greadForm.jsp">목록보기</a>를 클릭 하세요. <br>

</body>
</html>
