<%@page import="sub03_freeboard.FreeBoardDTO"%>
<%@page import="sub03_freeboard.FreeBoardDAO"%>

<%@ include file="../member/isLogin.jsp" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/global_head.jsp" %>
<%
//파라미터 받기
String num = request.getParameter("num");//일련번호
String searchField = request.getParameter("searchField");//검색필드
String searchWord = request.getParameter("searchWord");//검색어

String queryStr = "";
if(searchWord!=null){
	//검색 파라미터 추가하기
	queryStr = "&searchField="+searchField+"&searchWord="+searchWord;
}

FreeBoardDAO dao = new FreeBoardDAO(application);
//조회수 증가
dao.updateVisitCount(num);

//파라미터로 전달된 일련번호를 조회
FreeBoardDTO dto = dao.selectView(num);
dao.close();
%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판-view</title>
<script>
/*
	Javascript를 통한 폼값 전송으로 삭제처리
*/
function isDelete() {
	var c = confirm("정말로 삭제하시겠습니까?");
	if(c) {
		var f = document.writeFrm;
		f.method = "post";
		f.action = "sub03_DeleteProcess.jsp";
		f.submit();
	}	
}
</script>
</head>

 <body>
<center>
<div id="wrap">
	<%@ include file="../include/top.jsp" %>

	<img src="../images/space/sub_image.jpg" id="main_visual" />

	<div class="contents_box">
		<div class="left_contents">
			<%@ include file = "../include/space_leftmenu.jsp" %>
		</div>
		<div class="right_contents">
			<div class="top_title">
				<img src="../images/space/sub03_title.gif" alt="자유게시판" class="con_title" />
				<p class="location"><img src="../images/center/house.gif" />&nbsp;&nbsp;열린공간&nbsp;>&nbsp;자유게시판<p>
			</div>
			<div>
				
				
				
			<form name="writeFrm">
			<input type="hidden" name="num" value="<%=num %>" />
			<!-- <form enctype="multipart/form-data"> -->
			<table class="table table-bordered">
			<colgroup>
				<col width="20%"/>
				<col width="30%"/>
				<col width="20%"/>
				<col width="*"/>
			</colgroup>
			<tbody>
				<tr>
					<th class="text-center" 
						style="vertical-align:middle;">작성자</th>
					<td><%=dto.getId() %></td>
					
					<th class="text-center" 
						style="vertical-align:middle;">작성일</th>
					<td><%=dto.getPostdate() %></td>
				</tr>
				
				<tr>
					<th class="text-center" 
						style="vertical-align:middle;">제목</th>
					<td>[<%=dto.getMal() %>] <%=dto.getTitle() %></td>
					
					<th class="text-center" 
						style="vertical-align:middle;">조회수</th>
					<td><%=dto.getVisitcount() %></td>
				</tr>
				
				
				<tr>
					<th class="text-center" 
						style="vertical-align:middle;">내용</th>
					<td colspan="3">
						<%=dto.getContent().replace("\r\n","<br/>") %>
					</td>
				</tr>
				
				<tr>
					<th class="text-center" 
						style="vertical-align:middle;">첨부파일</th>
					<td colspan="3">
						아직처리안함_파일명.jpg
					</td>
				</tr>
				
				
				
				<tr>
					<td colspan="4" align="center">
					<%
					/*
					로그인이 되었고, 동시에 해당 글을 작성한 작성자이면
					수정, 삭제 버튼을 보이게 처리한다.
					*/
					if(session.getAttribute("USER_ID")!=null &&
						session.getAttribute("USER_ID").toString().equals(dto.getId())){
					%>
						<button type="button" class="btn btn-primary"
							onclick="location.href='sub03_edit.jsp?num=<%=dto.getNum() %>&<%=queryStr %>';">
								수정하기</button>
						<button type="button" class="btn btn-success"
							onclick="isDelete();">삭제하기</button>
					<%
					} 
					%>
					
						<button type="button" class="btn btn-warning" 
							onclick="location.href='../space/sub03.jsp?<%=queryStr %>';">
							리스트보기
						</button>
					</td>
				</tr>
	
	
</tbody>
</table>

<div class="row text-center" style="">
	<!-- 각종 버튼 부분 -->
<!-- 	<button type="button" class="btn btn-primary" onclick="location.href='sub03_edit.jsp';">수정하기</button> -->
<!-- 	<button type="button" class="btn btn-success">삭제하기</button>	 -->
<!-- 	<button type="button" class="btn btn-warning"  -->
<!-- 		onclick="location.href='../space/sub03.jsp';">리스트보기</button> -->
</div>
</form> 

				</div>
			</div>
		</div>
		<%@ include file="../include/quick.jsp" %>
	</div>


	<%@ include file="../include/footer.jsp" %>
	</center>
 </body>
</html>