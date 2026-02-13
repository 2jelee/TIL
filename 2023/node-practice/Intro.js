// Extension(JS_ES6 code snippets)을 이용한 JS code 자동완성
for (let index = 0; index < array.length; index++) {
    const element = array[index];
    
}

//함수 선언식
function name(params) {
    return "Hello" + params;
}
//함수 표현식
const name2 = function (params) {
    return "Hello2" + params;
}

//Arrow function 1.
const name3 = (params) => {return "Hello3" + params};
//Arrow function 2.
//파라미터가 하나만 있을 때는 주변 괄호를 생략 O
const name4 = params => {return "Hello4" + params};
//Arrow function 3.
//화살표 함수의 유일한 문장이 return일 때 return과 중괄호({}) 생략 O
const name5 = params => "Hello5" + params; 

//Array 내장 함수
//1. sort
let fruits = ["Banana", "Orange", "Apple", "Mango"];
fruits.sort();

let points = [40, 100, 1, 5, 25, 10];
points.sort(function (a, b) {
    return a - b;
});
//결과 : points의 첫 번째와 두 번째 요소를 비교(40 - 100). -60이므로 음수. 결과가 음수이므로 두 요소의 위치를 바꾸지 X
// [40, 100, 1, 5, 25, 10]