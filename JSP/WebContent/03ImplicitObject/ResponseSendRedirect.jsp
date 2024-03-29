<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ResponseSendRedirect.jsp</title>
</head>
<body>
<%
//폼값 받기
String id = request.getParameter("user_id");
String pwd = request.getParameter("user_pwd");

//대소문자 구분없이 아이디/패스워드 일치여부 확인
if(id.equalsIgnoreCase("kosmo") && pwd.equalsIgnoreCase("1234")){ //로그인 절차와 동일
	//JS의 location.href와 동일하게 해당 경로로 이동함.
	response.sendRedirect("../common/Welcome.jsp");
}
else{
%>
	<script>
		alert("아이디와 패스워드 불일치합니다.");
		history.go(-1);									// JS코드
	</script>
<%
	/* 
	같은 블럭 내에
	JSP코드와 JS코드가 존재하는 경우,
	***우선순위 : JSP코드 > JS코드
	이므로 JS코드는 무시됨.
	즉, 이와 같은 경우 JS코드는 실행되지 않고 아래 JSP코드만 실행되게 된다.
	*/
	response.sendRedirect("./ResponseMain.jsp"); // JSP코드
	/* JS코드를 실행하려면 JSP코드는 주석 처리를 해야한다. */
}
%>
</body>
</html>