<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/global_head.jsp" %>
<%@ include file="../member/isLogin.jsp" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판-쓰기기능</title>
<script src="../common/jquery/jquery-3.6.0.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	//옵션 select를 선택했을 때 change이벤트 발생
	$('#mal').change(function() {
		//alert("옵션선택함");
		$.ajax({
			url : "../space/07GoodsSelect1.jsp",
			type : "get", //전송방식
			data : { //파라미터		
				// select에서 선택한 항목을 파라미터로 전달
				goodsOptionName : $("#mal").val()
			},
			dataType : "html", //콜백데이터의 타입
			contentType : "text/html;charset:utf-8",
			success : function(d) {
				console.log("성공"+d);
				
				//hidden으로 생성된 기본 가격을 가져와서 숫자(정수)로 변경함.
				var totalPrice = parseInt($('#totalPrice').val());
				//선택한 옵션의 value를 가져옴
				var goodsOption = $('#mal').val();
				
// 				//옵션에 따른 금액을 판단하여 합산
// 				if(goodsOption=='op01') totalPrice += 5000;
// 				else if(goodsOption=='op02') totalPrice += 7000;
// 				else if(goodsOption=='op03') totalPrice += 10000;
				
// 				//계산된 금액을 hidden 박스에 입력하고,
// 				$('#totalPrice').val(totalPrice);
// 				//화면에 출력.
// 				$('#priceDisplay').html("총 상품금액:"+totalPrice);
				
// 				//옵션을 처음 선택했다면 기존 문자열을 지우고 옵션을 추가함.
// 				if($('#goodsList').html()=="여기에 선택한 옵션이 리스팅 됨"){
// 					$('#goodsList').empty();
// 				}
// 				//옵션상품을 추가함.
// 				$('#goodsList').append(d);
// 			},
// 			error : function(e){
// 				alert("실패"+e.status);
			}
		});
	});	
});



//쓰기폼에 빈값이 있는지를 확인해주는 함수
function formValidate(f){
	if(f.mal.value==""){
		alert("말머리를 선택하세요.");
		f.mal.focus();
		return false;
	}
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

<!-- <form enctype="multipart/form-data"> -->
<form name="writeFrm" method="post" action="../space/sub03_writeProcess.jsp"
	onsubmit="return formValidate(this);">
	
<table class="table table-bordered">
<colgroup>
	<col width="20%"/>
	<col width="*"/>
</colgroup>
<tbody>


	<tr>
		<th class="text-center" style="vertical-align:middle;">
			<select name="mal">
				<option selected="" value="">※말머리 선택※</option>
				<option value="자유" >자유</option>
				<option value="Q&A" >Q&A</option>
				<option value="운동플랜" >운동플랜</option>
			</select>
		</th>
	</tr>
	<tr>
		<th class="text-center" 
			style="vertical-align:middle;">제목</th>
		<td>
			<input type="text" class="form-control" name="title"/> 
		</td>
	</tr>
	<tr>
		<th class="text-center" 
			style="vertical-align:middle;">내용</th>
		<td>
			<textarea rows="10" class="form-control" name="content"></textarea>
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
	<button type="submit" class="btn btn-danger">전송하기</button>
	<button type="reset" class="btn">Reset</button>
	<button type="button" class="btn btn-warning" 
		onclick="location.href='../space/sub03.jsp';">리스트보기</button>
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