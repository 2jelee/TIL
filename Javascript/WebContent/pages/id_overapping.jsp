<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>./pages/id_overapping.jsp</title>
<script type="text/javascript">
function idUse(){
	/*
	팝업창에서 재입력한 아이디를 부모창으로 전달하기 위해
	opener 속성을 사용함.
	팝업창이 열릴 때 부모쪽에서는 readOnly 속성이 부여되어
	사용자는 수정할 수 없게 되지만 JS에서는 값을 수정할 수 있다.
	*/
	opener.documet.registFrm.id.value =
			document.overlapFrm.retype_id.value;
	self.close();
}
</script>
</head>
<body>
	<h2>아이디 중복확인 하기</h2>

	<!-- JSP의 request 내장객체의 getParameter()를 통해 파라미터를 받아옴. -->
	<h3>부모창에서 입력한 아이디 : <%=request.getParameter("id") %></h3>
	
	<h3>아이디가 중복되었을때 재입력한 아이디</h3>
	<form name="overLapFrm">
		<input type="text" name="retype_id" size="20" />
		<input type="button" value="아이디 사용하기" onclick="idUse();" />
	</form>
</body>
</html>