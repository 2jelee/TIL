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

------------------------------

<h2>Javascript의 Core객체</h2>
<h3>String 객체</h3>
웹 브라우저상에 문자열을 표현하는 표준 내장 객체 <br>
[형식] <br>
방법 1

```
var 변수명 = new String("문자열");
```

방법 2

```
var 변수명 = '문자열'; 혹은 "문자열"
```
=> 즉, '(싱글) 이나 "(더블) 뭐든 상관 X

문자열은 배열과 동일하게 인덱스는 0부터 시작
<img src="https://blog.kakaocdn.net/dn/dpJMUt/btquGEg3PTd/L7XcRVSupNkRXHgCFj7O71/img.png" />

<h3>Date 객체</h3>
날짜와 시간을 다루는데 사용되는 표준 내장 객체로 현재시스템의 날짜를 알아낼 수 있고 시스템 날짜를 설정할 수도 있다. 

```
var date = new Date();
```
날짜정보를 설정할 때는 setXXX()계열의 함수 사용, <br>
날짜정보를 가져올 때는 getXXX()계열의 함수 사용

<h3>Math 객체</h3> 
수학에서 자주 사용하는 상수와 함수들을 미리 구현해 놓은 표준 내장 객체 <br>
Math 객체는 다른 객체와는 다르게 생성자(constructor)가 존재하지 않아, <br>
new 연산자로 인스턴스를 생성하지 않아도 Math 객체의 모든 메소드를 사용할 수 O

```
Math.min(1, 10, -100, -10, 1000, 0); => -100
Math.random() * (10 - 1) + 1; => 1~10사이정수
Math.round(10.49); => 10
Math.floor(11.95); => 11
Math.ceil(10.01); => 11
Math.sin(Math.PI / 2); => 1
```

------------------------------
    
<h2>DOM(Document Object Model)</h2>
DOM(문서 객체 모델)은 HTML, XML 문서의 프로그래밍 interface로 문서의 구조화된 표현(structured representation)을 제공 <br> 
프로그래밍 언어가 DOM 구조에 접근할 수 있는 방법을 제공하여 그들이 문서의 구조, 스타일, 내용 등을 변경할 수 있게 돕는다. <br>
개발자도구의 Elements에서 확인할 수 있는 항목을 DOM이라 할 수 있다.

<h3>DOM 객체 얻어오기</h3>
document객체의 getElementXXX() 계열의 함수를 통해 DOM을 얻어올 수 있다.
<br>
[형식]
1. 태그명으로 얻어오기
```
document.getElementsByTagName("태그명");
```

2. name속성으로 얻어오기
```
document.getElementsByName("name속성값");
```

3. 클래스명으로 얻어오기
```
document.getElementsByClassName("class속성값");
```

4. id값으로 얻어오기
```
document.getElementById("id속성값");
```

- 1,2,3번은 문서상에 1개 이상 존재할 수 있으므로 배열의 형태로 반환됨
    만약 해당 객체가 없을 때에는 길이가 0인 배열을 반환 
- 2개 이상의 요소를 대상으로하므로 getElements 즉, 's'가 붙음을 유의!
- 4번은 하나의 값만 존재하므로 getElement로, 's'가 없다.

<h3>window 객체</h3>
JavaScript에서 window는 모든 객체의 조상으로 최상위객체임. <br>
하위에는 대표적으로 screen, location, history, document 같은 객체들이 존재 <br>
window는 전역객체(글로벌객체)이고 모든 객체를 다 포함하고 있기 때문에 명령어에서 생략 가능

<h4>location 객체</h4>
페이지를 이동할 때 사용 <br> 
html의 a태그와 동일한 역할을 한다. <br>
target을 걸어야 할 경우에는 "타켓.location" 형태로 작성 <br>
프레임이나 팝업창같이 depth가 존재할 경우 단계를 통해 target을 지정할 수도 있다. 

<h4>history 객체</h4>
페이지 이동은 동일하나, 이전에 '이동했던 내역이 있는 경우'에만 이동할 수 O <br> 
IE/크롬과 같은 브라우저에서 "뒤로" 버튼과 동일한 기능을 수행한다. <br>
history.go()의 경우 2페이지 전으로와 같이 단계를 지정할 수 있다. <br>

<h4>대화창</h4>
<h5>alert</h5>
단순한 경고창. 사용자에게 메세지 전달 시 주로 사용

<h5>confirm</h5>

- 대화상자의 일종으로 사용자에게 어떤 액션을 취할지 여부를 물어볼때 사용
- '확인'을 누를경우 true가 반환되고, '취소'를 누를경우 false가 반환

<h5>prompt</h5> 
사용자로부터 입력을 받기 위한 대화상자로, 디폴트값이 필요한 경우에는 두 번째 인자에 입력해주면 된다. <br>
ex) prompt("창에 보일 메시지","디폴트값");

<h4>팝업창</h4>
광고나 공지사항을 게시할때 새로운 창을 띄울때 사용하는 함수
```
window.open("창의경로", "이름", "속성,모양,위치");
```

- open() 함수는 윈도우 객체를 반환
- 팝업창을 여러개 띄울때 창의이름이 같으면 하나의 창에 계속 띄워짐

<h5>width</h5> 
팝업창의 가로폭

<h5>height</h5>
팝업창의 세로폭

<h5>top</h5>
팝업창을 띄울때 Y좌표 (모니터를 기준으로 상단에서 띄워짐)

<h5>left</h5>
팝업창을 띄울때 X좌표 (모니터를 기준으로 좌측에서 띄워짐)

<h5>location</h5>
주소표시줄 on/off

<h5>toolbar</h5>
도구모음창 on/off

<h5>menubar</h5>
메뉴바 on/off

<h5>scrollbars</h5>
스크롤바 on/off

<h5>resizable</h5>
팝업창의 크기조절 가능여부 on/off

<h4>시간 제어</h4>
주기적인 작업을 실행하기 위해 setTimeout, setInterval 두가지 함수를 사용할 수 있다.

<h5>setTimeout() / clearTimeout() 함수</h5>

```
▶ 설정 시
var 타이머변수 = setTimeout("함수명()", 설정시간);
▶ 해제 시
clearTimeout(타이머변수);
```
- 설정한 시간이 되면 함수를 딱 한번만 호출
- 시간은 1000분의 1초 단위로 설정

<h5>setInterval() / clearInterval() 함수</h5>

```
▶ 설정 시
var 타이머변수 = setInterval("함수명()", 1000);
▶ 해제 시
clearInterval(타이머변수);
```
- 설정한 시간 간격마다 함수를 지속적으로 호출
- 시간은 1000분의 1초 단위로 설정
- 주기적인 호출이 필요한 경우 주로 사용
    ex) 남은날짜 혹은 시간 등의 알림.

<h4>기타</h4>
<h5>escape() / unescape() 함수</h5>
한글이나 일본어, 중국어 등 2바이트로 표현하는 언어들을 UTF-8로 인코딩 할때 사용 <br>
숫자나 영문자는 아스키코드(ANSI)로 표현하기 때문에 인코딩의 대상이 X <br> 
주로 Ajax나 jQuery에서 한글을 처리할때 사용

<h5>eval()</h5>
매개변수로 전달되는 문자열을 자바스크립트 코드로 해석 <br>
문자열로 전달되는 매개변수의 양쪽에 있는 더블쿼테이션을 이발하듯 잘라내서 내부에 있는 코드를 자바스크립트로 실행 

<h5>isNaN()</h5>
Is Not A Number <br>
매개변수가 숫자가 아닐때 true를 반환하는 함수

<h5>parseInt()</h5>
문자열에서 숫자부분만 반환해주는 함수이다. <br> 
단, 숫자가 아닌 문자로 시작하는 경우에는 NaN을 반환한다. 

------------------------------

<h2>이벤트(Event)</h2>
이벤트(event)는 어떤 사건(Action)을 의미 <br>
웹브라우저에서의 사건(event)이란 사용자가 클릭을 했을 때, 스크롤을 했을 때, 필드의 내용을 바꾸었을 때와 같은 것을 의미

<h3>이벤트 핸들러</h3>
이벤트가 발생했을때 그 후속 작업을 처리하는 객체(object)를 말한다. <br>
이벤트 리스너(Event Listener)라고도 하며 일반적으로 이벤트명 앞에 “on”이 붙은 형태를 띈다.


<h3>이벤트 핸들러 등록방법</h3>

1. HTML 요소의 속성으로 등록하는 방법
2. DOM 요소의 프로퍼티로 등록하는 방법
3. addEventListener 메서드를 사용하는 방법

[방법 1] <br>
HTML 요소로 버튼을 만들고, 버튼의 속성 중 "onclick" 속성에 이벤트 처리 함수를 등록

```
<body onload="loadEventFunc();">
```

[방법 2] <br>
window 객체와 document 객체와 같은 DOM을 이용해서 이벤트 처리함수를 등록

```
window.onload = function() {
    var button = document.getElementById("button");
    button.onclick = displayTime; //함수호출
}    
```

[방법 3] <br>
addEventListener 메서드를 이용해 핸들러를 등록하는 방법

```
window.addEventListener("load", function(){
    alert("load이벤트활용3. 문서 로딩 완료");
});
```    
형식1,2와는 다르게 첫번째 인자로 이벤트타입이 사용됨. <br>
즉, on을 제외하고 기술 

<h4>이벤트 1</h4> 
<h5>click이벤트</h5>
HTML에서 가장많이 사용하는 이벤트로 마우스를 클릭했을때 발생한다. 해당 이벤트는 HTML의 모든 엘리먼트에 부착 O

<h5>change 이벤트</h5>
<select>태그에서 <option>을 변경할때마다 발생하는 이벤트로 해당 이벤트는 <select>태그에서만 사용 가능 

<h5>submit(전송) 이벤트</h5>
form값을 서버로 전송하기 위해 submit버튼을 눌렀을때 발생하는 이벤트로, 반환값이 true일때만 정상적으로 전송 <br>
만약 반환값이 false라면 전송되지 않는다.  

<h5>reset 이벤트</h5>
reset 버튼을 눌렀을 때 발생하는 이벤트

<h4>키보드 이벤트</h4>
keydown

```
키보드를 누를때 발생하는 이벤트로 이벤트가 발생한 후 텍스트가 입력됨.
shift, alt, ctrl 등도 모두 인식
```

keyup

``` 
키보드를 눌렀다가 땔 때 발생하는 이벤트. 
키보드를 누를 때 텍스트가 입력, 땔 때 이벤트가 발생한다. (keydown에서 인식하는 모든키를 동일하게 인식한다.)
```

keypress 

```
키보드를 눌렀을 때 발생하는 이벤트로 keydown과 동일
단, shift, ctrl 등과 같은 키들은 인식하지 X, 문자키만 인식하는 특징. 한글은 인식 X
```

<h4>focus & blur 이벤트</h4>
focus 

```
입력을 위해 input과 같은 엘리먼트를 선택했을 때 발생되는 이벤트이다. 
```

blur

```
focus와는 반대의 이벤트로 포커스를 잃었을 때 발생한다. 
```


<h4>마우스 이벤트</h4>
mouseover

```
엘리먼트에 마우스를 올렸을 때 발생되는 이벤트
```

mouseout

```
엘리먼트에서 마우스를 내렸을 때 발생되는 이벤트
```
mousedown

```
엘리먼트에 마우스를 클릭할 때 발생되는 이벤트 
```

mouseup
```
엘리먼트에 마우스를 클릭했다가 떼는순간 발생되는 이벤트
```
  
------------------------------

<h2>객체(Object) 생성</h2>
자바스크립트는 자체적으로 클래스라는 개념이 없기 때문에 기존 C++, Java와 같은 클래스기반 객체지향언어와는 객체생성 방법이 다름. <br>
객체를 생성할 수 있는 방법은 크게 3가지로 나뉜다.

<h4>1. 기본 객체(Object() 객체)의 생성자 함수를 이용</h4>

```
function myFunc(){ 실행부; }

var member = new Object();
member.Id = '2jelee';   //멤버변수
member.func = myFunc;   //멤버메소드
```

<h4>2. 객체 리터럴 이용</h4>

```
var person = {		
    id : "2jelee",	
    myFunc : function(){
        실행부;
    }	
};
```

=> 리터럴 표기법? <br>
리터럴이란 '문자그대로의...'라는 의미를 가지고 있다. 즉, JS에서 객체와 배열을 간단히 정의하는 방법이라 말할 수 있다. <br>
정규적이지 않은 방법으로 보일수 있으나 코드는 간단해지고 엔진(브라우저)의 해석속도는 훨씬 ↑

<h4>3. 생성자 함수 이용</h4>

```
var Member = function(Id,pass,gender) {
    this.Id  = Id;
    this.pass = pass;
    this.gender = gender;

    this.func = function(){
        return "함수실행";
    }
    return this;
}
```

------------------------------ 

<h2>CSS 컨트롤</h2>
CSS속성을 JS에서 컨트롤할 때는 -(하이픈)를 빼고 두 번째 블럭의 첫 글자를 대문자로 변경 <br>
하이픈이 없는 속성은 원형 그대로 사용

```
DOM객체.style.CSS속성 = "속성값";

ex)
font-size:10px; => fontSize='10px';
background-image:url() => 			
    backgroundImage="url('이미지경로')";
color: red; => color = 'red';
```

<h2>Form(폼)</h2>
Javascript로 HTML의 <form> 엘리먼트를 가져오는 방법에는 2가지 방법 존재. <br>
이를 통해 하위요소인 <input>태그에 접근 O

[형식 1]

```
var frm = document.forms[0];
```

- form태그를 배열처럼 인식하여 가져옴.
- forms[0] 이란 HTML페이지에서 첫번째 form이라는 뜻
- 만약 form의 순서가 변경된다면 수정이 필요

[형식 2]

```
var frm = document.폼의name속성값;
```

- form태그의 name 속성값을 통해 가져옴.
  이 경우, 순서가 변경 되더라도 수정은 필요 X 
=> 실무에서 주로 사용되는 방법

<h3>checkbox/radio 속성</h3>

<h4>checked</h4>
체크 되었는지 여부를 판단하거나, 체크/언체크를 제어 O

1. 체크여부 판단

```
요소.checked==true / false
```

2. 체크

```
요소.checked=true or ‘checked’
```

3. 체크 해제

```
요소.checked=false or null
```

<h4>disabled</h4>
  
1. 활성화 여부 판단

```
요소.disabled == true or false
```

2. 활성화/비활성화
```
요소.disabled = true or false
```

<h3>폼값 검증(Validation)</h3>
input태그의 type에 따라 검증방법 상이

입력값에 대한 검증

```
text, password, file
```

```
textarea, select
```

선택값에 대한 검증

```
checkbox, radio
```

<h3>this / this.form / this.value 차이</h3>

- this는 해당 엘리먼트 자체를 가리킴
- this.value는 엘리먼트의 value값을 가리킴
- this.form은 엘리먼트가 포함된 form태그를 가리킴. 
  만약 <form>태그 자체에 사용한다면 this를 써야됨

```
<form name="frm1" onsubmit="return myValidation(this)">     //여기서 this는 frm1을 가리키고
    <input type="text" name="user_id" value="2jelee" onclick="myFunc(this.value);" />   //여기서 this.value는 해당 input의 value값을,
    <input type="button" value="로그인" onclick="myFunc(this.form);" />     //여기서 (this.form)은 frm1을 가리킨다.
</form>
```
