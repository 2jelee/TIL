// String 타입
let myName = '2jelee';
let email = '2ttobokk@gmail.com';
// let comb = '안녕, '+myName+"!";
let comb = `반가워, ${myName}야~`;

console.log(comb);

console.log('-----------------');

// Number 타입
let number = 350;
let opacity = 1.57;

console.log(number);
console.log(opacity);

console.log('-----------------');

// boolean 타입
checked = true; // 이처럼 let, const 선언하지 않으면 var로 인식한다. 그러므로 명식적으로 해주자!
isShow = false;

console.log(checked);
console.log(isShow);

console.log('-----------------');

// Undefined : 값이 할당되지 않은 상태를 나타낸다.
let undef;
let obj = {age: 26};

console.log(undef);
console.log(obj); // obj : 객체 << key, value로 이루어져 있다.

console.log('-----------------');

// Object : 객체 데이터
// 여러 데이터를 KEY : VALUE 형태로 저장
let user = {
  name: 'eun',
  age: 26,
  isValue: true
}
console.log(user.name);
console.log(user.isValue);
console.log(user.age);

console.log('-----------------');

// Array : 배열 데이터
// 여러 데이터를 순차적으로 저장. []_대괄호로 처리
let fruits = ['Apple', 'Banana', 'Cherry'];

console.log(fruits[0]);
console.log(fruits[1]);
console.log(fruits[2]);
console.log(fruits); //배열 전체 출력하기 + 정보까지 출력된다.


console.log('---------------------');

/* with 사용 */
with(user){
  console.log(name);
  console.log(age);
}