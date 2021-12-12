// app8.js를 Clean Code로 바꿔보기
const h1 = document.querySelector("div.hello h1");

// function hanleTitleClick(){
    
//     const clickedClass = "clicked";
//     //아래 코드 h1.clasName을 classList로 변경하여
//     //classList는 말 그대로 class들의 목록으로 작업할 수 있게끔 허용해준다.
//     //            element의 class 내용물을 조작하는 것을 허용함.
//     //className : 그냥 모든 것을 교체해버린다. 이전의 class들을 상관하지 않고.

//     //classList.contains : HTML element의 class에 | 지정한 클래스값이 엘리먼트의 class 속성에 존재하는지 확인
//     if(h1.classList.contains(clickedClass)){ //classList가 clicked를 포함하고 있는지를 확인하겠다.
//         h1.classList.remove(clickedClass);
//     } else{
//         h1.classList.add(clickedClass);
//     }
// }

// h1.addEventListener("click", hanleTitleClick);




//위 코드보다 개발 시 더 많이 사용되는 method
// >> toggle function : class name이 존재하는지 확인
function handleTitleClick(){
    // const clickedClass = "clicked"; //아래 clickedClass(String)을 반복하는 순간 그때 constant를 생성.
    h1.classList.toggle("clicked"); //단 한줄로 위와 같은 코드를 똑같이 구현할 수 있다.
}

h1.addEventListener("click", handleTitleClick);

//toggle : 토큰을 toggle한다. 
        // 토큰이 존재하면 토큰을 제거, 존재하지 않는다면 토큰을 추가!