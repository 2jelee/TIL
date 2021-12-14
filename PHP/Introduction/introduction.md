<h1>PHP</h1>

- PHP : Hypertext Preprocessor
- 널리 사용되는 오픈 소스 스크립팅 언어
- 스크립트 서버에서 실행됨
- 웹에서 가장 큰 블로깅 시스템(WordPress)의 핵심이 될 만큼 강력
- 대규모 소셜 네트워크를 운영할 수 있을 만큼 깊다
- 초보자의 첫 번째 서버측 언어인만큼 쉽다

<h2>PHP 파일</h2>

- PHP 파일에는 텍스트, HTML, CSS, JavaScript 및 PHP 코드가 포함될 수 있습니다.
- PHP 코드는 서버에서 실행되고 결과는 일반 HTML로 브라우저에 반환됩니다.
- PHP 파일의 확장자는 " .php"

- PHP는 동적 페이지 콘텐츠를 생성할 수 있습니다.
- PHP는 서버에서 파일을 생성, 열기, 읽기, 쓰기, 삭제 및 닫을 수 있습니다.
- PHP는 양식 데이터를 수집할 수 있습니다.
- PHP는 쿠키를 보내고 받을 수 있습니다.
- PHP는 데이터베이스의 데이터를 추가, 삭제, 수정할 수 있습니다.
- PHP를 사용하여 사용자 액세스 제어 가능
- PHP는 데이터를 암호화할 수 있습니다.

- PHP를 사용하면 HTML 출력으로 제한되지 X
> 이미지, PDF 파일, Flash 동영상까지 출력 O
> XHTML 및 XML과 같은 모든 텍스트를 출력 O

<h2>사용 이유</h2>

- PHP는 다양한 플랫폼(Windows, Linux, Unix, Mac OS X 등)에서 실행 O
- 오늘날 사용되는 거의 모든 서버(Apache, IIS 등)와 호환 O
- 광범위한 데이터베이스를 지원합니다.
- PHP는 배우기 쉽고 서버 측에서 효율적으로 실행됩니다.

<h2>PHP 7의 새로운 기능</h2>

- 이전의 인기 있는 안정적인 릴리스(PHP 5.6)보다 훨씬 속도 ↑
- 오류 처리를 개선
- PHP 7은 함수 인수에 대해 더 엄격한 유형 선언을 지원
- PHP 7은 새로운 연산자(ex. 우주선 연산자: <=>)를 지원

----------------------------------

<h2>Syntax(구문)</h2>
PHP 스크립트가 서버에서 실행되고 일반 HTML 결과가 브라우저로 다시 전송됨

<h3>기본 PHP 구문</h3>

```
<?php
// PHP code goes here
?>
```
- PHP 파일은 일반적으로 HTML 태그와 일부 PHP 스크립팅 코드를 포함
- 참고: PHP문은 세미콜론( ;)으로 끝남

```
<?php
echo "Hello World!";
?>
```

----------------------------------

<h2>주석</h2>
1. 한 줄 주석

```
<?php
// This is a single-line comment

# This is also a single-line comment
?>
```

2. 여러 줄 주석

```
<?php
/*
This is a multiple-lines comment block
that spans over multiple
lines
*/
?>
```

3. 주석을 사용하여 코드의 일부 생략

```
<?php
// You can also use comments to leave out parts of a code line
$x = 5 /* + 15 */ + 5;
echo $x;
?>
```

----------------------------------

<h2>변수</h2>

<h3>변수 생성(선언)</h3>
변수는 $기호로 시작하고 그 뒤에 변수 이름이 온다.

```
<?php
$txt = "Hello world!";
$x = 5;
$y = 10.5;
?>
```
- ※참고 : 텍스트 값을 변수에 할당할 때 값을 따옴표로 묶는다.
- ※참고 : 다른 프로그래밍 언어와 달리 PHP에는 변수 선언을 위한 명령이 없습니다. 처음 값을 할당하는 순간 생성

<h3>변수에 대한 규칙</h3>
변수는 짧은 이름(x 및 y와 같은) 또는 더 설명적인 이름(age, carname, total_volume)을 가질 수 있습니다. <br>
<br>
[규칙]

1. 변수는 $부호로 시작. 그 뒤에 변수 이름이 온다.
3. 변수 이름은 문자 또는 밑줄 문자로 시작해야 합니다.
4. 변수 이름은 숫자로 시작할 수 X
5. 변수 이름은 영숫자 문자와 밑줄(Az, 0-9 및 _)만 포함할 수 O
6. 변수 이름은 대소 문자를 <b>구분</b> ($age및 $AGE두 개의 서로 다른 변수!)

<h3>변수 Scope</h3>

- PHP에서 변수는 스크립트의 어느 곳에서나 선언될 수 있다. 
- 변수의 범위는 변수를 참조/사용할 수 있는 스크립트의 일부이다.

변수 Scope의 종류

- local 
- global
- static

<h4>global, local 범위</h4>
함수 <b>외부</b>에서 선언된 변수는 전역 범위(GLOBAL SCOPE)를 가지며 함수 외부에서만 액세스할 수 있습니다.

<h5>global Scope</h5>

```
<?php
$x = 5; // global scope

function myTest() {
  // using x inside this function will generate an error
  echo "<p>Variable x inside function is: $x</p>";
}
myTest();

echo "<p>Variable x outside function is: $x</p>";
?>
```

함수 <b>내</b>에서 선언된 변수는 지역 범위(LOCAL SCOPE)를 가지며 해당 함수 내에서만 액세스할 수 있습니다.

```
<?php
function myTest() {
  $x = 5; // local scope
  echo "<p>Variable x inside function is: $x</p>";
}
myTest();

// using x outside the function will generate an error
echo "<p>Variable x outside function is: $x</p>";
?>
```

※지역 변수(local)는 선언된 함수에서만 인식되기 때문에 다른 함수에서 같은 이름을 가진 지역 변수를 가질 수 있습니다.

<h4>PHP global keyword</h4>
global키워드는 함수 내에서 전역 변수에 액세스하는 데 사용됨.

```
<?php
$x = 5;
$y = 10;

function myTest() {
  global $x, $y;
  $y = $x + $y;
}

myTest();
echo $y; // outputs 15
?>
```

PHP는 또한 모든 전역 변수를 . 는 변수의 이름을 보유하고 있음.   
이 배열은 함수 내에서도 액세스할 수 있으며 전역 변수를 직접 업데이트하는 데 사용할 수 있습니다.   
$GLOBALS[index] index   

위 예제를 다시 작성 ▼

```
<?php
$x = 5;
$y = 10;

function myTest() {
  $GLOBALS['y'] = $GLOBALS['x'] + $GLOBALS['y'];
}

myTest();
echo $y; // outputs 15
?>
```

<h4>PHP static keyword</h4>
일반적으로 함수가 완료/실행되면 모든 변수가 삭제됨.   
그러나 지역 변수가 삭제되지 않길 바랄 경우, 추가 작업을 위해 필요.

```
<?php
function myTest() {
  static $x = 0;
  echo $x;
  $x++;
}

myTest();
myTest();
myTest();
?>
```
- 그런 다음 함수가 호출될 때마다 해당 변수에는 마지막으로 함수가 호출된 시점부터 포함된 정보가 계속 유지됨.
- ※참고: 변수는 여전히 함수에 대해 local임.