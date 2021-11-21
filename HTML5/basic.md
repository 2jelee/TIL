[HTML5]
web : 거미줄(사전적 의미)
worldwide web ... www (따따따)
<> : 태그

<head> 
선언      -> javascript, css
</head>

브라우져 시장 점유율↑ >> Chrome

perspective >> java EE
Dynamic Web proj 생성
K03 > 무조건 WebContent 에 만든다
New > HTML file 생성

apache.org
> Tomcat 9 > 9.0.45 down
확장자 붙이든 안붙이든 상관X

주석 키 : ctrl + shift + /


01 텍스트 관련 태그
hn : headline

작성교안
인라인 엘리먼트 : 자기가 가진 크기만큼 컨텐츠를 차지
블럭 엘리먼트 : h태그는 대표적인 블럭 엘리먼트
	눈에는 안보이지만 한 블럭을 (완전히, 전체를) 차지하는 것.

메타데이터 에서 지우면... (원본은 있)
404 error >> 4~로 시작하는 에러의 경우 : 사용자 잘못
HTTP 상태 404 – 찾을 수 없음

H02Hn.html
<sytle> 아래 h1 h2...등 앞에 있는 것들 = 선택자(셀렉터)
border : 테두리 << 자주 사용하게 될 용어
solid : 직선으로 표현한다.
10픽셀짜리 선을 빨간색으로 하겠다. => border:10px solid red;
*우선순위가 높다?
: 늦게 작성된(태그에 가까운★) 것이 우선순위가 가장 높다.

블럭 엘리먼트, 인라인 엘리먼트 결정적 차이
창을 줄였을 때,
블럭) 같이 줄여짐
인라인) 자리가 없으면 아래로 떨어짐.


02 목록 관련 태그
d~ : definition
상위.. 하위(>)..
dl>dt + dd 	동위선택자(+).. depth(깊이)가 동일한 경우
(dl>dt+dd)*5 	5개 만들어짐


html(마치 원단같은)만 사용 X >> CSS와 함께 쓰인다.

ul, ol, li가 d~ 보다 사용도 높.



03 하이퍼링크
<a> : 가로형 배치(인라인 엘리먼트)
링크 클릭 시 새로운 탭으로 열리는 경우 : _blank
  	     현재 페이지에서 바뀌는 경우 : _self
***target 속성값에 반드시 _(언더바) 붙는다.

상대경로 : ./ 위치에 따라 달라짐    >> 많이 사용됨.
절대경로 : / 위치와 상관 X

./ : 현재위치
../ : 한 단계 상위경로 (한 단계 상위 디렉토리 위치)
/ : (항상)Root 디렉토리(최상위)

localhost:8081/K03HTML5/H06A.html
Host
컨텍스트 루트 경로(해당 프로젝트 구분 사용용도)
파일명

	
```
network >> cmd >> cd(change directory)\

사용도
절대경로 < 상대경로
절대경로 : / or http로 시작
상대경로 : ./ or ../로 시작

@앵커(Anchor)
#앵커명
# >> 걸어주기!

JRE
java
R
Environment

Tomcat 실행환경 (포트)설정
01DevelopKits > apache-tomcat-9.0.45>conf>server.xml
					ㄴ 이것이 원본임
					ㄴ 여기서 포트 8081

도형 좌표 지정
: 그림판으로 좌표 확인 가능,
http://maschek.hu/imagemap/imgmap/ (좌표코드 따올 수 있는 사이트)

F12 > 개발자도구

@작성 H08Table
html에서 표는 셀 하나하나..처럼 생각 (일반 표처럼 생각 X)
CSS : padding margin 여백 지정시 사용
margin : 박스의 바깥쪽 여백을 지정
padding : 박스의 '안쪽 여백'을 지정

border :  테두리(두꺼운게 X)

<table border="5" cellpadding="20" cellspacing='5' bgcolor='' width=200>
", ', (쓰지않>>띄어쓰기만 잘) 상관 없다는 의미.

cellspacing='20' >>>> 보통의 경우는 0을 준다. (정말 표처럼 보이게)
cellpadding : 셀과 컨텐츠 사이의 간격(여백)
	cellspacing : 셀과 셀 사이의 간격을 지정

CSS속성을 이용하면 >> 보다 세세하게 지정할 수 있다.

@06 폼(Form) 태그
주소창...  쿼리스트링,,,
#전송방식
ㄴ get방식 : 주소줄에 나타나면
	text 파일
ㄴ post방식 : 주소줄에 나타나지 X
	용량과 상관없이 무한대로 전송 O
	mp3, avi ... 

@vs code
vs code >> ! + (tab)  >> html의 기본폼이 뜬다.
New -> .(확장자) 확장자 붙여주자! >>> 확장자 인식함


@H09Form02
maxlenth 최대 입력가능한 글자수	사용 예) 주민번호 등
hidden >> 보이진 않으나 서버로 전송되는


http://localhost:7070/H09Form02.html?n1=2jelee111111111111&jumin1=121211&homepage=http%3A%2F%2F
서버로 전송된 것 : n1, jumin1,    homepage(?)

#textarea 태그
onclick >> 리스너

오류찾기 >> 해당 페이지 -> F12 -> 콘솔에서 에러 확인
	
	

```
@06 폼
form 태그에서 method를 안쓴다면? 

#전송방식
Get >> text만 전송
Post >> txt 뿐만 아니라 모든 파일(이미지 등)들

#버튼 형태의 속성에 따른 구분
submit == image
image >> 전송
커스텀..?

button >> onclick 리스너를 사용해야 .... J.S함수
file >> 웹 브라우져마다 다름..?
	ㄴ 그러므로 이미지를 사용하는 경우 多

@작성용교안
H09Form03
reset : 입력을 지우는 것이 X >> 초기값으로 만들어주는 것

textarea : 밸류값이 없지만 있다. ?
	코드정렬 하지말라.

자기소개:
        <textarea name="intro" id="" cols=50 rows="5">내용은 여기에 입력됩니다.</textarea>
cols, rows 크기지정... 잘 쓰지 X >> CSS에서 상세하게 맞춘다.

#H09Form04
<col style="width:*" />  : * : 자유롭게.. free

16진수를 가지고 색상..
<td colspan="2" style="background-color:#ffffff;"> : 화이트
<td colspan="2" style="background-color:#000000;"> : 궘정
<td colspan="2" style="background-color:#ff0000;"> 빨강 R
<td colspan="2" style="background-color:#00ff00;"> 그린 G
<td colspan="2" style="background-color:#0000ff;"> 블루 B


@07 프레임/멀티미디어
스크롤scrolling  >> 대부분의 경우 auto로 사용함

iframe >> 깊이(depth)를 가짐
parent 한단계 상위
top 무조건 최상위

target="topWin" >> _없이 바로 이름 :  딱 찝어서 그곳으로 이동
_  : html에서 직접적으로 제공하는 / depth내에서 단계별로

타겟이 있으면 해당 타겟에서.
타겟이 없어지면 새창으로.

#H11Frame
rows >> 세로형태로 배치하겠다
100px
------
*
------
50px


#속성
autoplay
: 화면이 로딩될때 해당 동영상을 즉시 플레이 하는 옵션.
  하지만 최근에는 사용자가 원할때만 플레이 할 수 있도록 autoplay를 지원하지 않는 추세
