// 모든 것은 데이터 타입으로부터 시작
// 데이터 타입 : JS가 이해할 수 있는 데이터의 종류들


// 과제
const calculator = {
  add: function(a, b){
    // alert(a + b);
  },
  minus: function(a, b){
    // alert(a - b);
  },
  divide: function(a, b){
    // alert(a / b);
  },
  power: function(a, b){
    // alert(a ** b);
  }
};

calculator.add(1, 1);
calculator.minus(1, 1);
calculator.divide(1, 1);
calculator.power(1, 1);


// [Returns] 예제 1
const age = 20;
function calculatorKrAge(ageOfForeigner){   //2. function calculatorKrAge(20){
  return ageOfForeigner + 2;                //3. 22
}

const krAge = calculatorKrAge(age);   //1. const krAge = calculatorkrAge(20);   +   4. const krAge = 22;

console.log(krAge);

// return >> 누군가가 fucntion을 실행할 때 1번의 calculatorKrAge(age);를 
// return줄의 ageOfForeigner로 대체한 것.


// [Returns] 예제 2
const age2 = 20;
function calculatorKrAge2(ageOfForeigner2){   //2. function calculatorKrAge2(20){
  ageOfForeigner2 + 2;                        //3. 22
  return "hello";
}

const krAge2 = calculatorKrAge2(age2);   //1. const krAge2 = calculatorkrAge2(20);   +   4. const krAge2 = "hello";

console.log(krAge2);




// 위 과제를 return으로 변환(작업) ▶ function내부에서 console.log 하는 것과 return하는 것은 큰 차이가 있다.
const calculator2 = {
  add: function(a, b){
    return a + b;
  },
  minus: function(a, b){
    return a - b;
  },
  divide: function(a, b){
    return a / b;
  },
  power: function(a, b){
    return a ** b;
  }
};

const plusResult = calculator2.add(2, 3);                    // 5
// console.log(plusResult);
const minusResult = calculator2.minus(plusResult, 10);       // -5
const divResult = calculator2.divide(10, minusResult);       // -2
const powResult = calculator2.power(divResult, minusResult); // 0.03125

// [return 중요 개념]
// 한번 return하면 function은 끝난다. => 리턴하는 순간 func이 종료됨
// return을 하면 function은 작동을 멈추고 결과값을 return하고 끝나버린다.
