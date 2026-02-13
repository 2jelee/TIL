<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="edu.kosta.members.*" %>
<%@ include file="../view/color.jsp" %>

<%
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	MemberDAO dao = MemberDAO.getInstance();
	int check = dao.userCheck(id, pwd);
	
	if( check == 1  ) {
		session.setAttribute("memID", id);  // name(key), value
		response.sendRedirect("main.jsp");
	} else if( check == 0 ) {
%>
	<script type="text/javascript">
	<!--
			alert("비밀번호가 틀렸습니다.");
			history.go(-1);
	//-->
	</script>
<%	} else {  %>
	<script type="text/javascript">
	<!--
			alert("아이디가 없습니다..");
			history.go(-1);
	//-->
	</script>

		
<%	} // if end  %>




