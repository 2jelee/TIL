<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="my.bbs2.*, com.oreilly.servlet.*, com.oreilly.servlet.multipart.*" %>

 <%
 	request.setCharacterEncoding("UTF-8");	
 
 	BbsManager mgr = BbsManager.getInstance();
 	MultipartRequest mr = null;
 	String upDir = application.getRealPath("/bbs2/Upload");
 	out.println(upDir);
 	//절대경로 출력.
 	
 	try{
 		mr = new MultipartRequest(request, upDir, 10*1024*1024, "UTF-8", new DefaultFileRenamePolicy());	
 		
 	
 	
 	}catch(Exception e){
 	%>
 		<b>파일 첨부 실패</b>
 	<% 
 		e.printStackTrace();
 		return;
 	} 
 	//비지니스 메소드 호출 ////////////////////////////
 	int result = mgr.rewriteOk(mr);  
 	String cp = mr.getParameter("cp");
 	String ps = mr.getParameter("ps");
 	
 	String msg ="", url="bbs_list.jsp?cp="+cp+"&ps="+ps;
 	
 	if(result>0){
 		msg ="답글 쓰기 성공!";
 	}else{
 		msg="답글 쓰기 실패!";
 	}
 	
 	//////////////////////////////////////////////////
 %>
 <<script type="text/javascript">
<!--
	alert("<%=msg%>");
	location.href="<%=url%>";
//-->
</script>
    