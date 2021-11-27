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
