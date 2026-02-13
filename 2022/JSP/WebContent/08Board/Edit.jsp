<%@page import="model1.board.BoardDTO"%>
<%@page import="model1.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./isLogin.jsp" %><!-- 로그인 확인 -->
<%
//파라미터 받기
String num = request.getParameter("num");


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
BoardDAO dao = new BoardDAO(application);
BoardDTO dto = dao.selectView(num);

//작성자 본인만 수정하기 페이지에 들어올 수 있다.
String session_id = session.getAttribute("USER_ID").toString();
// String session_id = (String)session.getAttribute("USER_ID"); //위와 같은 코드 (이는 강제적 형변환)
if(!session_id.equals(dto.getid())){
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
<title>회원제 게시판</title>
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
<h2>회원제 게시판 - 수정하기(Edit)</h2>
<form name="writeFrm" method="post" action="EditProcess.jsp"
	onsubmit="return checkValidate(this);">

<!-- 
	특정 게시물 하나를 수정해야 하므로 수정폼을 전송할 때
	반드시 게시물의 일련번호도 전달되어야 한다.
	따라서 화면상에서는 보이지 않는 hidden 입력상자를 사용함.
 -->
<input type="hidden" name="num" value="<%=dto.getnum() %>" />
<table border="1" width="90%"></table>
<!--hidden : 화면에는 출력되진 않지만 서버에는 전송되는
	hidden 폼이 키포인트! -->
<!-- 
	게시판 테이블인 board의 컬럼명과 input태그의 name 속성값은
	똑같이 맞추어주는 것이 개발에 유리함.
 -->
<table border="1" width="90%">
	<tr>
		<td>제목</td>
		<td>
			<input type="text" name="title" style="width:90%;"
				value="<%=dto.gettitle() %>" />
		</td>
	</tr>
	<tr>
		<td>내용</td>
		<td>
			<textarea name="content" style="width:90%; height:100px;"
				><%=dto.getcontent() %></textarea>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<button type="submit">작성완료</button>
		<button type="submit">RESET</button>
		<button type="button" onclick="location.href='List.jsp?<%=queryStr %>';">리스트 바로가기</button>
		<!-- searchField=title&searchWord=7번째 -->
		</td>
	</tr>
</table>
</form>
</body>
</html>