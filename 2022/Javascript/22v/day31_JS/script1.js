/*
var vs let
1) 선언단계 : 변수 객체에 등록
2) 초기화 단계 : 메모리에 할당 <- undefined로 초기화 된다.
3) 할당 단계 : undefined로 초기화 된 변수에 값 할당함

var 변수는 선언단게 & 초기화 단계가 동시에 이루어진다.
*/

/*
compile 순서 : 상 -> 위
hoisting : 아래 선언되어 있는 것을 위로 끌어올리는 상태 (var 해당 <-> let, const 해당 X)

변수 범위(scope)
1. let, const 변수는 블록 레벨 스코프 { }, 중복 선언 X
2. var : 함수 레벨 스코프임.
         블록 내부에 선언되어도 외부 접근 가능함. 중복 선언 O

let은 브라우저의 특성을 탄다.
*/

// var name = 'hi';
/*
let name;
console.log(name);
*/

const hello = ['hello'];   //배열로 선언
var hello2 = '안녕하세요2';

function sayHello() {
  let name = 'abc';
  return name;
}

let name = '2jelee';
console.log(sayHello());
console.log(hello);
console.log(hello2);

let x = 9;
const y = 7;

console.log(x);
console.log(y);

x=888;
y=999;