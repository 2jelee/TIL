// 변수의 유효범위 - var, let, const
/*
var : 블럭 단위(함수 레벨) -> {}를 벗어나면 X
let : 함수 단위 -> 함수 안에서 {} 범위 벗어나도 O?
*/
// 함수 정의
function scope(params) {
  if(true){
    let a = 123
    console.log(a);
  }
}

//함수 호출
scope();

/************************************* */

const b = 1;
const c = '1';

console.log(b==c); //true

/************************************* */

// 형 변환(Type Conversion)
// Truthy : 참하고 같은 값
// true, {}, [], 1, 2, 'false', -12, '12.34', ...

// Falsy : 거짓하고 같은 값
// false, '', null, undefined, 0, -0, NaN

function sum(x, y) {
  console.log(x+y);
}

sum(10, 2);

function plus(x, y) {
  return x+y;
}

// argument가 없는 상황
function sub() {
  console.log(arguments);
  return arguments[0]
}

sub(7, 3); //함수 호출할 때 argument를 추가해주면 Arguments(2)가 존재하게 된다.

