<%@page import="utils.JSFunction"%>
<%@page import="sub03_freeboard.FreeBoardDAO"%>
<%@page import="sub03_freeboard.FreeBoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//폼값 받기
String num = request.getParameter("num");
String title = request.getParameter("title");
String content = request.getParameter("content");

//DTO 객체에 폼값 저장
FreeBoardDTO dto = new FreeBoardDTO();
dto.setNum(num);
dto.setTitle(title);
dto.setContent(content);

//DAO객체 생성 및 메소드 호출
FreeBoardDAO dao = new FreeBoardDAO(application);
int affected = dao.updateEdit(dto);
dao.close();
if(affected==1){
	//수정 완료시 내용보기 페이지로 이동
	response.sendRedirect("sub03_view.jsp?num="+dto.getNum());
}
else {
	JSFunction.alertBack("수정하기에 실패했습니다.", out);
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