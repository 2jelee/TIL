<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- error page로 사용할 페이지에는 기재 되어 있어야함 -->
    <%@ page errorPage="/Error/CommonError.jsp" %>
    
<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error Page Test</title>
</head>
<body>
  <!-- http://localhost:9999/web03_jsp/jsp/ex11_errorPage.jsp?name=kingsmile -->
    name 값 : <%= request.getParameter("name").toUpperCase() %>
</body>
</html>