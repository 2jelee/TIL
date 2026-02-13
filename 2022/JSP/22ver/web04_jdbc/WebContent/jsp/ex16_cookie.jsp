<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cookie</title>
</head>
<body>
<!--  window 7
  C:\Users\KOSTA\AppData\Roaming\Microsoft\Windows\Cookies -->
  
  <%
  		Cookie cookie = new Cookie("name", "doyeon");
  		//Client 브라우저에게 Cookie 전달
  		response.addCookie(cookie);
  %>
<hr>
	서버 도메인 이름 : <%= cookie.getDomain() %> <br>
	서버에서 설정 이름 : <%= cookie.getName() %> <br>
	서버에서 설정 값 : <%= cookie.getValue() %> <br>
<hr>
<%
	// Client 쿠키 정보 읽어오기
	Cookie[] cs = request.getCookies();

	if( cs != null ||  cs.length > 0 ) {
		
		for(int i=0; i < cs.length; i++ ) {
			out.print( cs[i].getName() + "<br>");
			out.print( cs[i].getValue() + "<br>");
		}
		
	} else {
		out.print("client 저장된 쿠키 정보가 없습니다.");
	}
%>

</body>
</html>




