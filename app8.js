// style 작업에 적합한 도구는 CSS
// animation에 적합한 도구는 JS
// 그러므로 JS안에 CSS 작업을 하지말자.
const h1 = document.querySelector("div.hello h1");

function hanleTitleClick(){
    // h1.className = "active"; //여기서 active는 style.css의 active와 명을 같게.
    
    const clickedClass = "clicked";
    if(h1.className === clickedClass){
        h1.className = "";
    } else{
        h1.className = clickedClass;
    }
}

h1.addEventListener("click", hanleTitleClick);

// 이렇게 함으로써 JS는 HTML을 변경하고 CSS는 HTML을 바라보게 된다.
// JS ==> HTML <== CSS
