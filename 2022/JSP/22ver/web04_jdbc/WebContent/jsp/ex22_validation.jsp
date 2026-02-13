<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jQuery 유효성 검사</title>
<script  src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
		$(document).ready( function(){
			$("#btnSubmit").click( function(){
					if( $("#uid").val() == "" ) {
						alert('id 는 반드시 입력해 주세요');
						$("#uid").focus();
						return false;
					} else if( $("#pwd").val() == "" ) {
						alert('pwd 꼭 입력해~~~');
						$("#pwd").focus();
						return false;
					} else {
						$('#frm').submit();
					}
			});
		});
	
</script>
</head>
<body>
	<form action=""  method="get"  id="frm">
		이름 : <input type="text" name="uid"  id="uid" size="10">
		암호 : <input type="password" name="pwd"  id="pwd"  size="10" ><br><br>
		<input type="submit" value="전송"  id="btnSubmit"> &nbsp;&nbsp;
		<input type="reset" value="취소"  >
	</form>
</body>
</html>