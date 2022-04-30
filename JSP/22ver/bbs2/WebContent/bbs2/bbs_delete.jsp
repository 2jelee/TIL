<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function check(){
		if(!f.pwd.value){
			alert("비밀번호를 입력해야 해요");
			f.pwd.focus();
			return;
		}
		f.submit();
	}
</script>
</head>
<body onloal="f.pwd.focus()">
<center>
	<form action="bbs_deletOk.jsp" name="f" method="post">
	<hr width=500 color=red>
	
	<!-- hidden으로 idx값을 넘겨주자. -->
	<%String idx = request.getParameter("idx"); %>
	
	<input type="hidden" name="idx" value="<%=idx%>">
	비밀번호:<input type="password" name="pwd">
	<input type="button" value="삭제" onclick="check()">
	<input type="reset" value="다시쓰기">
	<hr width=500 color=red>
	
	</form>
</center>
</body>
</html>