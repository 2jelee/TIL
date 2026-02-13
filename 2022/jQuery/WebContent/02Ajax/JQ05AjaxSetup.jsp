<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JQ05AjaxSetup.jsp</title>
<script src="../common/jquery/jquery-3.6.0.js"></script>
<script>
/*
	$.ajaxSetup()
		: 동일하게 반복되는 $.ajax()의 인자를 설정하여
		반복되는 인자의 사용을 생략할 수 있다.
		type, dataType등 기본적으로 사용되는 인자들을 묶어주면 편리함.
 */
$(function() {
	//문서가 로드되면 요청URL, 콜백데이터 타입을 설정함.
	$.ajaxSetup({
		url : "./common/05JSONData.json",
		dataType : "json"
	});
	
	//앞에서 정의한 속성을 제외하고 메소드 선언
	$('#btn').click(function() {
		$.ajax({
			/*
			콜백 데이터는 JSON배열이므로 each()를 통해
			인자의 갯수만큼 반복함.
			이때 각 반복 시 JSON객체를 파싱하게 됨.
			파싱할 때는 .(점)과 [](대괄호) 두 가지 형태를 사용할 수 O.
			*/
			success : function(responseData) {
				/*
				each() 메소드 사용 시 파라미터는 아래 2가지를 사용할 수 있다.
					index : 반복 시 사용할 인덱스(0부터 시작)
					value : 해당 루프에서 반환되는 엘리먼트(혹은 데이터)
				*/
				$.each(responseData, function(index, value) {
					var htmlStr = "<tr>";
					htmlStr += " <td>"+(index+1)+"</td>";
					htmlStr += " <td>"+value.name+"</td>";
					htmlStr += " <td>"+value["age"]+"</td>";
					htmlStr += " <td>"+value["주소"]+"</td>";
					htmlStr += " 	</tr>";
					
					//기존 내용의 뒷부분에 추가
					$('#tbl1').append(htmlStr);
				});
			},
			error:errFunc
		});
	});
});
/*
	요청실패 시 호출되는 콜백메소드로 콜백데이터를 가지고 있으며
	아래와 같이 매개변수를 통해 전달받을 수 있다.
*/
function errFunc(errData) {
	alert("실패:"+errData.status+":"+errData.statusText);
}
</script>
</head>
<body>
<div class="container">
	<h2>$.ajaxSetup() 메소드 사용하기</h2>
	
	<table class="table table-bordered" id="tbl1">
		<tr>
			<td>NO</td>
			<td>이름</td>
			<td>나이</td>
			<td>출신지역</td>
		</tr>
	</table>
	
	<button id="btn">JSON데이터 가져오기</button>	
</div>

</body>
</html>