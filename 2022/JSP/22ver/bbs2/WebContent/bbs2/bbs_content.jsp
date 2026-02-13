<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="my.bbs2.*, java.io.*, java.util.*" %>

<%
	String idx = request.getParameter("idx");
	
	if(idx == null || idx.trim().equals("idx")){
		response.sendRedirect("bbs_list.jsp");
		return;
	}
	
	idx = idx.trim();
	// 2. 비지니스 메소드 호출
	BbsManager mgr = BbsManager.getInstance();
	
	// 3. 조회수 증가 /////////////////////////////////
	boolean bool = mgr.getReadnum(idx);
	System.out.println(bool);
	///////////////////////////////////////////////
	
	BbsDTO  dto = mgr.viewContent(idx);
	
	

	if(dto == null){
		response.sendRedirect("bbs_list.jsp");
		return;
	}
	
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function check(){
		if(!reply.reply_content.value){
			alert("내용을 입력하세요");
			reply.reply_content.focus();
			return;
		}
		if(!reply.reply_pwd.value){
			alert("비밀번호를 입력하세요");
			reply.reply_pwd.focus();
			return;
		}
		if(!reply.reply_writer.value){
			alert("이름을 입력하세요");
			reply.reply_writer.focus();
			return;
		}
		
		document.reply.submit();
	}
	
	function check1(){
		if(!replyDel.delPwd.value){
			alert(replyDel.delPwd.value);
			return false;
		}
		document.replyDel.action ="reply_delOk.jsp";
		return true;
	}
</script>

<style>

<!--
a:link { text-decoration:none; }
a:visited { text-decoration:none; }
a:active { text-decoration:none; }
a:hover { color:rgb(82,156,255); text-decoration:none; }
-->

A:link, A:active{ 
color: red; 
font-size: 11pt; 
text-decoration: none; 
}

A:visited { 
color: green; 
font-size: 11pt; 
text-decoration: none; 
}  

A:hover { 
color: 000000; 
font-size: 11pt; 
text-decoration: underline; 
}  

</style>
</head>
<body>
<center>
	<br>
		<font size=5 color=green face=궁서체>
			KOSTA's 게시판 글 내용
		</font>
		<br><br>
	<hr width=500 color=green>
		<a href = "/bbs2/bbs2/bbs_write.jsp">글쓰기</a>|
		<a href="/bbs2/bbs2/bbs_list.jsp">HOME</a>
	<hr width=500 color=green>
	<br>
	
	<table width=600 border=1>
		<tr>
			<td width="20%" align="center"><B>글번호</B></td>
			<td width="30%" align="center"><%=dto.getIdx() %></td>
			<td width="20%" align="center">날짜</td>
			<td width="30%" align="center"><%= dto.getWritedate() %></td>
		</tr>
		<tr>
			<td width="20%" align="center"><B>글쓴이</B></td>
			<td width="30%" align="center"><%= dto.getWriter() %></td>
			<td width="20%" align="center">홈페이지</td>
			<td width="30%" align="center"><%=dto.getHomepage() %></td>
		</tr>
		<tr>
			<td colspan=3>&nbsp;</td>
			<td colspan=1>조회수 : <%=dto.getReadnum() %></td>
		</tr>
		<tr>
			<td colspan=4 align="center" bgcolor="#efefef">
				<b>제 목 : <%=dto.getSubject() %></b>
			</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
			<%= dto.getContent().replaceAll("\r\n","<br>") %>
			</td>
		</tr>
		<tr>
			<td align=center>첨부파일</td>
			<%
				String filename = dto.getFilename();
				if(filename ==null){
					filename = "";
				}
			%>
			<td colspan=3><%=filename %> [<%= dto.getFilesize() %> bytes]</td>
		</tr>
<%
	String cp = request.getParameter("cp");
	String ps = request.getParameter("ps");
	

%>

		<tr>
			<td colspan=4 align=center>
				<a href="bbs_list.jsp?cp=<%=cp%>&ps=<%=ps %>">목록</a>|
				<a href="bbs_edit.jsp?idx=<%=dto.getIdx() %>">편집</a>|
				<a href="bbs_delete.jsp?idx=<%=dto.getIdx() %>">삭제</a>|
				<!-- 답변형 추가  -->
				<a href="bbs_rewrite.jsp?idx=<%=dto.getIdx() %>&cp=<%=cp%>&ps=<%=ps %>">답변</a>
			</td>
		</tr>
		</table>
		<!-- 꼬리말 달기 테이블 -->
		<form action="bbs_replyOk.jsp" method="POST" name="reply">
			<input type=hidden name="idx" value="<%=dto.getIdx()%>">
			<table width=600 border=1>
				<tr>
					<td><b>리플 달기</b></td>
					<td colspan=3 align="left">&nbsp;&nbsp;&nbsp;
						내  용
						&nbsp;&nbsp;&nbsp;<textarea name=reply_content row= 5 cols=70 ></textarea><br>
						
						&nbsp;&nbsp;&nbsp;작성자 <input type=text name="reply_writer" size=10>
						비밀번호 <input type=password name=reply_pwd size=4>
						<input type=button value="등록" onclick="javascript:check();">
						
					</td>
				</tr>
				
			</table>
		</form>
		<!-- 꼬리말 목록 보기 테이블  -->
		<table border=1 width=600>
			<tr align=center>
				<td colspan=2 bgcolor="dgegeg"><b>REPLY</b></td>
			</tr>
			<%
				java.util.ArrayList<ReplyDTO> replyList = mgr.replyList(idx);
			
				if(replyList == null || replyList.size() == 0){
			%>
				<tr>
					<td colspan=2><b>서버오류이거나 게시물이 없어요</b></td>
				</tr>
			<%
					return;
				}// if ----------
			
				for(ReplyDTO rdto : replyList){ 
			%>
			
			<tr>
				<td width="80%" align="left">[<%=rdto.getWriter() %>]:[<%=rdto.getContent() %>]<br>
				작성일:<%=rdto.getWritedate().toString() %>
				</td>
				<td>
				<form name="replyDel"  method="post" action="bbs_reply_delOk.jsp">
				PASSWORD
				<!-- hidden :  no를 hidden으로 넘기자 -->
				<input type=hidden name="no" value="<%=rdto.getNo() %>">
				<input type=hidden name="idx" value="<%=dto.getIdx()%>">
				
				<input type="password" size=6 name="delPwd">
				<input type="submit" value="전송">
				</form>
				</td>
			</tr>
			<%} // for------- %>
			
		</table>
</center>
</body>
</html>