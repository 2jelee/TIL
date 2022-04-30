<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="my.bbs2.*" %>
<%--
	1. idx와 비밀번호 받아오기
	2. 널 체크
	3. BbsManager객체 얻어와서
	4. mgr의 deleteOk(idx, pwd)호출
	5. 그 결과에 따라 메시지 출력.
--%>

<%
	//1. 구현
	String idx = request.getParameter("idx");
	String pwd = request.getParameter("pwd");

	if(idx == null || pwd ==null ||idx.trim().equals("idx")||pwd.trim().equals("pwd")){
		response.sendRedirect("bbs_list.jsp");
		return;
	}
	idx = idx.trim();
	pwd = pwd.trim();
	
	System.out.println(idx+"==="+pwd);
	
	BbsManager mgr = BbsManager.getInstance();
	int n = mgr.deleteOk(idx,pwd);
	
	
	String url="", message="";
	
	if(n>0){
		url ="bbs_list.jsp";
		message = "삭제 성공";
		
	}else{

		message = "삭제 실패";
		url = "bbs_content.jsp?idx="+idx;	
	}
%>
<script type="text/javascript">
<!--
	alert("<%=message%>");
	location.href="<%=url%>";
-->
</script>

