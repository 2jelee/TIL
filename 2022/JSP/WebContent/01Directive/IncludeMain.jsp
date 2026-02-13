<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
include 지시어 :
	공통으로 사용할 JSP파일을 생성한 후 현재문서에 포함시킬 때 사용한다.
	각각의 JSP파일 상단에는 반드시 page 지시어가 삽입되어야 한다.
	단, 하나의 JSP파일에서 (상단의)page지시어(<%@ ~~~~~~ %>)가 중복 선언되면 X(안됨)
 --%>
<%@ include file = "IncludePage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IncludePage.jsp</title>

<!-- CSS코드는 양이 많으므로 외부파일로 선언하여 현재문서에 링크시킨다. -->
<link rel="stylesheet" href="./css/div_layout.css" />

</head>
<body>
	<div class="AllWrap">
		<div class="header">
			<!--  GNB영역 -->
			<%@ include file ="../common/Top.jsp" %>
		</div>
		<div class="body">
			<div class="left_menu">
			<!--  LNB영역(Local Navigation Bar) -->
			<%@ include file="../common/Left.jsp" %>
			</div>
			<div class="contents">
				<!--  COntents 영역 -->
				
				<h2>오늘의 날짜 : <%=todayStr %></h2>
				<br /> <br />
				
				(서울=연합뉴스) 증권팀 = 연초 이후 박스권에서 지루하게 움직이던 코스피가 10일 종가 기준으로 사상 최고치를 경신하며 새 역사를 썼다.
				<br /> <br />
				미국 고용 지표가 예상보다 부진하게 나와 조기 긴축 우려를 덜고 달러 가치를 끌어내렸다. 이는 외국인과 기관의 쌍끌이 매수로 이어져 주가지수를 끌어올렸다.
				<br /> <br />
				투자자들은 코스피가 이제 답답한 박스권을 벗어나 더 높은 수준으로 도약할 수 있을지 주목하고 있다.
				<br /> <br />
				달러 약세에 외국인 9일만에 순매수
				한국거래소에 따르면 이날 코스피는 전 거래일보다 52.10포인트(1.63%) 오른 3,249.30에 거래를 마쳤다.
				<br /> <br />
				지난달 20일 기록한 종가 기준 사상 최고치 3,220.70을 약 3주 만에 갈아치웠다. 또 장중 한때 3,255.90까지 올라 역대 장중 신고가 3,266.23에도 바짝 다가섰다.
				<br /> <br />
				유가증권시장에서는 외국인과 기관이 각각 2천383억원, 9천674억원을 순매수해 지수 상승을 이끌었다.
				<br /> <br />
				특히 외국인이 지난달 26일 이후 9거래일 만에 순매수로 전환하면서 상승세에 탄력이 붙었다.
				<br /> <br />
			</div>
		</div>
		<div class="copyright">
		<@!-- Copyright -->
			<%@ include file="../common/Copyright.jsp" %>
		</div>
	</div>

</body>
</html>