let fruits = ['Apple', 'Banana', 'Cherry'];

console.log(fruits[0]);
console.log(fruits[1]);
console.log(fruits[2]);
console.log(fruits); //배열 전체 출력하기 + 정보까지 출력된다.

console.log('---------------------');

//월요일이므로 1이 출력된다. (일요일: 0)
console.log(new Date('2022-03-13').getDay()); //0 -일요일
console.log(new Date('2022-03-14').getDay()); //1 -월요일
console.log(new Date('2022-03-15').getDay()); //2
console.log(new Date('2022-03-18').getDay()); //5 -금요일
