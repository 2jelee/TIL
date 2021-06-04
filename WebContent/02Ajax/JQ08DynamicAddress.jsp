<%@page import="java.util.ArrayList"%>
<%@page import="controller.ZipcodeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
//DAO를 통해 DB연결
ZipcodeDAO dao = new ZipcodeDAO();
//시/도를 얻어오기 위해 쿼리 실행
ArrayList<String> sidoList = dao.getSido();
//JSTL을 사용하기 위해 페이지 영역에 저장
pageContext.setAttribute("sidoList", sidoList);
%>
<!DOCTYPE html>  		<!-- 디자인 확인rerererere -->
<html>
<head>
<meta charset="UTF-8">
<title>JQ08DynamicAddress.jsp</title>
<script src="../common/jquery/jquery-3.6.0.js"></script>
<script type="text/javascript">
$(document).ready(function () {
	//시도를 선택했을 때 Change이벤트가 발생됨.
	$('#sido').change(function() {
// 		alert($('#sido').val()+" 선택됨");
		$.ajax({
			url : "./common/08GugunOption.jsp",
			type : "get",
			contentType : "text/html;charset:utf-8;",
			data :{	//선택한 시/도를 파라미터로 전달함.
				sido : $('#sido option:selected').val()
			},
			dataType : "json",
			success:function(d){
				console.log("콜백데이터", d);
				
				var optionStr = "";
				optionStr += "<option value=''>";
				optionStr += "-구군을 선택하세요.-";
				optionStr += "</option>";
				
				/*
				콜백데이터는 JSON배열로 전달될 것이므로
				항목의 갯수만큼 반복하여 <option>태그를 생성함.
				*/
				$.each(d, function(index, data) {
					optionStr += '<option value="'+data+'">';
					optionStr += data;
					optionStr += '</option>';
				});
				//구/군에 해당하는 <select>태그에 삽입함.
				$('#gugun').html(optionStr);
			},
			error:function(e){
				alert("오류발생:"+e.status+":"+e.statusText);
			}
		});
	});
})
</script>
</head>
<body>
<div class="container">
	<div class="row">
		<h2>우편번호DB를 이용한 시도/구군 동적셀렉트 구현</h2>
	</div>
	<form id="zipFrm">
	<div class="row">		
		<div class="col-4">
			시/도:  <!-- 페이지 로드 시, 시/도는 즉시 삽입됨. -->
			<select id="sido" class="form-control">
				<option value="">-시/도선택하삼-</option>
				<!-- page영역에 저장된 데이터를 forEach문으로 반복 출력 -->
				<c:forEach items="${sidoList }" var="sidoStr">
					<option value="${sidoStr }">${sidoStr }</option>
				</c:forEach>
			</select>
		</div>
		<div class="col-8">
			구/군: <!-- 시/도를 선택했을 때 쿼리문을 통해 구/군을 가져와서 삽입함. -->
			<select id="gugun" class="form-control">
				<option value="">-구/군선택하삼-</option>
			</select>
		</div>		
	</div>
	</form>
</div>
</body>
</html>