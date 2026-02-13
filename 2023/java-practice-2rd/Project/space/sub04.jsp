<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- JSTL 사용을 위한 taglib 지시어 추가 -->    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/global_head.jsp" %>


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
					<img src="../images/space/sub04_title.gif" alt="정보자료실" class="con_title" />
					<p class="location"><img src="../images/center/house.gif" />&nbsp;&nbsp;열린공간&nbsp;>&nbsp;사진게시판<p>
				</div>
			</div>
			
			
			
			
			
			
			
			
			<form method="get">
			<table border="0" width="90%">
			<tr> 
<!-- 				검색부분 -->
				<td align="right">
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
			
			<table border="1" width="80%">
				<tr>
<!-- 					<th width="10%">번호</th> -->
<!-- 					<th width="*">제목</th> -->
<!-- 					<th width="15%">작성자</th> -->
<!-- 					<th width="10%">조회수</th> -->
<!-- 					<th width="15%">작성일</th> -->
<!-- 					<th width="8%">첨부</th> -->
				</tr>
			
			
			
<!-- 			<!-- 게시물 출력부분을 JSTL로 변경함  -->
		<c:choose>
			<c:when test="${empty boardLists }">
			<!-- ㄴ 등록된 게시물이 없(empty)을때 -->
				<tr>
					<td colspan="6" align="center">
						등록된 사진 게시물이 없습니다.
					</td>
				</tr>
			</c:when>
			<c:otherwise>
<!-- 			게시물이 있는 경우, 확장 for문 형태의 forEach태그 사용함 -->
			<c:forEach items="${boardLists }" var="row" varStatus="loop">
			<tr align="center">
				<td><!-- 가상번호 -->
					${map.totalCount - (((map.pageNum-1) * map.pageSize) 
						+ loop.index)}   
				</td>
				<ul class="main_photo_list">
					<li>
						<dl>
							<dt><img src="../images/g_img.gif" />(사진파일)${row.ofile }</a></dt>
							<dd>제목 : ${row.title }</a></dd>
							<dd>아이디 : ${row.id }</a></dd>
							<dd>조회수 : ${row.visitCount }</a></dd>
							<dd>${row.postdate }</a></dd>
						</dl>
					</li>
				</ul>
				</tr>
				</c:forEach>
				</c:otherwise>
				</c:choose>
		</table>
		
<!-- 			각종 버튼 부분 -->
<!-- 	<button type="reset" class="btn">Reset</button> -->
		
<!-- 			<button type="button" class="btn btn-default"  -->
<!-- 				onclick="location.href='../gallery/write.do';">글쓰기</button> -->
			
			
			
			
			

		<%@ include file="../include/quick.jsp" %>
	</div>
	

	<%@ include file="../include/footer.jsp" %>
	</center>
 </body>
</html>
