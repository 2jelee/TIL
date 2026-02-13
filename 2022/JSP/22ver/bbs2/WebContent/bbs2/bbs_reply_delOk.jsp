<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="my.bbs2.*"%>
<%
	String delPwd = request.getParameter("delPwd");
	String no = request.getParameter("no");
	// hidden으로 넘긴 idx도 받아오자.
	String idx = request.getParameter("idx");
	
	if(delPwd == null || delPwd.trim().equals("")){
	%>
		<script>
			alert("비밀번호를 입력해 주세요!");
			location.href="bbs_content.jsp?idx=<%=idx%>";
		</script>
	<%	
	}
	
	if(delPwd == null || no == null || idx == null){
		out.println("delPwd or no or idx NULL");
		return;
	} //if -----------
	
	delPwd = delPwd.trim();
	no = no.trim();
	
	BbsManager mgr = BbsManager.getInstance();
	int result = mgr.replyDelPwd(no,delPwd); 
	
	String msg="", url="bbs_content.jsp?idx="+idx;
	
	if(result >0){
		msg ="꼬리말 삭제 성공";
	}else{
		msg = "꼬리말 삭제 실패";
	}
%>
<script type = "text/javascript">
	alert("<%=msg%>");
	location.href ="<%=url%>";
</script>