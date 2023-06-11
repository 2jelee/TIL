<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<script type="text/javascript">
/*
Geolocation : 위치정보 서비스로써 브라우저가 현재 위도와 경도를 JS코드에게 공급하는 서비스

	getCurrentPosition() : 현재 위치 얻기
	사용법 : getCurrentPosition(
				현재 위치가 파악되었을 때 호출되는 콜백메소드,
				위치파악 중 오류발생 시 호출되는 콜백 메소드,
				옵션(위치를 파악할 최대 허용시간, 대기시간, 위치의 정확도)
			);
 */
var span;
window.onload = function() {
	span = document.getElementById("result");
	
	if(navigator.geolocation){
		span.innerHTML = "GeoLocation API를 지원합니다";
		
		/*
		옵션 항목은 3개의 값을 가진 전역객체를 사용한다.
		enableHightAccurcy : 정확도를 결정하는 Boolean 타입의 값
		timeout : 위치값을 장치로 받을 때까지의 대기시간(1000분의 1초)
		maximumAge : 캐시된 위치값을 반환받을 수 있는 대기시간.
					 캐시값을 사용하지 않고 항상 현재 위치값을 수집함.
		*/
		
		var options = {
			enableHightAccurcy:true,
			timeout:5000,
			maximumAge:3000
		};
		navigator.geolocation.getCurrentPosition(showPosition,showError,options);
	}
	else{
		span.innerHTML = "이 브라우저는 Geolocation API를 지원하지 않습니다.";
	}
}
//위치를 찾았을 때의 콜백 메소드
var showPosition = function(position) {
	//콜백된 데이터를 통해 위도, 경도값을 얻어옴.
	var latitude = position.coords.latitude;
	var longitude = position.coords.longitude;
	span.innerHTML = "위도 : "+latitude+", 경도 :"+longitude;
	
	document.getElementById("lat").value = latitude;
	document.getElementById("lng").value = longitude;		
}
//위치를 찾지 못했을 때의 콜백메소드
var showError = function(error) {
	switch (error.code) {
	case error.UNKNOWN_ERROR:
		sapn.innerHTML = "알 수 없는 오류발생"; break;
	case error.PERMISSION_DENIED:
		sapn.innerHTML = "권한이 없습니다."; break;
	case error.POSITION_UNAVAILABLE:
		sapn.innerHTML = "위치 확인불가"; break;
	case error.TIMEOUT:
		sapn.innerHTML = "시간초과"; break;
	}
}
</script>
</head>
<body>
<div class="container">
	<h2>GeoLocation - 현재 위치의 위도, 경도 알아내기</h2>
	<fieldset>
		<legend>현재위치 - 위도, 경도</legend>
		<span id="result" style="color:red; font-size:1.5em; font-weight: bold;"></span>
	</fieldset>
	
	위도 : <input type="text" id="lat" />
	경도 : <input type="text" id="lng" />
</div>
</body>
</html>