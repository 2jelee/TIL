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

----------------------------------

<h2>echo / print</h2>
화면에 데이터를 출력하는데 사용.
둘은 차이점 ↓

- echo : 반환값이 없음, 여러 매개변수를 사용할 수 O
- print 반환값이 1이므로 표현식에서 사용 O, print 하나의 인수를 사용할 수 O, echo보다 약간 빠름.

<h3>echo문</h3>
echo문 또는 괄호없이 사용할 수 O
> echo 또는 ehco()

<h4>텍스트 표시</h4>

- 텍스트에 HTML 마크업이 포함될 수 O

```
<?php
echo "<h2>PHP is Fun!</h2>";
echo "Hello world!<br>";
echo "I'm about to learn PHP!<br>";
echo "This ", "string ", "was ", "made ", "with multiple parameters.";
?>
```

<h4>변수 표시</h4>

```
<?php
$txt1 = "Learn PHP";
$txt2 = "W3Schools.com";
$x = 5;
$y = 4;

echo "<h2>" . $txt1 . "</h2>";
echo "Study PHP at " . $txt2 . "<br>";
echo $x + $y;
?>
```

----------------------------------

<h2>Data type</h2>

1. String 
2. Integer
3. Float
4. Boolean
5. Array
6. Object 
7. Null
8. Resource


<h3>String (문자열)</h3>
따옴표 안에 있는 모든 텍스트가 될 수 있다.   
작은따옴표나 큰따옴표를 사용 O

```
<?php
$x = "Hello world!";
$y = 'Hello world!';

echo $x;
echo "<br>";
echo $y;
?>
```

<h3>Integer (정수)</h3>
[규칙]

- 정수에는 하나 이상의 숫자가 있어야 한다.
- 정수에는 소수점이 없어야 한다.
- 정수는 양수 또는 음수일 수 있다.
- 정수는 10진수(base 10), 16진수(base 16), 8진수(base 8) 또는 이진법(base 2) 표기법으로 지정할 수 있습니다.

```
<?php
$x = 5985;
var_dump($x);
?>
```
해당 예시에서 $x는 정수(int)   
PHP var_dump() 함수는 데이터유형과 값을 반환함.

<h3>float</h3>
소숫점이 있는 숫자 or 지수 형식의 숫자   

```
<?php
$x = 10.365;
var_dump($x);
?>
```
해당 예시에서 $x는 float(실수)   
PHP var_dump() 함수는 데이터유형과 값을 반환함.

<h3>boolean</h3>
true 또는 false 두 가지 상태를 나타냄.

```
$x = true;
$y = false;
```
조건부 테스트에 사용됨.

<h3>Array(배열)</h3>
하나의 단일 변수에 여러 값을 저장.   

```
<?php
$cars = array("Volvo","BMW","Toyota");
var_dump($cars);
?>
```

<h3>Object (객체)</h3>
클래스와 객체는 <b>객체 지향 프로그래밍</b>의 2가지 주요 측면임. <br>
클래스 : 객체의 template   
객체 : 클래스의 instance   
<br>
개별 개체가 생성되면 클래스에서 모든 속성과 동작을 상속하나,   
각 객체는 속성에 대해 서로 다른 값을 가진다. <br>
<br>
ex. Car라는 클래스가 있다고 가정.   
Car는 모델, 색상 등과 같은 속성을 가질 수 O. 이러한 속성의 값을 유지하기 위해 $model, $color 등과 같은 변수를 정의할 수 있다.   
개별 개체(현대, 기아, 볼보, BMW 등)가 생성되면 클래스에서 모든 속성과 동작을 상속하지만 각 개체는 속성에 대해 서로 다른 값을 가짐.   
   
__construct() 함수를 생성하면 클래스에서 객체를 생성할 때 PHP가 자동으로 이 함수를 호출함.

```
<?php
class Car {
  public $color;
  public $model;
  public function __construct($color, $model) {
    $this->color = $color;
    $this->model = $model;
  }
  public function message() {
    return "My car is a " . $this->color . " " . $this->model . "!";
  }
}

$myCar = new Car("black", "KIA");
echo $myCar -> message();
echo "<br>";
$myCar = new Car("red", "Volvo");
echo $myCar -> message();
?>
```

<h3>NULL</h3>
Null은 NULL이라는 하나의 값만 가질 수 있는 특수 데이터 유형.   
데이터 유형이 NULL인 변수는 할당된 값이 없는 변수다.   
   
Tip! 값 없이 변수를 생성하면 자동으로 NULL 값이 할당됨.
> 값을 NULL로 설정하여 변수를 비울 수도 있다.

```
<?php
$x = "Hello world!";
$x = null;
var_dump($x);
?>
```

<h3>Resource</h3>
특수 자원 유형은 실제 데이터 유형이 아님. PHP 외부의 기능 및 리소스에 대한 참조를 저장하는 것임.   
자원 데이터 유형을 사용하는 일반적인 예는 database 호출이다.
> 리소스 유형은 고급 주제이므로 skip

----------------------------------

<h2>PHP Numbers</h2>
※주의 : 자동 데이터 유형 변환
따라서 변수에 정수값을 할당하면 해당 변수의 유형은 자동으로 변수가 됨.   
이 다음 동일한 변수에 문자열을 할당하면 유형이 문자열로 변경됨.   

<h3>정수(Integers)</h3>
※참고: 알아야 할 중요한 사항 => 4 * 2.5가 10인 경우에도 피연산자 중 하나가 float(2.5)이기 때문에 결과가 float로 저장됨.   
   
[규칙]

- 정수에는 하나 이상의 숫자가 있어야 함.
- 정수에는 소수점이 없어야 함.
- 정수는 양수 또는 음수일 수 있음.
- 정수는 10진수(10 기반), 16진수(16 기반 - 접두사 0x) 또는 8진(8 기반 - 접두사 0)의 세 가지 형식으로 지정할 수 있음. 
   
[미리 정의된 상수]

- PHP_INT_MAX - 지원되는 가장 큰 정수
- PHP_INT_MIN - 지원되는 가장 작은 정수
- PHP_INT_SIZE - 바이트 단위의 정수 크기

[변수의 유형이 정수인지 확인하는 함수]
- is_int()
- is_integer() - is_int()의 별칭
- is_long() - is_int()의 별칭

```
<?php
$x = 5985;
var_dump(is_int($x));

$x = 59.85;
var_dump(is_int($x));
?>
```

<h3>float</h3>
소수점이 있는 숫자 또는 지수 형식의 숫자   
   
[PHP 7.2부터 사전 정의된 상수]

- PHP_FLOAT_MAX - 표현 가능한 가장 큰 부동 소수점 숫자
- PHP_FLOAT_MIN - 표현 가능한 가장 작은 양의 부동 소수점 숫자
- PHP_FLOAT_MAX - 표현 가능한 가장 작은 음수 부동 소수점 숫자
- PHP_FLOAT_DIG - 정밀도 손실 없이 부동 소수점으로 반올림할 수 있는 소수점 이하 자릿수
- PHP_FLOAT_EPSILON - 표현 가능한 가장 작은 양수 x, x + 1.0 != 1.0

[변수 유형이 float인지 확인하는 함수]
- is_float()
- is_double() - is_float()의 별칭

```
<?php
$x = 10.365;
var_dump(is_float($x));
?>
```

<h3>Infinity</h3>
PHP_FLOAT_MAX보다 큰 숫자 값은 무한으로 간주   
   
[숫자값이 유한인지 무한인지 확인하는 기능]

- is_finite()
- is_infinite()

```
<?php
$x = 1.9e411;
var_dump($x);
?>
```

<h3>NaN</h3>
숫자가 아님을 나타냄.   
불가능한 수학 연산에 사용됨.
   
[값이 숫자가 아닌지 확인하는 기능]
- is_nan()

```
<?php
$x = acos(8);
var_dump($x);
?>
```
> 잘못된 계산은 NaN 값을 반환   

<h3>Numerical Strings</h3>
is_numeric() : 변수가 숫자인지 여부를 찾는 데 사용   
> 이 함수는 변수가 숫자 또는 숫자 문자열이면 true를 반환하고 그렇지 않으면 false를 반환 

```
<?php
$x = 5985;
var_dump(is_numeric($x));

$x = "5985";
var_dump(is_numeric($x));

$x = "59.85" + 100;
var_dump(is_numeric($x));

$x = "Hello";
var_dump(is_numeric($x));
?>
```

<h3>형변환 (Casting)</h3>
> Casting Strings and Floats to Integers
숫자값을 다른 데이터 유형으로 변환해야할 경우,   
(int), (integer) 또는 intval() 함수는 값을 정수로 변환하는데 사용

```
<?php
// Cast float to int
$x = 23465.768;
$int_cast = (int)$x;
echo $int_cast;

echo "<br>";

// Cast string to int
$x = "23465.768";
$int_cast = (int)$x;
echo $int_cast;
?>
```

----------------------------------

<h2>Math</h2>
[Math 함수]

- pi
- min, max
- abs
- sqrt
- round
- 난수

<h3>pi()</h3>
기능 : PI의 값을 반환

```
<?php
echo(pi()); // returns 3.1415926535898
?>
```

<h3>min(), max()</h3>
인수에서 가장 작거나 큰 값을 찾을 때 사용

```
<?php
echo(min(0, 150, 30, 20, -8, -200));  // returns -200
echo(max(0, 150, 30, 20, -8, -200));  // returns 150
?>
```

<h3>abs()</h3>
절대값(양)을 반환

```
<?php
echo(abs(-6.7));  // returns 6.7
?>
```

<h3>sqrt()</h3>
숫자의 제곱근을 반환

```
<?php
echo(sqrt(64));  // returns 8
?>
```

<h3>round()</h3>
부동 소수점 숫자를 가장 가까운 정수로 반올림

```
<?php
echo(round(0.60));  // returns 1
echo(round(0.49));  // returns 0
?>
```

<h3>난수</h3>
난수를 생성

```
<?php
echo(rand());
?>
```

- 난수 control : 최소, 및 최대 매개변수를 추가하여 반환할 가장 낮은 정수와 높은 정수를 지정할 수 O
ex) 10에서 100(포함) 사이의 임의의 정수를 원할 경우

```
<?php
echo(rand(10, 100));
?>
```

-----------------------------------

<h2>Constants (상수)</h2>
상수는 일단 정의되면 변경하거나 해제할 수 없다는 점을 제외하고는 변수와 동일

<h3>상수</h3>
상수는 단순 값의 식별자(이름)이다. 스크립트 중에는 값을 변경할 수 X   
유효한 상수 이름은 문자 또는 밑줄로 시작(상수 이름 앞에 $ 기호 없음).   
※참고: 변수와 달리 상수는 전체 스크립트에서 자동으로 전역(global)임

<h3>상수 생성</h3>
define() 함수 사용   
   
Syntax(문법)
```
define(name, value, case-insensitive)
```

매개변수 :

- name : 상수의 이름을 지정
- value : 상수의 값을 지정
- 대소문자 구분 : 상수 이름이 대소문자를 구분하지 않아야 하는지 여부를 지정합니다. 기본값은 false.


1) 대소문자를 구분하는 이름으로 상수를 생성

```
<?php
define("GREETING", "Welcome to 2jelee's github!");
echo GREETING;
?>
```

2) 대소문자를 구분하지 않는 이름으로 상수를 생성

```
<?php
define("GREETING", "Welcome to 2jelee's github!", true);
echo greeting;
?>
```

<h3>상수 배열</h3>
PHP7에서 define() 함수를 사용하여 배열 상수를 생성할 수 있음.

```
<?php
define("cars", [
  "KIA",
  "BMW",
  "Toyota"
]);
echo cars[0];
?>
```

<h3>상수는 전역(global)</h3>
상수는 자동으로 전역적, 전체 스크립트에서 사용 가능

ex) 함수 외부에서 정의된 경우에도 함수 내부에서 상수를 사용

```
<?php
define("GREETING", "Welcome to 2jelee's github!");

function myTest() {
  echo GREETING;
}
 
myTest();
?>
```

-----------------------------------------

<h2>Operators(연산자)</h2>
연산자 : 변수와 값에 대한 연산을 수행하는데 사용됨   
   
PHP 연산자

- 산술 연산자
- 할당 연산자
- 비교 연산자
- 증가/감소 연산자
- 논리 연산자
- 문자열 연산자
- 배열 연산자
- 조건부 할당 연산자

<h3>산술 연산자</h3>
더하기, 빼기, 곱하기 등과 같은 일반적인 산술 연산을 수행하기 위해 숫자 값과 함께 사용

> 연산자 (+) : $x + $y
> 연산자 (-) : $x - $y
> 연산자 (*) : $x * $y
> 연산자 (/) : $x / $y
> 연산자 (%) : $x % $y
> 연산자 (**) : $x ** $y

<h3>할당 연산자</h3>
숫자값과 함께 변수에 값을 쓰는데 사용됨   
기본 할당 연산자 : "="   
> 이는 왼쪽 피연산자가 오른쪽 할당 표현식의 값으로 설정됨을 의미   
   
> x = y 는 x = y와 같다.
> x += y 는 x = x + y와 같다.
> x -= y 는 x = x - y와 같다.
> x *= y 는 x = x * y와 같다.
> x /= y 는 x = x / y와 같다.
> x %= y 는 x = x % y와 같다.

<h3>비교 연산자</h3>
두 값(숫자 또는 문자열)을 비교하는데 사용   

> == : equal
> === : identical
> != : not equal
> <> : not equal
> !== : not identical
> > : greater than
> < : less than
> >= : greater than or equal to
> <= : less than or equal to
> <=> : spaceship

<h3>증가/감소 연산자</h3>
증가 연산자 : 변수 값을 증가시키는데 사용   
감소 연산자 : 변수 값을 감소시키는데 사용   
   
> ++$x : Pre-increment
> $x++ : Post-increment
> --$x : Pre-decrement
> $x-- : Post-decrement

<h3>논리 연산자</h3>
조건문을 결합하는데 사용   
   
> and : And
> or : OR
> xor : Xor
> && : And
> || : Or
> ! : Not

<h3>배열 연산자</h3>
배열을 비교하는데 사용   
   
> + : 결합(Union)
> == : Equality
> === : Identity
> != : Inequality
> <> : Inequality
> !== : Non-identity

<h3>조건부 할당 연산자</h3>
조건에 따라 값을 설정하는데 사용   
   
> ?: : Ternary
> ?? : Null coalescing

-----------------------------------------

<h2>if...else...elseif Statements</h2>
조건문 : 다른 조건에 따라 다른 작업을 수행하는데 사용

<h3>종류</h3>

- if 명령문 : 하나의 조건이 참이면 일부 코드를 실행
- if ... else 명령문 : 조건이 참이면 일부 코드를 실행, 해당 조건이 거짓이면 다른 코드를 실행
- if ... elseif ... else 명령문 : 두 개 이상의 조건에 대해 다른 코드를 실행
- switch statement : 실행할 많은 코드 블록 중 하나를 선택

<h4>if문</h4>
하나의 조건에 해당하는 경우, 몇가지 코드를 실행

Syntax

```
if (condition) {
  code to be executed if condition is true;
}
```  

ex) "Have a good day!" 출력. 현재 시간(hour)이 20보다 작은 경우

```
<?php
$t = date("H");

if ($t < "20") {
  echo "Have a good day!";
}
?>
```

<h4>if ... else 문</h4>
if...else 명령문은 조건이 참이면 해당 코드를 실행하고 해당 조건이 거짓이면 다른 코드를 실행

Syntax

```
if (condition) {
  code to be executed if condition is true;
} else {
  code to be executed if condition is false;
}
```

ex) "Have a good day!" 출력. 현재 시간이 20시 미만이면 "좋은 밤 되세요!"

```
<?php
$t = date("H");

if ($t < "20") {
  echo "Have a good day!";
} else {
  echo "Have a good night!";
}
?>
```

<h4>if ... elseif ... else 문</h4>
두 개 이상의 조건에 대해 서로 다른 코드를 실행

Syntax

```
if (condition) {
  code to be executed if this condition is true;
} elseif (condition) {
  code to be executed if first condition is false and this condition is true;
} else {
  code to be executed if all conditions are false;
}
```

ex) "Have a good day!" 출력. 현재 시간이 10시 미만이면 "Have a good day!" 현재 시간이 20보다 작으면 "Have good night!"이 출력

```
<?php
$t = date("H");

if ($t < "10") {
  echo "Have a good morning!";
} elseif ($t < "20") {
  echo "Have a good day!";
} else {
  echo "Have a good night!";
}
?>
```

-----------------------------------------

<h2>Switch문</h2>
다른 조건에 따라 다른 작업을 수행하는데 사용   
   
Syntax

```
switch (n) {
  case label1:
    code to be executed if n=label1;
    break;
  case label2:
    code to be executed if n=label2;
    break;
  case label3:
    code to be executed if n=label3;
    break;
    ...
  default:
    code to be executed if n is different from all labels;
}
```

[동작방식]   
먼저 한 번 평가 되는 단일 표현식 n(대부분 변수)이 존재.   
그러한 다음 표현식의 값을 구조의 각 케이스에 대한 값과 비교.    
일치하는 항목이 있으면 해당 사례와 관련된 코드 블록이 실행.   
break 코드가 자동으로 다음 케이스로 실행되는 것을 방지하기 위해 사용.   
default 일치하는 항목이 없는 경우 사용됨.

ex)
```
<?php
$favcolor = "red";

switch ($favcolor) {
  case "red":
    echo "Your favorite color is red!";
    break;
  case "blue":
    echo "Your favorite color is blue!";
    break;
  case "green":
    echo "Your favorite color is green!";
    break;
  default:
    echo "Your favorite color is neither red, blue, nor green!";
}
?>
```

--------------------------------

<h2>Loops</h2>
루프는 특정 조건이 참인 동일한 코드 블록을 반복해서 실행하는 데 사용   
   
[종류]

- While Loop
- Do While Loop
- For Loop
- Foreach Loop
- Break / Continue

<h3>while</h3>
지정된 조건이 <b>참</b>인 동안 코드 블록을 반복   
while루프 길이 지정된 조건에 해당하는만큼의 코드 블록을 실행   

Syntax

```
while (condition is true) {
  code to be executed;
}
```

ex)

```
<?php
$x = 1;

while($x <= 5) {
  echo "The number is: $x <br>";
  $x++;
}
?>
```

- 1에서 5까지의 숫자를 표시

<h3>do ... while</h3>
코드 블록을 한 번 루프한 다음 지정된 조건이 참인 동안 루프를 반복   
do...while 루프는 항상 한 번 코드 블록을 실행함. 지정된 조건이 true 동안 다음 루프 상태를 확인하고 반복   
   
Syntax

```
do {
  code to be executed;
} while (condition is true);
```

<h3>for</h3>
지정된 횟수만큼 코드 블록을 반복   
스크립트가 실행해야하는 횟수를 미리 알고있을 때 루프가 사용   
   
Syntax

```
for (init counter; test counter; increment counter) {
  code to be executed for each iteration;
}
```

[Parameters(매개변수)]

- init counter : 루프 카운터 값 초기화
- test counter : 각 루프 반복에 대해 평가. TRUE로 평가되면 루프가 계속됨. FALSE로 평가되면 루프가 종료.
- increment counter : 루프 카운터 값을 증가시킵


<h3>foreach</h3>
배열의 각 요소에 대한 코드 블록을 순환   
작동 배열 및 배열의 각각의 키 / 값 쌍을 루프에 사용된다.   
   
Syntax

```
foreach ($array as $value) {
  code to be executed;
}
```

- 모든 루프 반복에 대해 현재 배열 요소의 값이 $value에 할당되고 배열 포인터가 마지막 배열 요소에 도달할 때까지 1만큼 이동

ex)

```
<?php
$colors = array("red", "green", "blue", "yellow");

foreach ($colors as $value) {
  echo "$value <br>";
}
?>
```

result

```
red
green
blue
yellow
```

<h3>Break / Continue</h3>
break 명령문 : 루프를 벗어나는 데 사용할 수 있다.   

```
<?php
for ($x = 0; $x < 10; $x++) {
  if ($x == 4) {
    break;
  }
  echo "The number is: $x <br>";
}
?>
```

- 예제는 x 가 4일 때 루프에서 빠져나옴

continue : 지정된 조건이 발생하고있는 경우, (루프)에 문을 중단 한 반복 루프의 다음 반복을 계속

```
<?php
for ($x = 0; $x < 10; $x++) {
  if ($x == 4) {
    continue;
  }
  echo "The number is: $x <br>";
}
?>
```

- 해당 예제는 4 값을 건너뜀

[While Loop에서 break하고 continue]   
break 예제

```
<?php
$x = 0;

while($x < 10) {
  if ($x == 4) {
    break;
  }
  echo "The number is: $x <br>";
  $x++;
}
?>
```

continue 예제

```
<?php
$x = 0;

while($x < 10) {
  if ($x == 4) {
    $x++;
    continue;
  }
  echo "The number is: $x <br>";
  $x++;
}
?>
```

-----------------------------------------

<h2>Functions</h2>
사용자 정의 함수 선언

```
function functionName() {
  code to be executed;
}
```

- 참고 : 함수 이름은 문자 또는 밑줄로 시작해야 한다. 함수 이름은 대소문자를 구분 X

ex)

```
<?php
function writeMsg() {
  echo "Hello world!";
}

writeMsg(); // call the function
?>
```

<h3>Function Arguments (인자)</h3>
정보는 인수를 통해 함수에 전달할 수 있다. 인수는 변수와 같다.   
인수는 함수 이름 뒤에 괄호 안에 지정됨. 원하는 만큼 인수를 추가할 수 있으며 쉼표로 구분하면 됨.   
다음 예에는 하나의 인수($fname)가 있는 함수가 있다. familyName() 함수가 호출되면 이름(예: Jani)도 전달하고 이름은 함수 내부에서 사용되며 여러 다른 이름을 출력하지만 성은 동일.

```
<?php
function familyName($fname) {
  echo "$fname Refsnes.<br>";
}

familyName("Jani");
familyName("Hege");
familyName("Stale");
familyName("Kai Jim"); 
?>
```

result

```
Jani Refsnes.
Hege Refsnes.
Stale Refsnes.
Kai Jim Refsnes. 
```

ex) 2개의 인자(Argu)

```
<?php
function familyName($fname, $year) {
  echo "$fname Refsnes. Born in $year <br>";
}

familyName("Hege", "1975");
familyName("Stale", "1978");
familyName("Kai Jim", "1983");
?>
```

result

```
Hege Refsnes. Born in 1975
Stale Refsnes. Born in 1978
Kai Jim Refsnes. Born in 1983
```

<h3>PHP is a Loosely Typed Language</h3>
변수가 어떠한 데이터 유형인지 php에 알릴 필요 X   
> PHP는 값에 따라 데이터 유형을 변수에 자동으로 연결함. 데이터 유형이 엄격하게 설정되지 않으므로 오류없이 문자열을 추가하는 등의 작업이 가능
> PHP 7의 경우 유형 선언이 추가됨 : 함수 선언 시 예상되는 데이터 유형을 지정할 수 있는 옵션이 제공되며 strict 선언을 추가 → 데이터 유형이 일치하지 않으면 <b>치명적인 오류 발생!</b>

```
<?php
function addNumbers(int $a, int $b) {
  return $a + $b;
}
echo addNumbers(5, "5 days");
// since strict is NOT enabled "5 days" is changed to int(5), and it will return 10
?>
```

result

```
10
```

- 지정하려면 strict를 설정해야함. declare(strict_types=1);. 이는 PHP 파일의 맨 처음 줄에 있어야 한다.

이하 예제의 경우 숫자와 문자열을 모두 함수에 내보내려 하나, strict 선언을 추가했음

```
<?php declare(strict_types=1); // strict requirement

function addNumbers(int $a, int $b) {
  return $a + $b;
}
echo addNumbers(5, "5 days");
// since strict is enabled and "5 days" is not an integer, an error will be thrown
?>
```

- strict 선언 : 의도 된 방식으로 사용

<h3>기본 인자값</h3>
인수 없이 setHeight() 함수를 호출하면 기본값을 인수로 사용

```
<?php declare(strict_types=1); // strict requirement
function setHeight(int $minheight = 50) {
  echo "The height is : $minheight <br>";
}

setHeight(350);
setHeight(); // will use the default value of 50
setHeight(135);
setHeight(80);
?>
```

<h3>값 반환</h3>
함수가 값을 반환하도록 하려면 다음 return명령문을 사용

```
<?php declare(strict_types=1); // strict requirement
function sum(int $x, int $y) {
  $z = $x + $y;
  return $z;
}

echo "5 + 10 = " . sum(5, 10) . "<br>";
echo "7 + 13 = " . sum(7, 13) . "<br>";
echo "2 + 4 = " . sum(2, 4);
?>
```

result

```
5 + 10 = 15
7 + 13 = 20
2 + 4 = 6
```

<h3>return(반환) 유형 선언</h3>
PHP7의 경우, return문에 대한 유형 선언도 지원.   
함수 인자에 대한 형식 선언과 마찬가지로 엄격한 요구 사항을 활성화하면 형식 불일치에 대해 <b>치명적인 오류 발생</b>.   
함수 반환에 : 대한 유형을 { 선언하려면 함수를 선언할 때 여는 중괄호() 바로 앞에 콜론()과 유형을 추가.

ex) 함수의 반환 유형을 지정

```
<?php declare(strict_types=1); // strict requirement
function addNumbers(float $a, float $b) : float {
  return $a + $b;
}
echo addNumbers(1.2, 5.2);
?>
```

result

```
6.4
```

- 인자 유형과 다른 반환 유형을 지정할 수 있으나 반환 유형이 올바른지 확인해야함!

```
<?php declare(strict_types=1); // strict requirement
function addNumbers(float $a, float $b) : int {
  return (int)($a + $b);
}
echo addNumbers(1.2, 5.2);
?>
```

result

```
6
```

<h3>참조로 인자 전달</h3>
인수는 일반적으로 값으로 전달됨. 즉, 값의 복사본이 함수에서 사용되며 함수에 전달된 변수는 변경 X   
함수 인자가 참조로 전달되어 인자를 변경하면 전달된 변수 또한 변겅됨.   
함수 인수를 참조로 전환하기 위해 & 연산자가 사용됨.

ex) 참조로 전달 인수를 사용하여 변수를 업데이트

```
<?php
function add_five(&$value) {
  $value += 5;
}

$num = 2;
add_five($num);
echo $num;
?>
```

-----------------------------------------