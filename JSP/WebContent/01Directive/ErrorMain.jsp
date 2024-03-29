<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="ErrorPage.jsp"
    %>
  <%--
  	errorPage 지시어
  		: 해당 페이지에서 에러(예외)가 발생했을 때
  		예외처리를 설정한 페이지에서 하겠다는 선언으로
  		500에러와 같은 페이지를 사용자에게 보여주지 않게 되므로
  		사이트에 대한 신뢰도를 높일 수 있다.
  --%>  
  <%
  //사용자가 전송한 파라미터를 request 객체를 통해 받아온다.
  String strAge = request.getParameter("age");
  
  //콘솔에 로그로 내용을 출력한다.
  System.out.println("strAge="+ strAge);
  //웹브라우져에 내용을 출력함. JS의 document.write()와 같음.
  out.println("strAge="+ strAge);
  
  int ageAfter10 = -1;
  String errorStr = "";
  
  /*
  해당 페이지로 폼값을 전송할 때 "나이" 부분을 공백상태로 혹은 숫자가 아닌 문자를
  입력 후 전송하면 해당 코드에서 에러가 발생함.
  Integer.parseInt()는 숫자형식이 아닌 경우, 예외가 발생함.
  */
  if(strAge != null){
	  ageAfter10 = Integer.parseInt(strAge) + 10; //Integer : 정수
  }
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ErrorMain.jsp</title>
</head>
<body>
	<h2>에러가 발생할 페이지</h2>
	<form action="">
		나이를 입력하세요
		<input type="text" name="age"/>
		<input type="submit" value="확인"/>
		<br />
		#나이를 입력하지 않고 전송하면 에러가 발생합니다.
	</form>
	<span style="color:red; font-size:2em;">
		<% if(ageAfter10 != -1) { %>
			당신의 10년후 나이는 <%=ageAfter10 %>살입니다.
		<% } else { %>
			<%= errorStr %>
		<% } %>
	</span>
</body>
</html>