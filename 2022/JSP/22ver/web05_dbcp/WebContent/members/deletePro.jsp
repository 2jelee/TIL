<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="edu.kosta.members.*" %>
<%@ include file="../view/color.jsp"%>

<!DOCTYPE>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 탈토 처리 </title>

<link href="../view/mystyle.css" rel="stylesheet" type="text/css" >
</head>
<%
	String id = (String)session.getAttribute("memID");
	String pwd = request.getParameter("passwd");
	
	MemberDAO dao = MemberDAO.getInstance();
	int check = dao.delete(id, pwd);
	
	if( check == 1 ) {
		session.invalidate();
%>
<body bgcolor="<%= bodyback_c%>">
	<form action="main.jsp" method="post" name="userinput">
		<table width="300" border="0" align="center" cellspacing="0" cellpadding="0">
			<tr bgcolor="<%= title_c %>">
				<td height="39" align="center">
					<font size="1+"> <b>회원 정보가 삭제 되었습니다.</b></font>
				</td>
			</tr>
			
			<tr bgcolor="<%= value_c %>">
				<td align="center">
					<p>흑흑......서운하군요..잘~~~가 </p>
					<meta http-equiv="Refresh" content="5; url=main.jsp" >
				</td>
			</tr>
			
			<tr bgcolor="<%= value_c  %>">
				<td align="center">
					<input type="submit" value="확인" >
				</td>
			</tr>
		</table>
	</form>

<%	} else { %>

<script type="text/javascript">
	alert("비밀번호가 맞지 않습니다.");
	history.go(-1);
</script>
<%	}// if end  %>

</body>
</html>




