console.log(123);

// let message = prompt("이름을 입력하시오.", "");
let message = prompt("숫자를 입력하시오.", "");
document.write(message);
console.log(message);

// ★★★ eval() : 문자열을 수식(숫자)으로 바꾼다.
let plus = eval(message)+100;
console.log(plus);

// isNan() : 전달받은 값이 숫자인지 문자인지 판별하여 숫자가 아닌 경우 true 반환


function myFunction() {
  // window.open(문서명, 창 이름, 옵션 설정);
  window.open("ex18_js.html", "새 창", "width=300, height=150");
}

/*******************************************************************/

// typeof : 입력받은 값의 타입을 확인
let su = 12345;
console.log(typeof'Hello World');
console.log(typeof su);

console.log(typeof null); //결과 : object
console.log(typeof {});   //결과 : object
console.log(typeof []);   //결과 : object

function getType(data) {
  return Object.prototype.toString.call(data).slice(8, -1);
}

console.log(getType(false)); //결과 : boolean
console.log(getType(123)); //결과 : Number
console.log(getType({}));  //결과 : Oject
console.log(getType([]));  //결과 : 배열

/*******************************************************************/

function myNum() {
  let z = "30"; //string
  let x = 100, y = 200;
  let hap = eval("x+y");

  alert(x+" = "+y+" = "+hap);
  
  // let num2 = eval("2 + 5");
  // let su2 = eval("x+50");
  // let su3 = 3+5;
  // let su4 = eval(8);

  // alert(num+", "+num2+", "+su2+", "+su3+", "+su4);

  var result = su + su2;
  document.getElementById('demo').innerHTML = result;

  let willEval = "";
  willEval += 'var number = 10; <br/>';
  willEval += 'alert(number);';
}