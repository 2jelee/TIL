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