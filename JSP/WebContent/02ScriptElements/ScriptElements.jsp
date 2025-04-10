<%--
	JSP의 스크립트 요소들(ScriptElements)
	
	지시어(Directive) : 페이지 속성을 지정하거나 외부문서를 포함할때 사용.
						(page, include, taglib이 있다.)
 --%>
<%@page import="common.MyClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--
	선언부(Declaration) : 
		스트립트릿이나 표현식에서 사용할 메소드를 선언할 때 사용한다.
		함수는 재사용하기 위해 작성하는 경우가 많으므로 주로 src를 사용함.
 --%>
<%!
public int add(int a, int b){
	int result = a + b;
	return result;
}

public int subtract(int a, int b){
	int result = a - b;
	return result;
}

public void showPrint(String str, JspWriter out){
	try{
		out.println("받은 문자열:"+ str);
	}
	catch(Exception e){
		e.printStackTrace();
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JSP의 스크립트 요소들(Scripting Elements)</h2>
	
	<!-- include 지시어를 통해 다른 JSP를 문서에 포함한다. -->
	<%@ include file="../01Directive/IncludePage.jsp" %>
	
	<h4>src에 작성한 JAVA클래스의 사용</h4>
	<%
	//static형으로 선언했으므로 객체 생성없이 클래스명으로 접근 가능함.
	out.println("1~100까지의 합="+ MyClass.myFunc(1, 100));
	%>
	
	<%--
	스크립트릿(Scriptlet) :
		주로 JSP코드를 작성하고 실행할 때 사용하는 영역임.
		스트립트릿은 head 영역, body영역 어디서든 사용할 수 있다.
		또한 <script>, <style>태그 내부에서도 사용할 수 있음.
	 --%>
	<%
	int value1 = 3;
	int value2 = 9;
	
	int addResult = add(value1, value2);
	int subResult = subtract(value1, value2);
	
	%>
	
	<!-- 
	표현식(Expression)
		: 변수를 웹브라우져상에 출력할 때 사용함.
		JS의 document.write()와 동일한 역할을 함.
		표현식 사용 시 주의할 점은 문장 끝에 ;(세미콜론)을 생략해야 하는 것!!!
	 -->
	<h3>표현식으로 변수를 화면에 출력하기</h3>
	<%=value1 %> + <%=value2 %> = <%=addResult %>
	<br />
	
	<%=value1 %> - <%=value2 %> = <%=subResult %>
	<br />
	<%
		//인수로 out 내장객체를 전달하면 메소드에서는 이를 통해 웹브라우저에 변수를
		//출력할 수 있다.
		showPrint("우리는 KOSMO", out); //out << 내장객체 쪽에서 사용하는.. 추후 학습
	%>
	<br />
	오늘 날짜는 : <%=todayStr %> [인클루드된 파일에서 가져옴]
</body>
</html>