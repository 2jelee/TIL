전체선택자 : *
하위선택자
형식 : 상위요소 하위요소 >> 사이 공백
아이디 선택자
#사용 

@작성용 교안 C01Selector01
작성은 항상 body가 먼저!d
body영역 작성 후 head영역을 작성하는 것이다.

class속성 > 단일 개체?만을 지정하는..?

div = divide 나누다. 분할하다
div는 하나의 블럭을 차지하는.. 특별한 기능은 (아직)없다.

div는 젠코딩을 사용하면 편하다. >> div 태그는 html에서 제일 많이 사용됨.
#으로 시작 => ID 속성
.으로 시작 => 클래스 속성
ex) .myDiv + [tab] >> 자동완성

(단, span태그는 X)

font-weight:bold; 진하게

.myDiv span
.myDiv 클래스 하위에 있는 span을 선택하겠다는 의미

css 주석달기 : 블럭단위 주석 사용 /**/

하위요소 >> 빈공간 有


----------------------------

[02. CSS 적용방식과 우선순위]
우선순위
      높                                                낮
!important > Inline style > id > class > tag > *
 ㄴ 끝판왕     ㄴ li

@C02OrderByCSS
External 스타일은
개발하는 시점에는 불편함. 캐시에 남기때문에
<style> 
        h2{ color: blue;}
        h2{ color: red;}

        #mnt { color: gray; !important; }

        dd{ color: green;}
</style>
개발 때는 임베딩(위와같은)시킨다

개발 완료 후 배포할때 적용방식 2(external스타일)로 만든다.

Embedding스타일과 External 스타일에 따른 우선순위는 없음. 
나중에 나오는 것(태그에 가까울수록)이 우선순위 높. (기본원칙 따른다)


[03. 텍스트와 문단]
pt : 포인트.	프린트와 연계 사용 단위
     word, 아래한글 >> 글자크기
px : 스크린매체(모니터 등)에서 사용되는
em : 기본에 따라 가변적(상대적으로)
 ㄴ 모바일 웹으로 인해 

pt, px >> 절대좌표
em >> 상대좌표     처럼 생각


@C03Font02
style태그의 body는 결국 *
즉, 전체를 선택하겠다는 것과 같다.

@C04Paragraph
인라인 엘리먼트 vs 블럭 엘리먼트
차이
인라인 >> 안밀린다.  		???? 다시 정리


@ C05Border02
기본틀은 사각형. 
속성값 순서 : 좌측상단부터 시계방향 순서로 깎아나가는 형태.
(적용(기본):상>우>하>좌)

box-shadow: 20px 30px 50px #6d0202;
                               ㄴ알파값(포토샵 용어)
			투명도: 0으로 가까워지면 흐려지고
				숫자가 100으로 가까워지면 흐려진다.

[05. 마진과 패딩/리스트/가시성]
패딩이나 마진 n가지 방법 모두 많이 사용
형식2
선택자 {
	padding:상하  좌우;
	padding:상  좌우  하;
	padding:상  우  하  좌;	
}

상단부터 시계방향으로 지정한다.  ★



======
과제
깎기 border radius

display창 >> div or input태그 사용 ... 숫자만 입력되면 된다.
number pad >> button 태그 사용
테이블 4X6

padding으로 적당히 사이 띄어두기

~~최대한 비슷하게 만들기
색 따기 : 크롬웹스토어 > 확장프로그램 > colorzilla
