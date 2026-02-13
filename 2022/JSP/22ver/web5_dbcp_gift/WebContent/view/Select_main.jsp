<%@page import="edu.kosa.model.GiftVO"%>
<%@page import="edu.kosa.controller.GiftDAO"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../view/color.jsp" %>    
<%@ page import="edu.kosa.*,  java.sql.* ,  java.util.*" %>


<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>memberList.jsp 회원 리스트 보기</title>
<link href="../view/mystyle.css"  rel="stylesheet" type="text/css">
</head>
<body>
<center>
<table border="1" cellspacing="0"  cellpadding="3">
	<tr>
		<td bgcolor="<%=title_c %>">gno</td>
		<td bgcolor="<%=title_c %>">gname</td>
		<td bgcolor="<%=title_c %>">g_start</td>
		<td bgcolor="<%=title_c %>">g_end</td> 
	</tr>
	<%
		GiftDAO dao = GiftDAO.getInstance();
		ArrayList<GiftVO> list = dao.selectAll();
		GiftVO vo = null;

		for(int i=0; i< list.size() ;  i++) {
			vo = (GiftVO)list.get(i);
			int gno = vo.getGno();
			String gname = vo.getGname();
			int g_start = vo.getG_start(); 
			int g_end = vo.getG_end(); 
	%>
		<tr>
			<td><%= gno %></td>
			<td><%= gname %></td>
			<td><%= g_start %></td>
			<td><%= g_end %></td> 
		</tr>
	<%	
		} // for end
	%>
	<tr>	
		<td  colspan="4">
			<!-- <input type="button" value="메인으로"  onclick="window.location='main.jsp'  "> -->
			<input type="button" value="메인으로"  onclick="">
		</td>
	</tr>
</table>
</center>
</body>
</html>