//Conditionals : 조건문
//true인지 false인지 알려주므로 중요. 무언가를 확인해야할 때 사용.

//prompt() : 사용자에게 창을 띄울 수 있도록 해준다. <= prompt는 2개의 argument를 받는다. 1) message(문자;string) | 2) default
// const age = prompt("How old are you?"); //오래된 방식 : prompt (간단히 사용, user가 답하기 전까지 실행 stop)
// console.log(prompt);
//typeof() : value의 type을 확인
// console.log(typeof age);

// string을 'number로 변환'; A string to convert into a number.
// console.log(typeof "15", typeof parseInt("15"));
// console.log(age, parseInt(age));

const age = parseInt(prompt("How old are You?"));
console.log(age);


//isNaN() : argument(인자)를 boolean으로 알려줌    | true: 숫자가 아니다. | false: 숫자다.
//          >> user가 보낸 variable이 NaN(Not a Number)인지 아닌지 알려주는.
console.log(isNaN(age));

if(isNaN(age) || age < 0){
  console.log("Please write a positive number.");
} else if (age < 18) {
  console.log("You are too young!");
} else if(age >= 18 && age <= 50){  // or(||) 하나만 true라도 결과는 true.
  console.log("You can drink");
} else if(age > 50 && age <= 80){
  console.log("You should exercise..");
} else if (age === 100){    // === age가 100인가? (!==)
  console.log("Wow. You are wise.");
} else if (age > 80) {
  console.log("You can do whatever you want.");
}
  // } else {
  // console.log("Thank you for writing your age.");
// }

