<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    buffer = "1kb" %>
    <!-- 버퍼는 지정하지 않으면 8kb로 설정된다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장객체-out</title>
</head>
<body>
	<%
	int total = out.getBufferSize(); //현재 페이지에 설정된 버퍼의 크기
	out.print("출력되지 않는 텍스트"); //일단 버퍼에 내용 저장됨.
	out.clearBuffer(); //버퍼를 비움(위에서 저장된 내용 사라짐)
	
	out.print("<h2>out 내장객체</h2>");
	out.print("출력 버퍼의 크기:"+total+"<br>");
	out.print("남은 버퍼의 크기:"+out.getRemaining()+"<br>");
	out.flush(); //버퍼의 내용 출력
	out.print("flush후 버퍼의 크기:"+out.getRemaining()+"<br>");
	
	//다양한 타입의 값을 출력
	out.print(1);
	out.print(false);
	out.print('가');
	%>
</body>
</html>