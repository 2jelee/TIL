<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%@ include file="../view/color.jsp"%>
<%@ page import="edu.kosta.members.*" %>

<title>ID 중복 확인</title>
<link href="../view/mystyle.css" rel="stylesheet" type="text/css">
<% request.setCharacterEncoding("utf-8"); %>

<%
	String id = request.getParameter("id");
	MemberDAO dao = MemberDAO.getInstance();
	int check = dao.confirmID(id);
%>
</head>
<body bgcolor="<%=bodyback_c %>">
<% if(check == 1) { %>

<table width="270" border="0" cellpadding="5" cellspacing="0">
	<tr bgcolor="<%=title_c %>">
	   <td height="39"><%=id %> 이미 사용중인 아이디 입니다.</td>
	</tr>
</table>

<form action="confirmId.jsp" method="post" name="checkForm">
<table width="270" border="0" cellspacing="0" cellpadding="5">
	<tr>
		<td bgcolor="<%=value_c %>" align="center">
		다른 아이디를 선택하세요<p>
		<input type="text" size="10" maxlength="12" name="id">
		<input type="submit" value="ID중복확인" >
		</td>
	</tr>
</table>

</form>
<%   }else { %>


<table width="270" border="0" cellspacing="0" cellpadding="5">
 	<tr bgcolor="<%=title_c %>">
 		<td align="center">
 			<p> 입력하신 <%=id %>는 사용하실 수 있는 ID 입니다 </p>
 			<input type="button" value="닫기" onclick="setid()" >
 		</td>
 	</tr> 	
</table>
<% } %>
</body>
</html>


<script language="javascript">
<!--
	function setid(){
	opener.document.userinput.id.value="<%=id%>";
	self.close();  ///<-------------------수정할것!!!
	}
//--> 
</script>











