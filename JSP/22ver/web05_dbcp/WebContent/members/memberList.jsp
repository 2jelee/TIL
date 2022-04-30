<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../view/color.jsp" %>    
<%@ page import="edu.kosta.members.*,  java.sql.* ,  java.util.*" %>

<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>memberList.jsp 회원 리스트 보기</title>
<link href="../view/mystyle.css"  rel="stylesheet" type="text/css">
</head>
<body>
<center>
<table border="1" cellspacing="0"  cellpadding="5">
	<tr>
		<td bgcolor="<%=title_c %>">ID</td>
		<td bgcolor="<%=title_c %>">회원명</td>
		<td bgcolor="<%=title_c %>">생년월일</td>
		<td bgcolor="<%=title_c %>">이메일</td>
		<td bgcolor="<%=title_c %>">블로그</td>
		<td bgcolor="<%=title_c %>">가입일</td>
	</tr>
	<%
			MemberDAO dao = MemberDAO.getInstance();
			ArrayList<MemberVO>  list = dao.selectAll();
			MemberVO vo = null;
			
			for(int i=0; i< list.size() ;  i++) {
				vo = (MemberVO) list.get(i);
				String id = vo.getId();
				String name = vo.getName();
				String jumin1 = vo.getJumin1();
				String email = vo.getEmail();
				String blog = vo.getBlog();
				Timestamp reg_date = vo.getReg_date();
	%>
		<tr>
				<td><%= id %></td>
				<td><%= name %></td>
				<td><%= jumin1 %></td>
				<td><%= email %></td>
				<td><%= blog %></td>
				<td><%= reg_date %></td>
		</tr>
	<%	
			} // for end
	%>
	<tr>	
		<td  colspan="6">
			<input type="button" value="메인으로"  onclick="window.location='main.jsp'  ">
		</td>
	</tr>
</table>
</center>
</body>
</html>






