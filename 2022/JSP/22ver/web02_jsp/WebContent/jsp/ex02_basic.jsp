<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Basic</title>
</head>
<body>
	<!-- 스크립트릿 : 자바, 변수선언, 제어문 등등..... -->
	<%
		/* post 방식으로 전송시 한글 깨짐 처리 */
		request.setCharacterEncoding("utf-8");
	
		int su =100;
		for(int i = 0; i < 10; i++ ) {
	%>		
		<%= i %>
	<%	
		} // for end
		
	/* 	public void show() {
			
		} */
	%>

<!-- 선언문 : 자바, 변수선언, 제어문, **함수**, .... -->
<%!
		public String show() {
			return "안녕하세요";
		}
%> <br />
<!-- 표현식 -->
<%= su %> <br />
<%= show() %>

  <!-- 
	  <div>
	  		<p></p>
	  </div>
   -->
   
   <%-- <%= "이도연입니다" %> --%>
</body>
</html>







