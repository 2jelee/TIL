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

</body>
</html>