<%@page import="utils.JSFunction"%>
<%@page import="sub03_freeboard.FreeBoardDTO"%>
<%@page import="sub03_freeboard.FreeBoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/global_head.jsp" %>

<%@ include file="../member/isLogin.jsp" %><!-- 로그인 확인 -->
<%
//파라미터 받기
String num = request.getParameter("num");
// String title = request.getParameter("title");
// String content = request.getParameter("content");


/* 과제로 추가 */
String searchField = request.getParameter("searchField"); //검색필드 << 상세보기 후 리스트 고정을 위해 추가
String searchWord = request.getParameter("searchWord"); //검색어 << 상세보기 후 리스트 고정을 위해 추가

String queryStr = "";

if(searchWord!=null) {
	//검색 파라미터 추가하기	 << 페이지 블럭에서 이동 시 검색한 내용을 고정시켜 놓을 용도로 사용할 queryStr
	queryStr = "searchField="+searchField+"&searchWord="+searchWord; //쿼리스트링 구분 시 &를 사용
}
/* 과제로 추가					~~여기까지 */


//DAO객체 생성 후 게시물 조회
FreeBoardDAO dao = new FreeBoardDAO(application);
FreeBoardDTO dto = dao.selectView(num);

// //작성자 본인만 수정하기 페이지에 들어올 수 있다.
String session_id = session.getAttribute("USER_ID").toString();
// String session_id = (String)session.getAttribute("USER_ID"); //위와 같은 코드 (이는 강제적 형변환)
if(!session_id.equals(dto.getId())){
	//작성자가 아니라면 경고창(alert)을 띄우고 뒤(back)로 이동한다.
	JSFunction.alertBack("작성자 본인만 수정할 수 있습니다.", out);
	return;
}
dao.close();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판-수정기능</title>
<script type="text/javascript">
//쓰기폼에 빈값이 있는지를 확인해주는 함수
function checkValidate(f){
	if(f.title.value==""){
		alert("제목을 입력하세요.");
		f.title.focus();
		return false;
	}
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
		<img src="../images/space/sub03_title.gif" alt="공지사항" class="con_title" />
		<p class="location"><img src="../images/center/house.gif" />&nbsp;&nbsp;열린공간&nbsp;>&nbsp;자유게시판<p>
	</div>
<div>


<form name="writeFrm" method="post" action="sub03_editProcess.jsp"
	onsubmit="return checkValidate(this);">

<!-- 
	특정 게시물 하나를 수정해야 하므로 수정폼을 전송할 때
	반드시 게시물의 일련번호도 전달되어야 한다.
	따라서 화면상에서는 보이지 않는 hidden 입력상자를 사용함.
 -->
<input type="hidden" name="num" value="<%=dto.getNum() %>" />
<table border="1" width="90%"></table>

<table class="table table-bordered">
<colgroup>
	<col width="20%"/>
	<col width="*"/>
</colgroup>
<tbody>


<tr>
<!-- 	<th class="text-center" style="vertical-align:middle;"> -->
<!-- 		<select name="mal"> -->
<!-- 			<option selected="" value="">※말머리 선택※</option> -->
<!-- 			<option value="자유" >자유</option> -->
<!-- 			<option value="Q&A" >Q&A</option> -->
<!-- 			<option value="운동플랜" >운동플랜</option> -->
<!-- 		</select> -->
<!-- 	</th> -->
<!-- </tr> -->
<!-- <tr> -->
	<th class="text-center" 
		style="vertical-align:middle;">제목</th>
	<td>
		<input type="text" class="form-control" name="title"
			value="<%=dto.getTitle() %>"/> 
	</td>
</tr>
<tr>
	<th class="text-center" 
		style="vertical-align:middle;">내용</th>
	<td>
		<textarea rows="10" class="form-control" name="content"><%=dto.getContent() %></textarea>
	</td>
</tr>
<tr>
	<th class="text-center" 
		style="vertical-align:middle;">첨부파일</th>
	<td>
		<input type="file" class="form-control" name="ofile"/>
	</td>
</tr>
</form> 
</tbody>
</table>
<div class="row text-center" style="">

	<!-- 각종 버튼 부분 -->
	<button type="submit" class="btn btn-danger">수정완료</button>
<!-- 	<button type="reset" class="btn">Reset</button> -->
	<button type="button" class="btn btn-warning" 
		onclick="location.href='../space/sub03.jsp';">리스트보기</button>
</div>












<!-- <!--  -->
<!-- 	특정 게시물 하나를 수정해야 하므로 수정폼을 전송할 때 -->
<!-- 	반드시 게시물의 일련번호도 전달되어야 한다. -->
<!-- 	따라서 화면상에서는 보이지 않는 hidden 입력상자를 사용함. -->
<!--  --> 
<%-- <input type="hidden" name="num" value="<%=dto.getNum() %>" /> --%>
<!-- <table border="1" width="90%"></table> -->
<!-- <!--hidden : 화면에는 출력되진 않지만 서버에는 전송되는 -->
<!-- 	hidden 폼이 키포인트! -->
<!-- <!--  -->
<!-- 	게시판 테이블인 board의 컬럼명과 input태그의 name 속성값은 -->
<!-- 	똑같이 맞추어주는 것이 개발에 유리함. -->
<!--  --> 
<!-- <table border="1" width="90%"> -->
<!-- 	<tr> -->
<!-- 		<td>제목</td> -->
<!-- 		<td> -->
<!-- 			<input type="text" name="title" style="width:90%;" -->
<%-- 				value="<%=dto.getTitle() %>" /> --%>
<!-- 		</td> -->
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>내용</td> -->
<!-- 		<td> -->
<!-- 			<textarea name="content" style="width:90%; height:100px;" -->
<%-- 				><%=dto.getContent() %></textarea> --%>
<!-- 		</td> -->
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td colspan="2" align="center"> -->
<!-- 		<button type="submit">작성완료</button> -->
<!-- 		<button type="submit">RESET</button> -->
<%-- 		<button type="button" onclick="location.href='sub03.jsp?<%=queryStr %>';">리스트 바로가기</button> --%>
<!-- 		<!-- searchField=title&searchWord=7번째 --> -->
<!-- 		</td> -->
<!-- 	</tr> -->
</table>
</form>
</body>
</html>