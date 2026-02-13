<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html><head>
<script  src="https://code.jquery.com/jquery-3.2.1.min.js" ></script>
<script type="text/javascript">
	$(function(){
		$('#id').blur(function(){
			$.ajax(
					{
						type: 'post',
						url : 'IdCheckAction.do' ,
						data: { id : $('#id').val() } ,
						dataType : 'xml' ,
						success: function(data) {
							console.log(data);
							var x = $(data).find('id').text();
							console.log(x);
							
							if( x == 'y' ) {
								$('#help_text').html('사용가능 아이디');
							} else {
								$('#help_text').html('<b>사용불가능</b>');
								$('#id').text();
							}
						}
					}		
			);
		});
	});
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Basic</title>
</head>
<body>
	ID 검증하기 :
	<input type="text"  name="id" id="id" >
	<span id="help_text"></span>
</body>
</html>