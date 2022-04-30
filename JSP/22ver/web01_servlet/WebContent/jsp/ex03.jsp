<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head>
<meta charset="UTF-8">
<title>JSP Page Test</title>
</head>
<body>
<!-- 스크립트릿 : Java 코드 O / 단, 함수는 사용할 수 없다. -->
<h2>스크립트릿</h2>
<%
	int x = 30;
	out.print(x);
	
	String str = "KOSA 화이팅";
	
	//함수 사용 불가하므로 error
	/* public void show(){
		out.print("KOSAAAAA");
	} */

	/* for(int i; i<11; i++){
		out.print(i+"\t");
	} */
%>

<h2>디클레이션</h2>
<%!
	public String show(){
		String name = "2jelee";
		return name;
	}

%>
<hr>
<!-- 디클레이션 : Java 코드 입력 O -->
<%  for(int i=1; i<11; i++){	%>
	<span> <%= i %> </span>
<% } %>
<hr>

<h2>표현식</h2>
<!-- 익스프레션 영역 : 문장 종결기호(;) 사용 X-->
<%= show() %>
<%= 3+5 %>
</body>
</html>