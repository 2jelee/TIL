<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cookie</title>
</head>
<body>
<%
		Cookie newCookie = new Cookie("newName", "kingsmile");
		//newCookie.setMaxAge(0);  // 사용 기간을 0으로 만들면 <--- 소멸
		newCookie.setMaxAge(60);  // 60초,   30일(30*24*60*60)  일*시*분*초 
		response.addCookie(newCookie);
%>
<hr>
<%
		Cookie[]  cs = request.getCookies();

		if( cs != null ||  cs.length > 0 ) {
			
			for(int i=0; i < cs.length; i++ ) {
				if( cs[i].getName().equals("newName")) {
					// 재설정
					Cookie  x = new Cookie("newName" , "33344");
					response.addCookie(x);
				} // in if end
				out.print( cs[i].getName() + "<br>");
				out.print( cs[i].getValue() + "<br>");
			} // for end
		} else {
			out.print("client 저장된 쿠키 정보가 없습니다. ");
		}
%>
</body>
</html>





