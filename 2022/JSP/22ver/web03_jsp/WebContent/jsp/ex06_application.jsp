<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>application 웹 경로</title>
</head>
<body>
	<!-- 
	가상경로 : (웹 브라우저에서 바라보는 경로)
	http://localhost:9999/web03_jsp/download/memo.txt
	
	물리적 경로 :
	E:\th160\th160_Jsp_Servlet\workspace\web03_jsp\WebContent\download\memo.txt
	
	이클리스 통한 톰켓 구동시 물리적 경로 :
	E:\th160\th160_Jsp_Servlet\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\web03_jsp\download\memo.txt
	 -->
	
<%
	String resourcePath = "/download/memo.txt";
	out.print(resourcePath + "<br />");
	
	// 가상경로에서 -----> 물리적 경로 얻어내기
	out.print(request.getContextPath() + "<br />");
	
	String contextPath = application.getRealPath(request.getContextPath());
	String realPath = application.getRealPath(resourcePath);
	out.print("contextPath : " + contextPath + "<br />");
	out.print("realPath : " + realPath + "<br />");
	
%>
</body>
</html>





