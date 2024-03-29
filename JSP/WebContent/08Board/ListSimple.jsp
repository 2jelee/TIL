<%@page import="model1.board.BoardDTO"%>
<%@page import="model1.board.BoardDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//application 내장객체를 인수로 DAO객체를 생성한다. (DB연결)
BoardDAO dao = new BoardDAO(application);

//파라미터를 저장하기 위해 Map 컬렉션 생성
Map<String, Object> param = new HashMap<String, Object>();

//검색에 대한 파라미터를 받아서 변수에 저장
String searchField = request.getParameter("searchField"); //검색할 필드명
String searchWord = request.getParameter("searchWord"); //검색어

//사용자가 검색을 했다면,
if(searchWord!=null) {
	//검색필드와 검색어를 Map에 추가. (Map 추가 => put)
	param.put("searchField", searchField);
	param.put("searchWord", searchWord);
}
//게시물의 전체 갯수를 카운트하기 위한 메소드 호출
int totalCount = dao.selectCount(param);

/*List 생성 시 코드 추가할 부분*/



//목록에 실제 출력할 레코드를 얻어오기 위한 메소드 호출
List<BoardDTO> boardLists = dao.selectList(param);
//자원 해제
dao.close();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ListSimple.jsp</title>
</head>
<body>
	<h2>목록보기(List)</h2>
	<%@ include file="../common/CommonLink.jsp" %>
	
	<!-- 검색 폼 : 제목과 내용을 통해 검색할 수 있다. -->
	<form method="get"> <!-- get방식으로 -->
	<table border="1" width="90%">
	<tr> 
		<td align="center">
			<select name="searchField">
				<option value="title">제목</option>
				<option value="content">내용</option>
			</select>
			<input type="text" name="searchWord"/>
			<input type="submit" value="검색하기"/>
		</td>
	</tr>
	</table>
	</form>
	
	<!-- 목록 출력을 위한 테이블 -->
	<table border="1" width="90%">
		<tr>
			<th width="10%">번호</th>
			<th width="50%">제목</th>
			<th width="15%">작성자</th>
			<th width="10%">조회수</th>
			<th width="15%">작성일</th>
		</tr>	
<%
if(boardLists.isEmpty()){ //만약 컬렉션에 저장된 데이터가 하나도 없다면, << isEmpty
%>
	<tr>
		<td colspan="5" align="center">
			등록된 게시물이 없습니다.
		</td>
	</tr>
<%
}
else{ //컬렉션에 저장된 데이터가 있다면 해당 내용을 반복하여 출력.
	int vNum = 0; //Virtual(가상) >> 목록의 가상번호로 사용
	int countNum = 0;
	//List 컬렉션에 저장된 갯수만큼 반복하기 위해 확장 for문 사용
	for(BoardDTO dto : boardLists) {
		vNum = totalCount--; //게시물 카운트 수를 통해 가상번호 부여
		//gettor()를 통해 출력한다.
%>
		<tr align="center">
			<td><%=vNum%></td>
			<td align="left">
				<a href="View.jsp?num=<%=dto.getnum()%>"><%=dto.gettitle()%></a>
			</td>
			<td align="center"><%=dto.getid()%></td>
			<td align="center"><%=dto.getvisitcount()%></td>
			<td align="center"><%=dto.getPostdate()%></td>
		</tr>
<%
	}
}
%>	
	</table>
	<table border="1" width="90%">
		<tr align="right">
			<td><button type="button" onclick="location.href='Write.jsp';">
				글쓰기</button></td>
		</tr>
	</table>
</body>
</html>




