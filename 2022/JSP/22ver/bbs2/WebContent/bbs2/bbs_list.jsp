<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, my.bbs2.*,java.io.*"%>
<%
	BbsManager mgr = BbsManager.getInstance();
	
	//총게시물 수
	int totalCount = mgr.getTotalGulCount();
	// 총게시물수:totalCount,
	// 페이지 사이즈 : pagesize --- ps[ 5개 단위로 보여주기 ]
	// 현재 페이지 : cpage ----- cp[1페이지, 2페이지....]
	// 페이지수 : pageCount

	String psStr = request.getParameter("ps");
	String cpStr = request.getParameter("cp");
	
	if(psStr == null || psStr.trim().equals("")){
		psStr=(String)session.getAttribute("ps");
		if(psStr==null|| psStr.trim().equals("")){
		psStr ="3"; // 기본페이지 사이즈로 3을 지정
					   // 즉 3개 단위로 보여주기 
		}
	}
	if(cpStr == null || cpStr.trim().equals("")){
		cpStr=(String)session.getAttribute("cp");
		if(cpStr==null|| cpStr.trim().equals("")){
			cpStr ="1"; 
		}
		// default = 현재페이지를 1페이지로 지정....
	}
	
	session.setAttribute("cp",cpStr);
	session.setAttribute("ps",psStr);
	
	int pageSize = Integer.parseInt(psStr.trim());
	int cpage = Integer.parseInt(cpStr.trim());
	int pageCount = 0;
	
	//페이지수 구하기.....
	//pageSize : 5개
	//totalCount :1~ 4 |  5
	//pageCount : 1    | 1
	
	//if(totalCount%pageSize == 0){
	//	pageCount = totalCount/pageSize;
	//}else{
	//	pageCount = totalCount/pageSize+1;	
	//}
	
	pageCount = (totalCount-1)/pageSize+1;
	
	///////////////////////////////////////////////////////
	ArrayList<BbsDTO> arr = mgr.listAll(cpage,pageSize);
	// 매개변수로 현재페이지[cpage]와 페이지사이즈[pageSize]를 넣어주자..
	///////////////////////////////////////////////////////
		
	
	
	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bbs_list.jsp</title>
<style>

<!--
a:link { text-decoration:none; }
a:visited { text-decoration:none; }
a:active { text-decoration:none; }
a:hover { color:rgb(82,156,255); text-decoration:none; }
-->

A:link, A:active A:visited { 
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
		<font size=5 color="blue" face="굴림체">
			Kosta 게시판
		</font>
	<br>
	<hr width=500 color="red">
	<a href="/bbs2/bbs2/bbs_write.jsp">글쓰기</a>|<a href="/bbs2/bbs2/bbs_list.jsp">HOME</a>
	<hr width=500 color="red">
	<br>
	<!-- 페이지 사이즈 선택 select박스 -->
	<form name="f" method="get">
		<select name="ps" onchange="submit()">
		<%if (pageSize == 3) {%>
			<option value="3" selected>페이지 SIZE선택 3</option>
		<%}else{ %>
			<option value="3">페이지 SIZE선택 3</option>	
		<%} 
			for(int i=5;i<=20;i+=5){
				if(pageSize==i){
		%>
					<option value="<%=i %>" selected>페이지 SIZE선택 <%=i %>
		<%			
				}else{
		%>
					<option value="<%=i %>">페이지 SIZE선택 <%=i %>
		<%
				} //else -----
			} // for ----------
		
		
		%>
		</select>
	
	</form>
	<table width=500 border=1>
		<tr>
			<th width="10%">순번</th>
			<th width="40%">제목</th>
			<th width="15%">글쓴이</th>
			<th width="20%">날짜</th>
			<th>조회</th>
		</tr>
<%
		
	if( arr ==null || arr.size()==0){
%>	
	<Tr>
		<td colspan = 5 align="center">서버오류이거나 게시물이 없어요</td>
	</Tr>		
<%
	}else{
		ListIterator it = arr.listIterator();
		// 성민이 코드
		// for(BbsDTO : arr)
		while(it.hasNext()){
			BbsDTO dto = (BbsDTO)it.next();
		// 말줄임표 사용하기 위해셔~~	
			String subject = dto.getSubject();
			String writer = dto.getWriter();
			
		if(subject != null && subject.length() >10){
			// 제목이 10문자 이상이라면...
			subject = subject.substring(0,11);
			subject += "...";
		}
		
		if(writer != null && writer.length() >10){
			// 제목이 10문자 이상이라면...
			writer = writer.substring(0,11);
			writer += "...";
		}
			
%>
		<tr align="center">
			<td><%= dto.getIdx() %></td>
			<td align="left">
			<%//쿼리 스트링 만들기...
				// 들여쓰기 하기 위해서~
				String qstr = "refer="+dto.getRefer()+"&sunbun="+dto.getSunbun()+"&lev="+dto.getLev()+"&";
			
				int lev = dto.getLev(); //답글 들여쓰기
				for(int i=0; i<lev; i++){
					out.println("&nbsp;&nbsp;&nbsp;");
				}
				if(lev >0){ // 답글이라면....
					out.println("-->");
				}
			%>
			<a href="bbs_content.jsp?<%=qstr%>idx=<%=dto.getIdx()%>&cp=<%=cpage%>&ps=<%=pageSize%>">
				<%= subject %>
			</a></td>
			<td><a href="mailto:<%=dto.getEmail() %>">
				<%= writer %>
			</a></td>
			<td><%= dto.getWritedate() %></td>
			<td><%= dto.getReadnum() %></td>
		</tr>
		
<%
		}
	}
%>
		<tr>
			<td colspan=5 align = center>
			<hr width=500 color=greed>
			</td>
		</tr>
		<tr>
		<td colspan=3 align="center">
<% 
	if(cpage >1){
%>
		<a href="bbs_list.jsp?cp=<%=cpage-1%>&ps=<%=pageSize%>">◀이전</a>|
<%		
	} // if ------

	for(int i =1; i<=pageCount; i++){

		if(cpage == i){
%>
			[<%= i %>]

<%
		}else{
%>
			<a href="bbs_list.jsp?cp=<%=i%>&ps=<%=pageSize%>">[<%= i %>]</a>
<%
		}
	} // for --------------
	if(cpage < pageCount){
%>
		|<a href="bbs_list.jsp?cp=<%=cpage+1%>&ps=<%=pageSize%>">이후▶</a>
<%
	}
%>
			</td>

			<td colspan=2 align="center">총 게시물수 :<font 	color="red"><b> <%= totalCount %></b></font> 
			<br>현재 페이지<font color="blue"> <%=cpage%></font>/<%=pageCount %> </td>
		</tr>
	</table>
	
</center>
</body>
</html>