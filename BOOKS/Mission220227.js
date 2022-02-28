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



---

## Feedback

### 2022.02.28 (월)

다른 학습자(도전자)의 리팩토링 참고하기

**mission1.js**

```jsx
// BAD 더러운 코드 😣
// Hint❕ : 검색하기 쉬운 이름을 사용하세요.
// blastOFF는 로켓 발사를 의미. 86400000은 하루의 밀리초 (milliseconds) 의미. 

// What the heck is 86400000 for?
setTimeout(blastOff, 86400000);

// GOOD 😎
// 위 코드를 깨끗하게 다시 작성해 주세요.
const MAX_MILLISECOND = 1000;
const MAX_SECONDS = 60;
const MAX_MINUTES = 60;
const MAX_HOURS = 24;
const DAY_TO_MILLISECONDS =
    MAX_MILLISECOND * MAX_SECONDS * MAX_MINUTES * MAX_HOURS;

setTimeout(blastOff, DAY_TO_MILLISECONDS);

// 어떻게 고쳤는지, 사례에서 무엇을 배워야 하는지 설명해주세요.
코딩을 하면서 단순 숫자나 문자열은 우리가 이름붙이기에 따라 정말 중요한 내용이 될 수도, 걸림돌이 될 수도 있다.
이 점에서 위의 코드는 주석이 없다면 오해하기 쉬운 코드가 된다.
실제로 주석을 읽지 않고 처음 코드를 봤을때 당연히 초(seconds)라고 생각했지, 밀리초(milliseconds)라고는 생각하지 못했다.
해당 숫자가 밀리초인지, 초인지 주석이 없다면 판단하기 어려우며 주석의 정확성도 검증하기 어렵기 때문에
위의 코드가 남아있을 경우 언젠가 문제가 생길 수 밖에 없는 코드라고 생각된다.
단순 숫자나 문자는 의도를 명확하게 하기 위하여 상수를 사용하는 것이 좋겠다.
```

**mission2.js**

```jsx
// BAD 더러운 코드 😣
// Hint❕ : 의미있는 이름을 사용해주세요.

const yyyymmdstr = moment().format("YYYY/MM/DD");

// GOOD 😎
// 위 코드를 깨끗하게 다시 작성해 주세요.
const currentDate = (formatString = 'YYYY/MM/DD') =>
    moment().format(formatString);

// 어떻게 고쳤는지, 사례에서 무엇을 배워야 하는지 설명해주세요.
의미없는 이름을 현재 날짜를 나타낸다는 변수로 변경하였으며, 조금 더 유연한 사용을 위해 formatString을 사용하는 함수로 변경하였다.
오늘 날짜도 다양한 포맷으로 보여줘야할때가 있는데,
그때마다 변수를 사용하는 것 보다는 포맷형식을 변경할 수 있도록 함수로 만들어서 쓰는게 좋을 것 같다.
+ moment는 꽤 무겁기도 하고 이제 더 이상 신규 개발없이 유지보수만 하는 레거시 프로젝트라서
개인적으로는 dayjs사용을 추천한다.
```

**mission3.js**

```jsx
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
class Car {
    constructor(make, model, color) {
        this.make = make;
        this.model = model;
        this.color = color;
    }

    paint(color) {
        this.color = color;
    }
}
const car = new Car('Honda', 'Accord', 'Blue');
car.paint('red');
console.log(car);

// 어떻게 고쳤는지, 사례에서 무엇을 배워야 하는지 설명해주세요.
// Car라는 개념으로 Car와 paintCar를 묶을 수 있으므로, 해당 코드는 클래스로 표현하는 것이 좋을 것 같다
// Car라는 Object의 속성들은 일반적으로 Car의 속성을 나타낸다고 생각되게 때문에 굳이 car라는 접두어를 사용해서
// 속성을 표현하는 것은 불필요한 반복이라고 생각된다.
```

#노마드코더 #북클럽 #노개북
