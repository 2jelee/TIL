<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- tiles에서 제공하는 taglib 지시어가 필요 -->
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head> 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="../resources/css/common.css" /> 
<title>tiles 레이아웃</title>
</head>
<body>
<!-- 
	tiles-define.xml에서 설정한 템플릿 파일들을
	해당 파일에서 레이아웃으로 배치한다.
 -->
<div class="container">
	<div class='wrap'>
		<tiles:insertAttribute name="top" />
		<div class="content">
			<tiles:insertAttribute name="left" />
			<div class="page_content">
				<tiles:insertAttribute name="body" />
			</div>
		</div>
		<tiles:insertAttribute name="bottom" />
	</div>
</div>

</body>
</html>