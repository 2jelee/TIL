<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="edu.kosta.board.*" %>
<%@ page import="java.sql.Timestamp" %>

<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="vo" class="edu.kosta.board.BoardVO">
	<jsp:setProperty name="vo"  property="*" />
</jsp:useBean>

<%
	vo.setReg_date(new Timestamp(System.currentTimeMillis())); 
	vo.setIp(request.getRemoteAddr()); 
	
	BoardDAO dao = BoardDAO.getInstance();
	dao.insert(vo);
	
	response.sendRedirect("list.jsp");
%>





