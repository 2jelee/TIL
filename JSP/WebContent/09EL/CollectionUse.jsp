<%@page import="common.Person"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL-컬렉션</title>
</head>
<body>
<h2>List 컬렉션</h2>
<%
ArrayList<Object> aList = new ArrayList<Object>();

//String객체, Person객체를 각각 저장
aList.add("청해진");
aList.add(new Person("장보고", 28)); 

//page영역에 속성 저장
pageContext.setAttribute("Ocean", aList);
%>
<ul>
	<li>0번째 요소 : ${Ocean[0] }</li> <!-- String객체 생성 -->
	<li>1번째 요소 : ${Ocean[1].name }, ${Ocean[1].age }</li> <!--
			List계열의 컬렉션은 배열과 같이 index를 통해 접근함.
			멤버변수명만으로 출력이 가능한 이유?
				=> getter가 있기 때문임. (즉, getter가 없으면 출력되지 X(에러 발생))
					ㄴ common패키지 Person 클래스 getter getName 주석 처리해보기
		-->
	<li>2번째 요소 : ${Ocean[2] }</li> <!-- 출력되지 X. error도 발생 X -->
</ul> 

<h2>Map 컬렉션</h2>
<%
Map<String, String> map = new HashMap<String, String>();
map.put("한글", "훈민정음");
map.put("Eng", "English");
pageContext.setAttribute("King", map);
%>
<!-- 
	Map 컬렉션 사용 시 key값으로 한글을 사용할 수 있다.
	단, EL에서 값을 읽을 때 한글인 경우에는 .을 사용할 수 X
	반드시 '배열형태'로 사용해야 한다.
 -->

<ul>
	<li>한글Key : ${King["한글"] }, ${King['한글'] },
		\${King.한글 }</li> <!-- error 		>> parsing(컴퓨터에서 컴파일러 또는 번역기가 원시 부호를 기계어로 번역하는 과정의 한 단계로, 각 문장의 문법적인 구성 또는 구문을 분석하는 과정)에 실패했다.
			error 원인 : ELException: Failed to parse the expression [${King.한글 }]
						 org.apache.jasper.compiler.Validator$ValidateVisitor.prepareExpression
				-->
	<li>영문Key : ${King["Eng"] }, ${King['Eng'] },
		${King.Eng }</li>
</ul>
</body>
</html>