<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
//폼값으로 한글이 전송되는 경우, 깨짐 방지처리
// web.xml에 필터설정을 한 경우에는 기술하지 않아도 O
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FormResult.jsp</title> <!-- 실행 시 , FormAction에서 실행 -->
</head>
<body>
	<h2>파라미터 값 받기</h2> 
	<h3>JSP(자바코드)로 받기</h3>
	<ul>
		<li>
			이름 : <%=request.getParameter("name") %>
		</li>
		<li>
			성별 : <%=request.getParameter("gender") %>
		</li>
		
		<li>
			관심사항 :
			<%
			/*
			체크박스의 경우, 2개 이상의 값이 전송될 수 있으므로
			String타입의 '배열'로 폼값을 받아서 처리
			
			*ex) inters에 3개 있다면 for문에서 3번 반복 (?)
			*/
				String[] inters = request.getParameterValues("inter");
				for(String s : inters) {
					out.println(s + " ");
				}
			%>
		</li>
		<li>
			학력 : <%=request.getParameter("grade") %>
		</li>
		
		<%--
		EL로 폼값을 받을 때는 EL내장객체를 사용함.
			text, radio와 같은 폼값 => ${param.폼이름}
			checkbox와 같은 다중 폼값 => ${paramValues.폼이름} 	<< html주석<!-- 처리했다해도 EL태그는 인식하므로 jsp주석인 <%--로 바꿨음.
			또한, 쿼리 스트링으로 전달되는 파라미터도 동일하게 받을 수 있다.
			웹URL?nowPage=10 => ${param.nowPage}
			ㄴ 웹URL?nowPage=10 >> get방식(전송방법 중 하나)
			ㄴㄴ전송방법 2가지 : 1. get방식 / 2. post방식
		--%>
		<h3>EL로 받기</h3>
		<ul>
			<li>이름 : ${param.name }</li> <!-- param 내장객체 -->
			<li>성별 : ${param.gender }</li>
			<li>관심사항 : 
				<!-- 
				JSTL의 forEach태그는 JAVA의 확장for문과 동일한 역할 수행.
				items속성에 지정한 배열에 있는 요소를 하나씩 꺼내어
				var속성에 지정한 변수에 할당하면서 반복함.
				-->
				<c:forEach items="${paramValues.inter }" var="s">
					${s }&nbsp;
					<!-- 
					paramValues << 배열
					var			<< 출력변수
					
					for(String s :  배열)
						=> s
					-->
				</c:forEach>
			</li>
			<li>학력 : ${param.grade }</li>
		</ul>
	</ul>
</body>
</html>