<%@page import="member.MemberDAO"%>
<%@page import="member.MemberDTO"%>
<%@page import="utils.JSFunction"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/global_head.jsp" %>
<!-- 
글쓰기 페이지에서 오랫동안 머물러 세션이 소멸되는 경우가 발생할 수 있으므로
쓰기 처리를 할때도 반드시 세션을 확인해야 한다.
 -->
<%
request.setCharacterEncoding("UTF-8");
//폼값 받기
String name = request.getParameter("name");
String id = request.getParameter("id");
String pass = request.getParameter("pass");

String tel1 = request.getParameter("tel1");
String tel2 = request.getParameter("tel2");
String tel3 = request.getParameter("tel3");
String mobile1 = request.getParameter("mobile1");
String mobile2 = request.getParameter("mobile2");
String mobile3 = request.getParameter("mobile3");
String email1 = request.getParameter("email1");
String email2 = request.getParameter("email2");
String zip1 = request.getParameter("zip1");
String zip2 = request.getParameter("zip2");
String zip3 = request.getParameter("zip3");
String zip4 = request.getParameter("zip4");

//폼값과 로그인 아이디를 저장하기 위한 DTO객체
MemberDTO dto = new MemberDTO();
dto.setName(name);
dto.setId(id);
dto.setPass(pass);

dto.setTel1(tel1); 
dto.setTel2(tel2); 
dto.setTel3(tel3); 
dto.setMobile1(mobile1); 
dto.setMobile2(mobile2);
dto.setMobile3(mobile3);
dto.setEmail1(email1);
dto.setEmail2(email2);
dto.setZip1(zip1);
dto.setZip2(zip2);
dto.setZip3(zip3);
dto.setZip3(zip4);
// dto.setContent(content);

// //session 영역에 저장된 아이디는 String으로 변경 후 사용해야 한다.
// dto.setId(session.getAttribute("USER_ID").toString());

//DAO 객체 생성 및 쓰기 처리를 위한 메소드 호출
MemberDAO dao = new MemberDAO();



/* 여러개의 게시물을 한꺼번에 입력할때 사용하기. //조작용(한번에 100개)
int iResult=0;

for(int i=1; i<=100; i++){
	dto.settitle(i+"번째 "+title);
	iResult = dao.insertWrite(dto);
}
*/

int iResult = dao.insertMember(dto); //조작X(원래)시 사용
// int iResult = dao.getMemberMap(); //조작X(원래)시 사용

dao.close();
if(iResult==1){
// 	response.sendRedirect("ListSimple.jsp");
	JSFunction.alertLocation("회원가입을 축하합니다.", "../main/main.jsp", out);
// 	response.sendRedirect("join02.jsp");
}
else{
	JSFunction.alertBack("정보를 정확히 입력해주세요.", out);
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