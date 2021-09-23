<%@page import="sub02_shortboard.ShortBoardDTO"%>
<%@page import="sub02_shortboard.ShortBoardDAO"%>
<%@page import="utils.BoardPage"%>
<%@page import="java.util.List"%>
<%@page import="common.BoardConfig"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

<%@ include file="../member/isLogin.jsp" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/global_head.jsp" %>
<% 
//application내장객체를 인수로 DAO객체를 생성한다.(DB연결)
ShortBoardDAO dao = new ShortBoardDAO(application);

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
int pageNum = 1;//목록 첫 진입시에는 무조건 1페이지로 지정
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
List<ShortBoardDTO> boardLists = dao.selectListPage(param);
//자원해제
dao.close();
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한마디 공간(게시판)</title>
<script type="text/javascript">
//쓰기폼에 빈값이 있는지를 확인해주는 함수
function formValidate(f){
// 	if(f.title.value==""){
// 		alert("제목을 입력하세요.");
// 		f.title.focus();
// 		return false;
// 	}
	if(f.content.value==""){
		alert("내용을 입력하세요.");
		f.content.focus();
		return false;
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
				<img src="../images/space/sub02_title.gif" alt="한마디공간" class="con_title" />
				<p class="location"><img src="../images/center/house.gif" />&nbsp;&nbsp;열린공간&nbsp;>&nbsp;한마디공간<p>
			</div>
		<div>
		<h2>오늘의 목표 및 각오를 적는 공간입니다.  (이미지삽입)</h2>
		
		<div class="row text-right" style="margin-bottom:20px;
				padding-right:50px;">
				
				
	</div>
		
		
		
		
	<div class="row">
		<!-- 게시판리스트부분 -->
		<table class="table table-bordered table-hover">
		<colgroup>
			<col width="80px"/>
			<col width="120px"/>
			<col width="120px"/>
			<col width="*"/>
<!-- 			<col width="80px"/> -->
<!-- 			<col width="50px"/> -->
		</colgroup>
	
	<thead>
	<tr class="success">
		<th class="text-center">번호</th>
		<th class="text-center">작성자</th>
		<th class="text-center">작성일</th>
		<th class="text-left"><center>내용</center></th>
<!-- 		<th class="text-center">조회수</th> -->
<!-- 		<th class="text-center">첨부</th> -->
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
				등록된 한마디가 없습니다.
			</td>
		</tr>
<%
}
else{
	int vNum = 0;//목록의 가상번호로 사용
	int countNum = 0;	
	for(ShortBoardDTO dto : boardLists)
	{
		vNum = totalCount - (((pageNum-1) * pageSize) + countNum++);
%>
		<tr align="center">
			<td><%=vNum%></td>
			<td align="center"><%=dto.getId()%></td>
			<td align="center"><%=dto.getPostdate()%></td>
			<td align="left"><%=dto.getContent()%></td>
		</tr>
<%
	}
}
%>
	</table>
	
</div>
<div class="row text-right" style="padding-right:50px;">










<!-- <form enctype="multipart/form-data"> -->
<form name="writeFrm" method="post" action="../space/sub02_writeProcess.jsp"
	onsubmit="return formValidate(this);">
	
<table class="table table-bordered">
<colgroup>
	<col width="20%"/>
	<col width="*"/>
</colgroup>
<tbody>
<!-- 	<tr> -->
<!-- 		<th class="text-center"  -->
<!-- 			style="vertical-align:middle;">작성자</th> -->
<!-- 		<td> -->
<!-- 			<input type="text" class="form-control"  -->
<!-- 				style="width:100px;" /> -->
<!-- 		</td> -->
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<th class="text-center"  -->
<!-- 			style="vertical-align:middle;">이메일</th> -->
<!-- 		<td> -->
<!-- 			<input type="text" class="form-control"  -->
<!-- 				style="width:400px;" /> -->
<!-- 		</td> -->
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<th class="text-center"  -->
<!-- 			style="vertical-align:middle;">내용</th> -->
<!-- 		<td> -->
<!-- 			<input type="text" class="form-control" name="content"/>  -->
<!-- 		</td> -->
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<th class="text-center"  -->
<!-- 			style="vertical-align:middle;">게시물 패스워드</th> -->
<!-- 		<td> -->
<!-- 			<input type="text" class="form-control"  name="bpass" -->
<!-- 				style="width:200px;" /> -->
<!-- 		</td> -->
<!-- 	</tr> -->
	<tr>
		<th class="text-center" 
			style="vertical-align:middle;">오늘의 목표/각오</th>
		<td>
			<textarea rows="10" class="form-control" name="content"></textarea>
		</td>
	</tr>
<!-- 	<tr> -->
<!-- 		<th class="text-center"  -->
<!-- 			style="vertical-align:middle;">첨부파일</th> -->
<!-- 		<td> -->
<!-- 			<input type="file" class="form-control" name="ofile"/> -->
<!-- 		</td> -->
<!-- 	</tr> -->
</form> 
</tbody>
</table>
<div class="row text-center" style="">
	<!-- 각종 버튼 부분 -->
	
	<button type="submit" class="btn btn-danger">전송하기</button>
	<button type="reset" class="btn">Reset</button>
<!-- 	<button type="button" class="btn btn-warning"  -->
<!-- 		onclick="location.href='../space/sub02.jsp';">리스트보기</button> -->
</div>











	<!-- 각종 버튼 부분 -->
	<!-- <button type="reset" class="btn">Reset</button> -->
		
<!-- 	<button type="button" class="btn btn-default"  -->
<!-- 		onclick="location.href='sub02.jsp';">글쓰기</button> -->
				
	<!-- <button type="button" class="btn btn-primary">수정하기</button>
	<button type="button" class="btn btn-success">삭제하기</button>
	<button type="button" class="btn btn-info">답글쓰기</button>
	<button type="button" class="btn btn-warning">리스트보기</button>
	<button type="submit" class="btn btn-danger">전송하기</button> -->
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