<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/bootstrap.css" />
<script src="../resources/jquery/jquery-3.6.0.js"></script>
<title>Insert title here</title>
<script>
function deleteRow(idx) {
	if(confirm("정말로 삭제하시겠습니까?")){
		location.href="delete.do?idx="+idx;
	}
}
</script>
</head>
<body>
<!-- <div class="container"> -->

<!-- 	<h2>회원제 방명록 게시판</h2> -->
	
<!-- <div class="media border p-3"> -->
<!--     <img src="../resources/img_avatar3.png" alt="John Doe" class="mr-3 mt-3 rounded-circle" style="width:60px;"> -->
<!--     <div class="media-body"> -->
<!-- 	    <h4>John Doe <small><i>Posted on February 19, 2016</i></small></h4> -->
<!-- 	    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>       -->
<!--     </div> -->
<!-- </div> -->

<div class="container">
	<h3 class="text-center">회원제 방명록 게시판(한줄게시판)</h3>
		
	<!-- 글쓰기 버튼 및 로그인/로그아웃 버튼 -->					<!-- 오른쪽 정렬 -->
	<div class="text-right"> 
		<!-- 
			EL의 내장객체인 sessionScope을 통해 세션영역에
			저장된 속성이 있는지 확인함.
		-->
		<c:choose>
			<c:when test="${not empty sessionScope.siteUserInfo }">
			<!-- 세션영역에 속성이 비어있지 않을때(즉, 있을때) << 로그인 되었을때 -->
				<button class="btn btn-danger"
					onclick="location.href='logout.do';">
					로그아웃
				</button>
			</c:when>
			<c:otherwise>
				<button class="btn btn-info"
					onclick="location.href='login.do';">
					로그인
				</button>
			</c:otherwise>
		</c:choose>
		&nbsp;&nbsp;
		<button class="btn btn-success"
			onclick="location.href='write.do';">
			방명록 쓰기
		</button>
	</div>
	
	
	<div class="text-center">
	<form method="get">
		<select name="searchField">
			<option value="contents">내용</option>
			<option value="name">작성자</option>
		</select>
		<input type="text" name="searchTxt" />
		<input type="submit" value="검색" />
	</form>
	여러 단어를 검색하고 싶을 때는 스페이스로 구분해주세요.
	</div>
	
	
	<!-- 방명록 반복 부분 s -->
	<c:forEach items="${lists }" var="row">		
		<div class="border mt-2 mb-2">
			<div class="media">
				<div class="media-left mr-3">
					<img src="../images/img_avatar3.png" class="media-object" style="width:60px">
				</div>
				<div class="media-body">
					<h4 class="media-heading">작성자:${row.name }(${row.id })</h4>
					<p>${row.contents }</p>
				</div>	  
				<!--  수정,삭제버튼 -->
				<div class="media-right">
					<!-- 작성자 본인에게만 수정/삭제 버튼 보임처리 -->
					<c:if test="${sessionScope.siteUserInfo.id eq row.id }">
						<button class="btn btn-primary" onclick="location.href='modify.do?idx=${row.idx }';">수정</button>
						<!-- 삭제 버튼을 누를 경우 idx값을 JS의 함수로 전달한다. -->
						<button class="btn btn-danger" onclick="javascript:deleteRow(${row.idx});">삭제</button>
					</c:if>
				</div>
			</div>
		</div>
	</c:forEach>
	
	<!-- 방명록 반복 부분 e -->
	<ul class="pagination justify-content-center">
		${pagingImg } 
	</ul>
</div>
	
</body>
</html>