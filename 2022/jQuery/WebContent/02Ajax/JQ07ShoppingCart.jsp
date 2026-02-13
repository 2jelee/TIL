<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JQ07ShoppingCart.jsp</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="../common/jquery/jquery-3.6.0.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	//옵션 select를 선택했을 때 change이벤트 발생
	$('#goodsOptionId1').change(function() {
		//alert("옵션선택함");
		$.ajax({
			url : "./common/07GoodsSelect1.jsp",
			type : "get", //전송방식
			data : { //파라미터		
				// select에서 선택한 항목을 파라미터로 전달
				goodsOptionName : $("#goodsOptionId1").val()
			},
			dataType : "html", //콜백데이터의 타입
			contentType : "text/html;charset:utf-8",
			success : function(d) {
				//console.log("성공"+d);
				
				//hidden으로 생성된 기본 가격을 가져와서 숫자(정수)로 변경함.
				var totalPrice = parseInt($('#totalPrice').val());
				//선택한 옵션의 value를 가져옴
				var goodsOption = $('#goodsOptionId1').val();
				
				//옵션에 따른 금액을 판단하여 합산
				if(goodsOption=='op01') totalPrice += 5000;
				else if(goodsOption=='op02') totalPrice += 7000;
				else if(goodsOption=='op03') totalPrice += 10000;
				
				//계산된 금액을 hidden 박스에 입력하고,
				$('#totalPrice').val(totalPrice);
				//화면에 출력.
				$('#priceDisplay').html("총 상품금액:"+totalPrice);
				
				//옵션을 처음 선택했다면 기존 문자열을 지우고 옵션을 추가함.
				if($('#goodsList').html()=="여기에 선택한 옵션이 리스팅 됨"){
					$('#goodsList').empty();
				}
				//옵션상품을 추가함.
				$('#goodsList').append(d);
			},
			error : function(e){
				alert("실패"+e.status);
			}
		});
	});	
});
</script>
</head>
<body>
<div class="container">
	<div class="row">
		<h2>장바구니 구현하기</h2>
	</div>
	<div class="row">
		<div class="col-md-6">
			<!-- 상품이미지 -->
			<img src="../images/amazon.png" 
				class="img-thumbnail" />
		</div>
		<div class="col-md-6">
			<!-- 상품가격과 옵션 -->
			<form id="goodsFrm">
			
			<!-- 상품가격+옵션가격 -->
			<input type="hid-den" id="totalPrice" 
				value="70000" 
				style="background-color:#bbbbbb;
					color:red;"/>				
			
			<table class="table table-bordered">
			<colgroup>
				<col width="30%"/>
				<col width="*"/>
			</colgroup>
			<tr>
				<td>상품명</td>
				<td>3 in 1 Type-C HDMI 케이블</td>
			</tr>
			<tr>
				<td>상품가격</td>
				<td><del>100,000원</del> -> 70,000원</td>
			</tr>
			<tr>
				<td>옵션선택</td>
				<td>
					<select id="goodsOptionId1">
						<option value="">선택하쇼</option>
						<option value="op01">옵션1(+5000)</option>
						<option value="op02">옵션2(+7000)</option>
						<option value="op03">옵션3(+10,000)</option>
					</select>
				</td>
			</tr>			
			</table>
			</form>			
			<div class="row" id="goodsList">여기에 선택한 옵션이 리스팅 됨</div>			
			<div class="row" id="priceDisplay" 
				style="font-size:1.5em; color:red;">
				총상품금액 : 70,000원
			</div>
		</div>
	</div>	
</div>

</body>
</html>