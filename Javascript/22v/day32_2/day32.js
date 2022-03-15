import random from './getRandom.js';

const ulEl = document.querySelector('ul');

for(let i=0; i<3; i+=1){
  //console.log(i);
  const li = document.createElement('li'); // 태그값을 생성한다
  li.textContent = `사과-${i+1}`//백킹: 문자열과 
  ulEl.appendChild(li);
}

console.log('=================');
const kbs = random();

console.log(kbs);

if(kbs === 0){
  console.log('kbs is 0');
}else if(kbs === 2){
  console.log('kbs is 2');
}else{
  console.log('rest...');
}
