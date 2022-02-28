// mission1.js
// BAD 더러운 코드 😣
// Hint❕ : 검색하기 쉬운 이름을 사용하세요.
// blastOFF는 로켓 발사를 의미. 86400000은 하루의 밀리초 (milliseconds) 의미. 

// What the heck is 86400000 for?
setTimeout(blastOff, 86400000);

// GOOD 😎
// 위 코드를 깨끗하게 다시 작성해 주세요.

// 작성 1.
const int MILLISECONDS_DAY = 86400000;
setTimeout(blastOff, MILLISECONDS_DAY);

// 작성 2.
int Day = 1000;
const int MILLISECONDS_PER_DAY = 86400;
setTimeout(blastOff, Day*MILLISECONDS_PER_DAY);


// 어떻게 고쳤는지, 사례에서 무엇을 배워야 하는지 설명해주세요.
/*
[어떻게 고쳤는가?]
BAD 코드에서는 setTimeout에서 2번째 인자로 86400000을 두었다.
이는 다른 개발자가 코드를 분석할 때 막연한 숫자일 것이다.
검색하기 쉽게, 그리고 이름을 의미있게 짓기 위해 '작성 1' 코드는 86400000라는 숫자의 의미인 하루의 밀리초를 나타내기 위해 상수로 선언하여 MILLISECONDS_DAY 이름을 붙였다.
MILLISECONDS_PER_DAY로 이름을 붙일까 고민하다가 하루는 86,400초이므로 86,400,000라는 숫자는 맞지 않을 것이라 판단했다.
따라서 '작성 2' 코드에서 MILLISECONDS_PER_DAY라고 이름을 짓고 Day를 1000으로 하여 setTimeout에서 둘을 곱하였다.

[사례에서 무엇을 배워야 하는가?]
1. 문자 하나를 사용하는 이름과 상수는 쉽게 눈에 띄지 않는다는 문제점이 있다.
2. 검색하기 쉬운 이름이 붙이는 것이 좋다.
*/

/***********************************************************/
  
// mission2.js
// BAD 더러운 코드 😣
// Hint❕ : 의미있는 이름을 사용해주세요.

const yyyymmdstr = moment().format("YYYY/MM/DD");

// GOOD 😎
// 위 코드를 깨끗하게 다시 작성해 주세요.
const DateFormat = moment().format("YYYY/MM/DD");

// 어떻게 고쳤는지, 사례에서 무엇을 배워야 하는지 설명해주세요.
/*
[어떻게 고쳤는가?]
대충 해당 변수가 어떤 것을 의미하는지 코드를 읽을줄 아는 사람들이라면 알 것이다.
하지만 이는 일관적이지 않고 의미있는 코드가 아니다.
format 메서드를 사용함으로써 이는 원하는 형태(현 코드에서는 "날짜/월/일")으로 출력하기 위한 것이므로
DateFormat이라는 이름을 지었다.

[사례에서 무엇을 배워야 하는가?]
나중에 해당 코드를 호출하기 위해 아마 해당 선언문을 찾아야할 것이다.
자신의 기억력을 맹신하지도, 자랑하지도 말고 의미있게 부여하여
다른 사람들로 하여금 코드이름만 봐도 바로 알 수 있게 이름을 지어주자.
*/

/***********************************************************/
  
// mission3.js
// BAD 더러운 코드 😣
// Hint❕ : 불필요하게 반복하지 마세요.

const Car = {
  carMake: "Honda",
  carModel: "Accord",
  carColor: "Blue"
};

function paintCar(car, color) {
  car.carColor = color;
}

// GOOD 😎
// 위 코드를 깨끗하게 다시 작성해 주세요.
const Car = {
  make: "Honda",
  model: "Accord",
  color: "Blue"
};

function paintCar(car, color){
  car.color = color;
}

// 어떻게 고쳤는지, 사례에서 무엇을 배워야 하는지 설명해주세요.
/*
[어떻게 고쳤는가?]
Bad code를 살펴보면 Car라는 객체 안에서 carMake, carModel, carColor 이처럼 같은 car-라는 접두어를 반복하고 있다.
나는 이를 불필요하게 반복한다고 여겨 접두어(car-)를 삭제했다.
또한, paintCar라는 함수에서 car.carColor = color를 사용하므로 이또한 바꿔주었다.

[사례에서 무엇을 배워야 하는가?]
의미 있는 맥락을 추가 하는 것은 클래스, 함수, 이름 공간에 넣어 맥락을 부여한다.
모든 방법이 실패하면 마지막 수단으로 접두어를 붙이는 것이다.
접두어를 추가하면 맥락이 좀 더 분명해지는데 해당 객체 내 요소들은 스스로 의미가 분명하다고 판단했다.
불필요하게 반복하지 말자.
*/
