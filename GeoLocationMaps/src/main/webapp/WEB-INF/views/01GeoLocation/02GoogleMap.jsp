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

<style>
#map{
	width:800px; height: 600px;
}
</style>
<script>
function initMap() {
	var uluru = {lat:37.480316,lng:126.882771};
	var map = new goole.maps.Map(document.getElementById('map'),{
		zoom: 17,
		center: uluru
	});
	var marker = new goole.maps.Marker({
		position: uluru,
		map: map
	});
}
window.onload = function () {
	initMap();
}
</script>
</head>
<body>
<div class="container">
	<h2>Google Map 띄워보기</h2>
	<div id="map">
	<script async defer
	src="https://maps.googleapis.com/maps/api/js?key=${apiKey }"></script>
	</div>
</div>
</body>
</html>