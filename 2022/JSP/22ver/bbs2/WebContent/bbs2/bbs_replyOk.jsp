<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="my.bbs2.*"%>
<%
	// 1. 사용자가 입력한 꼬리말 달기 글 얻어오기.
	request.setCharacterEncoding("UTF-8");
	String writer = request.getParameter("reply_writer");
	String content = request.getParameter("reply_content");
	String pwd = request.getParameter("reply_pwd");
	// hidden으로 넘긴 idx도 받아오자.
	String idx = request.getParameter("idx");
	String cp = (String)session.getAttribute("cp");
	String ps = (String)session.getAttribute("ps");
	
	// 2. null check
	if(idx == null || idx.trim().equals("")){
		response.sendRedirect("bbs_list.jsp");	
		return;
	}
	
	// 비지니스 메소드 호출 //////////////////////
	BbsManager mgr = BbsManager.getInstance();
	int result = mgr.replySave(idx,writer,content,pwd); 
	
	String msg="";
	String url = "bbs_content.jsp?idx="+idx+"&cp="+cp+"&ps="+ps;
	
	if(result>0){
		msg= "꼬리말 달기 성공";
	}else{
		msg = "꼬리말 달기 실패";
	}
%>
<script type="text/javascript">
<!--
	alert("<%=msg%>");
	location.href = "<%=url%>";
//-->
</script>
