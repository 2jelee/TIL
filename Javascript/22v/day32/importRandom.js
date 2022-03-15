import random from "./exportRandom.js";
//getRandom.을 가져오는데 random이라는 이름을 사용하겠다.

const kbs = random();

console.log(kbs);

if(kbs === 0){
  console.log('a is 0');
}

console.log("-----------------------");

for (let i = 0; i < 3; i+=1) {
  console.log(i);  
}

console.log("-----------------------");

const ulEl = document.querySelector('ul');

for (let i = 0; i < 3; i+=1) {
  // /console.log(i);  
  const li = document.createElement('li');
  li.textContent = `list-${i + 1}`
  ulEl.appendChild(li)
}
