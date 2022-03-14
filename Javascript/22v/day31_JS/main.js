// HTML 요소(element) 1개 검색 및 찾기

const boxEl = document.querySelector('.box');

console.log(boxEl);

// HTML 요소에 적용할 수 있는 메소드
// boxEl.addEventListener();

//인수(arguments) 추가 가능
boxEl.addEventListener('click', function(){
  alert('Be clicked');
  
  boxEl.classList.add('active');
  console.log(boxEl.classList.contains('active'));

  // boxEl.classList.remove('active');
  // console.log(boxEl.classList.contains('active'));
});

const boxEls = document.querySelectorAll('.box');
console.log(boxEls);

//찾은 요소를 반복해서 함수 실행
boxEls.forEach(function (boxEl, index) { //익명함수 선언
  boxEl.classList.add(`order-${index +1}`);
  console.log(index, boxEl);
});

console.log("==============값 얻어오기 및 세팅==============");

const bxEl = document.querySelector('.box');
console.log(bxEl.textContent);
bxEl.textContent = 'Coffee';
console.log(bxEl.textContent);

console.log("==============메서드 사용하기==============");
// split : 문자를 인수 기준으로 쪼개서 배열로 반환
// reverse : 배열을 뒤집기
// join : 배열을 인수 기준으로 문자로 병합하여 반환

const a = 'Hello';
const b = a.split('');

console.log(a);
console.log(b);

const c = a.split('').reverse().join(); //메소드 chainning

console.log(c);