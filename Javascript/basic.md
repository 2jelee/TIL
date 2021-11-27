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

------------------------------

<h2>배열</h2>
<h3>Javascript의 객체 유형</h3>

- Core객체
- DOM객체
- 브라우저 객체

Java와는 다르게 JS에서의 배열은 여러타입의 자료를 저장할 수 있는 자료구조(메모리)이다.

<h3>배열 선언</h3>
배열크기를 지정하여 선언 ***

```
var array = new Array(5);
```

선언과 동시에 초기화(new 사용) ***

```
var init = new Array("2jelee", 20, "서울");
```

선언과 동시에 초기화(new 미사용)

```
var initNoNew = ["2jelee", '서울'];
```

크기 지정없이 선언

```
var nosize = new Array();
```

- 웹 프로그래밍 시 가장 많이 사용되는 방법
- 배열의 크기는 가장 마지막 자료에 의해 결정됨 
- 크기를 지정하지 않은 경우, 크기가 0인 배열이 생성

<h3>함수 정의 방법</h3>
[방법 1] 유명(有名)함수 - 이름이 있는 함수

```
function 함수명(num1, num2, ...) {
  함수의 몸체;	
  return 변수 혹은 값;
}    
```

[방법 2] 무명(無名)함수 - 이름이 없는 함수

```
var 함수명으로사용할변수 = function(매개변수1, ...) {
  함수의몸체;	
  return 변수 혹은 값;
}    
```

- 함수정의 시 매개변수에는 var를 쓸 수 X → 변수명만 쓸 수 O
- 함수 안에서 선언된 변수는 함수의 실행이 끝나면 메모리에서 '소멸'되는 "지역변수"가 됨

<h3>지역변수와 전역변수</h3>
두 개의 변수가 충돌하게 될 경우, 지역변수가 우선순위 ↑ <br> 
this 키워드는 윈도우 객체를 가리키는 것으로 해당 페이지 안의 script 태그 안에 선언된 모든 멤버에 접근하는 것이 가능. <br>
즉, 전역변수와 지역변수를 구분하기 위해 사용됨

[형식] <br>
this.nameVar -> 전역변수 <br>
nameVar -> 지역변수(매개변수)

<h3>Call By Value</h3>
값을 통한 호출. 값을 매개변수로 복사해서 전달한다. <br>
callByValue() 함수로 전달된 param, args는 전달됨과 동시에 새로운 지역변수가 생성됨. <br>
함수의 실행이 종료되면 해당 지역에서는 소멸.

```
var param = 100, args = 1;
function callByValue(param, args){
  var temp = param;
  param = args;
  args = temp;              [출력결과 다름]
  document.write("param="+param+", args="+args); 
}
callByValue(param, args);
document.write("param="+param+", args="+args); 
```

<h3>Call By Reference</h3>
참조에 의한 호출. 값이 아닌 객체의 참조값(주소)을 전달한다. <br>
지역에 상관없이 동일한 변수(객체)를 참조할 수 O

```
var array = [100,1];
function callByReference(arr){
  var temp = arr[0];
  arr[0] = arr[1];
  arr[1] = temp;	           [출력결과 같음]
  document.write("arr[0]="+ arr[0]+", arr[1]="+ arr[1]);
}
callByReference(array);
document.write("array[0]="+ array[0]+", array[1]="+ array[1]);
```


