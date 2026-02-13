<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AJAX </title>
<script  src="https://code.jquery.com/jquery-3.2.1.min.js" ></script>
<script type="text/javascript">
	$(function(){
			var string = ["abc", "def"];
			var vparam = "test";
			$('#btn').click(function(){
				$.ajax(
						{
							url: "<%=request.getContextPath()%>/ArrayServlet.do",
							type: "get",
							data : {"string" : string },
							success : function(data) {
								var as = eval(data);  
								alert("data : " + as[0] + "/ " + as[1]);
							},
							error : function(msg, error) {
								alert(error);
							}
						}
				);
			});
	});
</script>
</head>
<body>
<%= request.getContextPath() %>/ArrayServlet.do
<input type="button"  id="btn" value="자바스크립트 배열 Ajax 전송"> 
<div id="message"></div>
</body>
</html>




