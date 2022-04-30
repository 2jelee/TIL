<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Login Page</title>
<!-- script //////////////////////////////////////////////////////-->
	<script src="//code.jquery.com/jquery-2.1.1.js"></script>
	<script type="text/javascript">
		$(document).ready( function() {
			$("#btnsubmit").click( function() {
				if( $("#id").val() == "" ) {
					alert('id 입력하세요');
					$("#id").focus();
					return false;
				} else if( $("#pass" ).val() == "" ) {
					alert("비밀번호 입력하세요");
					$("#pass").focus();
					return false
				} else {
					$('#loginForm').submit();
				}
			});
		});
	</script>
	<!-- style //////////////////////////////////////////////////////-->
	<style type="text/css">
	table {
		border: solid 2px black;
		border-collapse: collapse;
	}
	tr {
		border: solid 1px blue;
		background-color: white;
		color : black;
	}
	td {
		border: solid 1px red;	
	}
</style>
</head>
<body>
<table style="width: 900px; height: 500px">
		<tr>
			<td colspan="2"><jsp:include page="/CommonModule/Top.jsp" /> </td>
		</tr>
		<tr>
			<td  style="width: 200px"><jsp:include page="/CommonModule/Left.jsp" /> </td>
			<td style="width: 700px">
			
				<form action="ex29_loginProcess.jsp" method="post" name="loginForm">
					<center>
					<div>
						<table border="1">
							<tr>
								<th colspan="2"> Login Page </th>
							</tr>
							<tr>
								<th>아이디 : </th>
								<td><input type="text" name="id" id = "id" ></td>
							</tr>
							<tr>
								<th>비밀번호 : </th>
								<td><input type="password" name="pass" id = "pass" ></td>
							</tr>
							
							<tr>
								<td colspan="2"><input type="submit" id="btnsubmit" value="로그인">
								      <!-- <a href="ex29_joinForm.jsp">회원가입</a></td> -->
							</tr>							
						</table>
					</div>
					</center>
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="2"><jsp:include page="/CommonModule/Bottom.jsp" /> </td>
		</tr>
	</table>

</body>
</html>