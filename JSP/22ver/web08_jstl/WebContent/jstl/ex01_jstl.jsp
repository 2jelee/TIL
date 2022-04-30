<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ex01_jstl.jsp  JSTL core 라이브러리 사용 예제</title>
</head>
<body>
<!-- String test = "Hello JSTL!!!"; -->
<c:set var="test"  value="Hello JSTL!!!!"  />
<h3> &lt;c:set&gt; 사용 후 : <c:out value=" ${ test }" /> </h3>
<hr>
<c:set value="happydoyeon"   var="nicname"/>
<h3>이름은 <c:out value="${ nicname }" /></h3>
<hr>
<c:set var="num">1000</c:set>
<h3> &lt;c:set&gt; 사용 후 num : <c:out value="${ num }"></c:out> </h3>
<hr>
<c:catch var="error">
	<%= 10 / 0 %>
</c:catch>

<h3> &lt;c:catch&gt; 로 잡아낸 오류 : <c:out value="${ error }" /> </h3>
<hr>
<%
		String str = "hello jstl~~~~";
		out.print(str + "<br>");
%>
표현식을 이용한 출력 : <%= str %> <br>
JSTL 이용하면 
	<c:set var="str2">hello jstl~~~~</c:set>
	str2 = <c:out value="${ str2 }" />
<hr>
<%
	String name = "happy";
	pageContext.setAttribute("id", "kingsmile");
	session.setAttribute("pwd", "oracle");
	application.setAttribute("team", "우리팀");
	request.setAttribute("age", 33);
%>
<%= name %> <br>
<c:set  value="<%=name %>"  var="irum"  />  <%--  <c:set value="happy"  var="irum" /> --%>
name = ${ name } <br>
name = <c:out value="${ name }"  default="무명씨야" />
name = ${ irum } <br>
<hr>

id= ${ id } <br>
pwd = ${ pwd } <br>
team = ${ team } <br>
age = ${ age } <br>
<hr>
<c:out value="ID = ${ id }" /> <br >
<c:out value="pwd = ${ pwd }" /> <br >
<c:out value="team = ${ team }" /> <br >
<c:out value="age = ${ age }" /> <br >
<hr>
<c:if test="${ 5 < 10 }">
	<h3>5는 10보다 작다</h3>
</c:if>
<c:if test="${ 5 > 10 }"> <!--  if 조건에서 else 구문은 없다 -->
	<h3>5는 10보다 크지 않다</h3>
</c:if>

<c:if test="${ 6 + 3 == 9 }"><h3>6 + 3 == 9</h3></c:if>
<c:if test="${ 6 + 3 != 9 }"><h3>6 + 3 != 9</h3></c:if>
<hr>
		<!-- java : switch ~ case  -->
<c:choose>
	<c:when test="${ 5 + 10 == 50 }"><h3>  5 + 10 == 50 </h3></c:when>
	<c:when test="${ 50 + 10 == 50 }"><h3>  50 + 10 == 50 </h3></c:when>
	<c:when test="${ 10 + 10 != 50 }"><h3>  10 + 10 != 50  </h3></c:when>
	<c:otherwise>아무것도 아니네요. 선택할 것이 없습니다.</c:otherwise>
</c:choose>
</body>
</html>







