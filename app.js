// const title = document.getElementById("title");

// console.dir >> element를 더 자세하게 보여줌.
// console.dir(title);

// title.innerText = "Got you"

// console.log(title.id);
// console.log(title.className);

// .getElementsByTagName >> 모든 <h1> 가져오기
// const title2 = document.getElementsByTagName("h1");

// console.log(title2); // title object 자체가 아니고 array인 상태

//getElementsByClassName("hello"); << className은 html의 class의 이름과 같아야 한다.


// [querySelector & querySelectorALL]
// querySelector : element를 CSS방식으로 검색 (CSS selector를 사용하여 검색 가능)
// 즉, hello라는 class 내부에 있는 <h1>을 가지고 올 수 있다는 것을 의미.

//querySelector는 단 하나의 element를 return 해준다.
// 단하나만 가져오므로 여러개가 있을 경우 가장 첫번째 것만 가져온다.
// const title = document.querySelector(".hello h1");
// const title = document.querySelector("div h1"); >> 위 코드와 같은 결과
// const title = document.querySelector(".hello h1:first-child");

// querySelector에는 hello가 class name이라는 것과 그 안의 h1(태그)을 명시해주어야 한다.

// querySelectorAll은 이 selector 안의 조건에 부합하는 "모든(All)" element를 가져온다.
// >> array를 반환해주는 querySelectorAll
// const title = document.querySelectorAll(".hello h1");

//이하 두 코드는 같다.
// const title = document.querySelector("#hello");
// const title = document.getElementById("hello");

// const title = document.querySelector(".hello h1");
// const title = document.querySelector("div.hello h1");
// console.log(title);
// title.innerText = "Heeeeeeeeeeeeeeee"
// console.dir(title);

// title.style.color = "blue";

const title = document.querySelector("div.hello h1");

console.dir(title);

function handleTitleClick(){
    title.style.color = "blue";
}

function handleMouseEnter(){
    title.innerText = "Mouse is here!";
}

function handleMouseLeave(){
    title.innerText = "Mouse is gone..";
}

title.addEventListener("click", handleTitleClick); 
title.addEventListener("mouseenter", handleMouseEnter); 
title.addEventListener("mouseleave", handleMouseLeave); 

