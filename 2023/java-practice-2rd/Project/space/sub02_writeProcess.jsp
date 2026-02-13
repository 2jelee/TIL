<%@page import="sub02_shortboard.ShortBoardDAO"%>
<%@page import="sub02_shortboard.ShortBoardDTO"%>
<%@page import="utils.JSFunction"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/global_head.jsp" %>
<%@ include file="../member/isLogin.jsp" %>
<!-- 
글쓰기 페이지에서 오랫동안 머물러 세션이 소멸되는 경우가 발생할 수 있으므로
쓰기 처리를 할때도 반드시 세션을 확인해야 한다.
 -->
<%
request.setCharacterEncoding("UTF-8");
//폼값 받기
String title = request.getParameter("title");
String content = request.getParameter("content");

//폼값과 로그인 아이디를 저장하기 위한 DTO객체
ShortBoardDTO dto = new ShortBoardDTO();
dto.setTitle(title);
dto.setContent(content);

//session 영역에 저장된 아이디는 String으로 변경 후 사용해야 한다.
dto.setId(session.getAttribute("USER_ID").toString());

//DAO 객체 생성 및 쓰기 처리를 위한 메소드 호출
ShortBoardDAO dao = new ShortBoardDAO(application);

/* 여러개의 게시물을 한꺼번에 입력할때 사용하세요. //조작용(한번에 100개)
int iResult=0;

for(int i=1; i<=100; i++){
	dto.settitle(i+"번째 "+title);
	iResult = dao.insertWrite(dto);
}
*/
int iResult = dao.insertWrite(dto); //조작X(원래)시 사용

dao.close();
if(iResult==1){
// 	response.sendRedirect("ListSimple.jsp");
	response.sendRedirect("sub02.jsp");
}
else{
	JSFunction.alertBack("글쓰기에 실패하였습니다.", out);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 </body>
</html>