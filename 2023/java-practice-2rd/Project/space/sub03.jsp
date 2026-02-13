<%@page import="utils.BoardPage"%>
<%@page import="sub03_freeboard.FreeBoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="common.BoardConfig"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="sub03_freeboard.FreeBoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/global_head.jsp" %>
<%
//application내장객체를 인수로 DAO객체를 생성한다.(DB연결)
FreeBoardDAO dao = new FreeBoardDAO(application);

//파라미터를 저장하기 위해 Map컬렉션 생성
Map<String, Object> param = new HashMap<String, Object>();

//검색에 대한 파라미터를 받아서 변수에 저장
String searchField = request.getParameter("searchField");//검색할 필드명
String searchWord = request.getParameter("searchWord");//검색어

//검색 파라미터 추가 위한 변수
String queryStr = "";

//사용자가 검색을 했다면...
if(searchWord!=null){
	//검색필드와 검색어를 Map에 추가한다. 
	param.put("searchField", searchField);
	param.put("searchWord", searchWord);
	
	//검색 파라미터 추가하기
	queryStr = "&searchField="+searchField+"&searchWord="+searchWord;
}
//게시물의 전체 갯수를 카운트하기 위한 메소드 호출
int totalCount = dao.selectCount(param);

/**** 페이지처리 start ***/
int pageSize = BoardConfig.PAGE_PER_SIZE;//한페이지에 출력할 게시물의 갯수
int blockPage = BoardConfig.PAGE_PER_BLOCK;//한 블럭당 출력할 페이지번호의 갯수
int totalPage = (int)Math.ceil((double)totalCount/pageSize);//전체 페이지 수 계산
int pageNum = 1; //목록 첫 진입시에는 무조건 1페이지로 지정
//만약 파라미터로 전달된 페이지번호가 있다면..
String pageTemp = request.getParameter("pageNum");
if(pageTemp!=null && !pageTemp.equals(""))
	pageNum = Integer.parseInt(pageTemp);//해당 번호로 페이지번호를 지정한다.
	

	
/*
한페이지에 출력할 게시물의 범위를 결정한다. MariaDB에서는
limit를 사용하므로 start(시작위치)만 계산하면 된다.
	start => 
		1페이지일때 : (1-1) * 2 = 0
		2페이지일때 : (2-1) * 2 = 2
	end => 		
		한페이지에 출력할 게시물의 갯수인 pageSize를
		그대로 사용하면 된다. 
*/
int start = (pageNum-1) * pageSize;
int end = pageSize;


//계산된 값은 Map컬렉션에 저장
param.put("start", start);
param.put("end", end);
/***페이지처리 end ***/

//목록에 실제 출력할 레코드를 얻어오기 위한 메소드 호출
List<FreeBoardDTO> boardLists = dao.selectListPage(param);
//자원해제
dao.close();
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판-리스트</title>
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
				<img src="../images/space/sub03_title.gif" alt="공지사항" class="con_title" />
				<p class="location"><img src="../images/center/house.gif" />&nbsp;&nbsp;열린공간&nbsp;>&nbsp;자유게시판<p>
			</div>
		<div>

		<div class="row text-right" style="margin-bottom:20px;
				padding-right:50px;">
				
				
		<!-- 검색부분 -->
<!-- 		<form class="form-inline">	 -->
<!-- 			<div class="form-group"> -->
<!-- 				<select name="searchField" class="form-control"> -->
<!-- <!-- 				<select name="keyField" class="form-control"> --> 
<!-- 					<option value="title">제목</option> -->
<!-- 					<option value="writer">작성자</option> -->
<!-- 					<option value="content">내용</option> -->
<!-- 				</select> -->
<!-- 			</div> -->
<!-- 			<div class="input-group"> -->
<!-- 				<input type="text" name="keyString"  class="form-control"/> -->
<!-- 				<div class="input-group-btn"> -->
<!-- 			<!-- 돋보기 아이콘 --> 
<!-- 			<button type="submit" class="btn btn-default"> -->
<!-- 				<i class="glyphicon glyphicon-search"></i> -->
<!-- 			</button> -->
		<form method="get">
		<div class="form-group">
			<table border="0" width="90%">
				<tr>
					<td align="right">
						<select name="searchField">
							<option value="title">제목</option>
							<option value="mal">말머리</option>	
							<option value="writer">작성자</option>
							<option value="content">내용</option>
						</select>
						<input type="text" name="searchWord" />
						<input type="submit" value="검색하기" />
					</td>
				</tr>	
			</table>	
		</div>
		</form>
	</div>
		
		
		
		
	<div class="row">
	
		<!-- 게시판리스트부분 -->
		<table class="table table-bordered table-hover">
		<colgroup>
			<col width="50px"/>
<!-- 			<col width="60px"/> -->
			<col width="*"/>
			<col width="120px"/>
			<col width="120px"/>
			<col width="80px"/>
			<col width="50px"/>
		</colgroup>
	
	<thead>
	<tr class="success">
		<th class="text-center">번호</th>
<!-- 		<th class="text-center">말머리</th> -->
		<th class="text-left">제목</th>
		<th class="text-center">작성자</th>
		<th class="text-center">작성일</th>
		<th class="text-center">조회수</th>
		<th class="text-center">첨부</th>
	</tr>
	</thead>
	
	<tbody>
	
	
	
	
	
	<!-- 리스트반복 -->
	
<!-- 	<tr> -->
<!-- 		<td class="text-center">번호</td> -->
<!-- 		<td class="text-left"><a href="sub01_view.jsp">제목</a></td> -->
<!-- 		<td class="text-center">작성자</td> -->
<!-- 		<td class="text-center">작성일</td> -->
<!-- 		<td class="text-center">조회수</td> -->
<!-- 		<td class="text-center">첨부</td> -->
<!-- 	</tr> -->
<%
if(boardLists.isEmpty()){
%>
		<tr>
			<td colspan="5" align="center">
				등록된 게시물이 없습니다.
			</td>
		</tr>
<%
}
else{
	int vNum = 0;//목록의 가상번호로 사용
	int countNum = 0;	
	for(FreeBoardDTO dto : boardLists)
	{
		vNum = totalCount - (((pageNum-1) * pageSize) + countNum++);
%>
		<tr align="center">
			<td><%=vNum%></td>
			<td align="left">
				<a href="sub03_view.jsp?num=<%=dto.getNum()%>&<%=queryStr %>">[<%=dto.getMal()%>] <%=dto.getTitle()%></a>
			</td>
			
<!-- 			<td align="center"></td> -->
			<td align="center"><%=dto.getId()%></td>
			<td align="center"><%=dto.getPostdate()%></td>
			<td align="center"><%=dto.getVisitcount()%></td>
			<td align="center"><%=dto.getOfile()%></td><!-- 첨부파일 -->
			
		</tr>
<%
	}
}
%>
	</table>
	
</div>
<div class="row text-right" style="padding-right:50px;">












	<!-- 각종 버튼 부분 -->
	<!-- <button type="reset" class="btn">Reset</button> -->
		
	<button type="button" class="btn btn-default" 
		onclick="location.href='sub03_write.jsp';">글쓰기</button>
				
<!-- 	<button type="button" class="btn btn-primary" -->
<!-- 		onclick="location.href='sub03_edit.jsp';">수정하기</button> -->
<!-- 	<button type="button" class="btn btn-success">삭제하기</button> -->
<!-- 	<button type="button" class="btn btn-info">답글쓰기</button> -->
<!-- 	<button type="button" class="btn btn-warning">리스트보기</button> -->
<!-- 	<button type="submit" class="btn btn-danger">전송하기</button> -->
</div>


<div class="row text-center">
	<!-- 페이지번호 부분 -->
	<ul class="pagination">
		<li><span class="glyphicon glyphicon-fast-backward"></span></li>
	<%=BoardPage.pagingStr(totalCount, pageSize, blockPage, 
						pageNum, request.getRequestURI(), queryStr)%>		
<!-- 		<li><a href="#">1</a></li>		 -->
<!-- 		<li class="active"><a href="#">2</a></li> -->
<!-- 		<li><a href="#">3</a></li> -->
<!-- 		<li><a href="#">4</a></li>		 -->
<!-- 		<li><a href="#">5</a></li> -->
		<li><span class="glyphicon glyphicon-fast-forward"></span></li>
	</ul>	
</div>

				</div>
			</div>
		</div>
		<%@ include file="../include/quick.jsp" %>
	</div>


	<%@ include file="../include/footer.jsp" %>
	</center>
 </body>
</html>