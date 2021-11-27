<h1>Javascript</h1>
Client-side Script Language로, 웹 브라우저에 의해 순차적으로 해석되어 실행되는 인터프리터 방식의 언어. <br>
즉, Front-End를 담당하는 언어로 주로 HTML, CSS등을 동적으로 제어.

<h2>ECMA Script</h2>
자바스크립트는 1990년대 Netscape사에서 최초개발하고 그 후 MS에서 Jscript라는 언어를 개발해 IE에 탑재하였는데 이 두 스크립트가 너무 제각각이라 표준이 필요하게 되었다. <br>
표준을 위해 자바스크립트를 ECMA( European Computer Manufacturers Association)라는 정보와 통신시스템의 비영리표준기구에 제출하였고 표준에 대한 작업을 ECMA-262란 이름으로 채택.

<h3>ES버전에 따른 특징</h3>
<h4>ES3</h4>
흔히 말하는 자바스크립트로 학습의 대부분을 차지
<h4>ES5</h4>

- 배열에 forEach, map, filter, reduce, some, every와 같은 메소드 지원
- Object에 대한 getter/setter 지원
- 자바스크립트 strict 모드 지원 (더 깐깐한 문법 검사)
- JSON 지원 (과거에 XML을 사용하다가, JSON이 뜨면서 지원하게 됨)

<h4>ES6</h4>

- let, const 키워드 추가
- arrow 문법 지원
- iterator/generator 추가
- module import/export 추가
- Promise 도입

<h3>변수 선언 방법 및 특징</h3>

```
var 변수명
```
- 변수를 선언하는 유일한 방법
- int, double등의 별도의 자료형이 존재하지 X. 
- 변수에 대입한 값에 따라 자료형이 결정된다. 
- 대소문자를 구분

------------------------------

<h2>자료형</h2>

- 변수를 선언하는 유일한 키워드는 var
- JS에서는 변수를 선언한 후 초기값에 의해 자료형이 결정되므로 하나의 변수로 숫자, 문자 등 모든 자료형으로 활용할 수 O
- 문자열을 표현할때 '(싱글), "(더블) 모두 사용 가능. 즉, 문자와 문자열을 구분하지 X 

<h3>자료형의 종류</h3>
<h4>number</h4>
실수나 정수
<h4>string</h4>
문자열('', "" 로 표현)
<h4>boolean</h4>
true, false
<h4>Object</h4>
document, window, null, Date, Math 등
<h4>undefined</h4>
변수 정의 후 초기화하지 않은 경우
<h4>Error</h4>
변수를 정의하지 않고 출력하는 경우

<h2>연산자</h2>
JAVA의 연산자와 동일 <br>
단, 처리방식에 차이가 있다. 조건식에 0, null, false이면 false로 처리. <br>
나머지는 모두 true로 처리됨.

<h2>제어문</h2>
<h3>if문</h3>
if(비교식, 논리식 뿐만 아니라 산술식 등 모든 값이 올 수 있다.) <br>
JavaScript에서 모든식이 가능한 이유는 0, null, false 이외의 모든 값을 true로 판단하기 때문.

<h3>for/while문</h3>
script태그 안에서 선언된 변수는 해당 페이지의 모든 영역에서 사용 가능. <br> 
for문 안에서 선언한 변수 역시 전역적으로 사용 가능.

<h3>switch문</h3>
모든 값이 나올수 있는 식이 가능. 즉, 정수뿐만 아니라 실수, 논리값(true/false), 문자열도 가능 <br>
Java에서는 정수값(byte/short/char/int)이 나올 수 있는 정수식(산술식)이거나 문자열(string)이어야 한다. <br>
long타입은 사용할 수 X

<h3>break/continue</h3>
break : 반복문이나 switch문을 탈출 <br>
continue : 현재 continue가 속해있는 반복블럭의 처음으로 이동
