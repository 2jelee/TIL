<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
		public int add(int i, int j) {
			return i+j;
		}

		public int mul(int i, int j) {
			return i*j;
		}
%>
    
<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Basic</title>
</head>
<body>
	Hello World <br />
	<% int i =9999; %>
	변수 값 : <%= i %> <br />
	함수 호출 :
	<%
			int result = add(10, 2);
			int result2 = mul(30, 20);
	%> 
	 결과 :  <%= result %> <br />
	 결과2 :  <%= result2 %> <br />
	 
	 1~100 까지의 합을 출력 합니다.
	 <%
	 		int sum =0;
	 		for(int j=1; j <= 100; j++ ) {
	 			sum += j;
	 		}
	 %>
	 
	 sum = <%= sum %>
	 
</body>
</html>





