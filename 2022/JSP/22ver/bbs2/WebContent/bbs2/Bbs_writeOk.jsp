<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="my.bbs2.*, com.oreilly.servlet.*, com.oreilly.servlet.multipart.*, java.io.*"%>
<%
	request.setCharacterEncoding("UTF-8");
	BbsManager mgr = BbsManager.getInstance();
	MultipartRequest mr = null;
	
	try{
		//web2/bbs2/Upload/안에 업로드
		String upDir = application.getRealPath("/bbs2/Upload");
		// ServletContext타입의 내장객체 : application
		File up = new File(upDir);
		
		if(up != null){
			up.mkdir();
		}
		mr = new MultipartRequest(request,upDir,10*1024*1024,"UTF-8",new DefaultFileRenamePolicy());
		
	}catch(IOException e){
%>
	<b>파일 업로드 실패!</b>
<%
		e.getStackTrace();
	}
	
	int result = mgr.writeOk(mr);
	String msg = "글쓰기 ";
	String url = request.getContextPath()+"/bbs2/bbs_list.jsp";
	
	if(result>0){
		msg +="성공!";
	}else{
		msg +="실패!";
		url = request.getContextPath()+"/bbs2/bbs_write.jsp";
	}
%>	
<script type = "text/javascript">
<!--
	alert("<%=msg%>");
	location.href="<%=url%>";
-->
</script>



