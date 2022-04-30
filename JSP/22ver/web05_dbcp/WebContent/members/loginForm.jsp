<%@ page contentType="text/html; charset=utf-8" %>
<%@ include file="../view/color.jsp" %>

<html>
<head><title>로그인 창</title></head>

<link href="../view/mystyle.css" rel="stylsheet" type="text/css" >

<script language="javascript" >
	<!--
	function begin(){
		document.myform.id.focus();
	}
	function checkIt(){
		if(!document.myform.id.value){
			alert("이름을 입력하지 않았습니다.");
			document.myform.id.focus();
			return false;
		}
		
		if(!document.myform.passwd.value){
			alert("비밀번호를 입력하지 않았습니다.");
			document.myform.passwd.focus();
			return false;
		}
	}
	//-->
</script>

<body onload="begin()" bgcolor="<%=bodyback_c%>">
<form name="myform" action="loginPro.jsp" 
					method="post" onSubmit="return checkIt()">
	<table width="260" border="1" align="center" >
		<tr height="30">
			<td colspan="2" align="middle" bgcolor="<%=title_c %>" >
					<strong> 회원 로그인 </strong></td></tr>
		<tr height="30">
			<td width="110" align="center" bgcolor="<%=title_c %>" >아이디</td>
			<td width="150" align="center" bgcolor="<%=value_c %>" >
				<input type="text" name="id" size="15" maxlenth="12" >
			</td>
		</tr>
					
		<tr height="30">
			<td width="110" align="center" bgcolor="<%=title_c %>" >비밀번호</td>
			<td width="150" align="center" bgcolor="<%=value_c %>" >
				<input type="password" name="pwd" size="15" maxlenth="12" >
			</td>
		</tr>
		
		<tr height="30">
			<td colspan="2" align="middle" bgcolor="<%=title_c %>" >
				<input type="submit" value="로그인" >
				<input type="reset" value="다시입력" >
				<input type="button" value="회원가입" 
					onclick="javascript:window.location='insertForm.jsp' ">
			 </td>
		</tr>
	</table>
</form>
</body>

</html>








