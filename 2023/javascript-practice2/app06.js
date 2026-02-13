const h1 = document.querySelector("div.hello h1");

function handleMouseEnter(){

    const currentColor = h1.style.color;
    let newColor; // nothing inside.
    if(currentColor === "blue"){
        newColor = "tomato";
    } else{
        newColor = "blue";
    }
    //이 위 코드까지만 작성하면 newColor를 변경해봤자 h1의 color에는 아무 영향도 미치지 X
    h1.style.color = newColor;
}

h1.addEventListener("click", handleMouseEnter);

// ※정리
// step 1. element를 찾아라.
// step 2. event를 listen해라.
// step 3. event를 react(반응)해라.
// >> 여기서 react란, 무언가를 보여주거나, 감추거나, 색깔을 바꾸는 것 등등과 같다.

// style 작업에 적합한 도구는 CSS
// animation에 적합한 도구는 JS
// 그러므로 JS안에 CSS 작업을 하지말자.
