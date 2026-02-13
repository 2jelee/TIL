<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.kosta.visitors.*" %> 
<%@ page import="dbclose.util.* , dbconn.util.*" %>   
<%@ page import="java.sql.*" %>     
<%@ page errorPage="error.jsp" %> 
    
 <% request.setCharacterEncoding("utf-8"); %>   
 
 <jsp:useBean id="vo" class="com.kosta.visitors.BookVO" />
 <jsp:setProperty property="*" name="vo"/>
 
<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>삭제 처리 페이지</title>
</head>
<body>
<%
		try{
			Connection conn = BookDAO.loadOracleDriver();
			BookDAO.delete(conn, vo);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
%>

<p>감사합니다. 성공적으로 삭제 되었습니다.</p>
<p>방명록 읽기 위해서는 <a href="greadForm.jsp">목록 보기</a> 를 클릭하세요. <br />
<p>글 쓰고 싶어요~~~~ <a href="gwriteForm.jsp">글쓰기</a>를 클릭하세요. 
</body>
</html>





