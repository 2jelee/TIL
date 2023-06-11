const loginForm = document.querySelector("#login-form");
const loginInput = document.querySelector("#login-form input");
// 추가
const link = document.querySelector("a");

function onLoginSubmit(event){ 
  event.preventDefault(); 
  console.log(loginInput.value); 
}
loginForm.addEventListener("submit", onLoginSubmit);

// 추가
// function handleLinkClick(){
//   alert("clicked!"); //지금 이 alert가 이 page가 다른 동작을 하지 못하도록 막고 있는 상태
// }
// link.addEventListener("click", handleLinkClick); // handleLinkClick()로 코드를 작성하게 된다면, 이 함수는 한 번만 실행되고 그것으로 END
//즉, 코드 작성 시 개발자는 JS한테 함수 이름만 주고 실행하는 것은 JS의 몫이다.

/*
무엇이 클릭되었는지, 어디가 클릭되었는지 등 정보를 알고 싶다면,
JS는 단순히 함수를 실행시키기만 하는 것이 아니라
JS는 함수를 실행시키는 동시에 그 함수에 첫 번째 인자로 object를 넣어줄 것임.
>> handleLinkClick({information about the event that just happened!!})
또한, 이 object에는 방금 일어난 event에 대한 여러 정보가 담겨있다.
방금 일어난 event에 대한 정보를 담은 이 object는 handleLinkClick을 위한 EventListener 함수의 첫 번째 인자로 주어지게 될 것임.
개발자는 이와 같이 자리를 제공해주면 되고,
                   공간만 만들고 받기만 하면 된다.
                   해야할 것은 받는 것뿐임.
*/

// 추가 + argument + preventDefault()
function handleLinkClick(event){
  event.preventDefault(); //이로써 event는 멈추게 되고 아무 것도 진행되지 않는다 >> 즉, 브라우저에 대한 것을 개발자가 control
  console.dir(event); 
}
link.addEventListener("click", handleLinkClick); 
/*
[실행 결과]
Edge 브라우저 : PointerEvent
Chrome : MouseEvent >> 단, MouseEvent보다 PointerEvent가 더 많은 기능을 포함하고 있어서 현재 PointerEvent를 쓴다고 한다. (2021.12.21 기준)
*/

/*
★ 정리 -중요 ★
addEventListener 안에 있는 함수는 직접 실행하지 않는다는 것.    >> 개발자가 하는 것이 아니라 브라우저가 해주는 것이다!
                                                                >> 또한, 브라우저는 실행만 시켜주는 것이 아니라 event에 대한 정보도 담아줌.
*/