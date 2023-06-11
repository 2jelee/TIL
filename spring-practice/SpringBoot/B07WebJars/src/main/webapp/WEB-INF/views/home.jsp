<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--  
프로젝트 > Projects and External Dependencies 항목에서 필요한 라이브러리를 
찾은후 경로명을 복사한다. 아래와 같이 link 혹은 script 태그를 통해 삽입한다. 
-->
<link rel="stylesheet" href="/webjars/bootstrap/4.6.0/css/bootstrap.min.css">
<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.6.0/js/bootstrap.min.js"></script>
</head>

 
<body>
<div class="container">
	<h2>WebJars 사용하기</h2>
	
	<h3>부트스트랩 적용</h3>	
	<div class="row">
		<button type="button" class="btn">Basic</button>
		<button type="button" class="btn btn-primary">Primary</button>
		<button type="button" class="btn btn-secondary">Secondary</button>
		<button type="button" class="btn btn-success">Success</button>
		<button type="button" class="btn btn-info">Info</button>
		<button type="button" class="btn btn-warning">Warning</button>
		<button type="button" class="btn btn-danger">Danger</button>
		<button type="button" class="btn btn-dark">Dark</button>
		<button type="button" class="btn btn-light">Light</button>
		<button type="button" class="btn btn-link">Link</button>
	</div>
	
	<h3>jQuery 적용</h3>
	<script>
	$(function(){
		$('#jBtn').click(function(){
			alert('버튼은 눌러졌는가?');
		});		
	});
	</script>
	<input type="button" value="jquery확인" id="jBtn" class="btn btn-warning" />
</div>
</body>
</html>
