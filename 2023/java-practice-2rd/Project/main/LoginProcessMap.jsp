<%@page import="member.MemberDAO"%>
<%@page import="utils.CookieManager"%>
<%@page import="utils.JSFunction"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- LoginProcess.jsp --%>
<%
//폼값으로 전송된 파라미터를 받아옴
String id = request.getParameter("user_id");
String pw = request.getParameter("user_pw");

//아이디저장 체크박스를 체크한 경우 전송되는 폼값
String save_check = request.getParameter("save_check");


//web.xml의 컨텍스트 초기화 파라미터 읽어옴
String drv = application.getInitParameter("MariaJDBCDriver1");
String url = application.getInitParameter("MariaConnectURL1");

//DAO객체 생성 및 DB연결
MemberDAO dao = new MemberDAO(drv, url);

//폼값으로 받은 아이디, 패스워드를 통해 로그인 처리 메소드 호출
Map<String, String> memberMap = dao.getMemberMap(id, pw);

/*
 	연습문제] 회원정보를 MemberDTO에 저장한 후 반환했던 부분을
		Map컬렉션에 저장한 후 반환하여 처리할수 있도록 수정하시오.
*/
if(memberMap.get("id") != null){
	//로그인에 성공한 경우 session영역에 회원인증정보를 저장한다. 
	session.setAttribute("USER_ID", memberMap.get("id"));
	session.setAttribute("USER_PW", memberMap.get("pass"));
	session.setAttribute("USER_NAME", memberMap.get("name"));
// 	//로그인 페이지로 이동
// 	response.sendRedirect("main.jsp");
// }
 	
	if(save_check!=null && save_check.equals("Y")){
		//아이디 저장 체크박스에 체크한 경우 쿠키를 생성한다. 
		//쿠키명:loginId , 쿠키값:입력한아이디, 유효시간:1일
// 		CookieManager.makeCookie(response, "loginId", user_id, 86400);
		CookieManager.makeCookie(response, "loginId", "id", 86400);
	}
	else{
		//체크박스에 체크하지 않은경우 쿠키를 삭제한다. 
		CookieManager.deleteCookie(response, "loginId");
	}
	//환영 메세지를 경고창으로 띄우고 로그인 페이지로 이동한다. 
// 	JSFunction.alertLocation("로그인에 성공했습니다.", "main.jsp", out);
	//로그인 페이지로 이동
	response.sendRedirect("main.jsp");
}
 	
else {
// 	//로그인 실패시 request영역에 속성을 저장한다. 
// 	request.setAttribute("ERROR_MSG", "로그인에 실패했습니다.");
// 	//로그인 페이지로 포워드(전달) 한다.
// 	request.getRequestDispatcher("main.jsp").forward(request,response);
	//로그인에 실패하는 경우...
	JSFunction.alertBack("아이디 및 비밀번호를 확인해주세요.", out);
}
%>





