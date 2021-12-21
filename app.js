const loginForm = document.querySelector("#login-form");
const loginInput = document.querySelector("#login-form input");

// function onLoginBtnClick(){ 
//   const username = loginInput.value;
//   console.log(username);
// }

/*
form의 submit event를 감지하고 있는데 
submit은 엔터를 누르거나 버튼을 클릭할 때 발생한다는 사실을 기억
*/
/*
값을 입력하고 enter함으로써 새로고침이 발생하는 것은 form submit의 '기본(default) 동작' (from 브라우저)
*/
// function onLoginSubmit2(){ 
//   const username = loginInput.value;
//   console.log(username);
// }

// loginForm.addEventListener("submit", onLoginSubmit);
// loginForm.addEventListener("submit", onLoginSubmit()); //우리는 onLoginSubmit에 ()를 추가하지 않았다.
// 이유? ()를 추가한다는 것은 function을 '즉시' 실행한다는 뜻인데, 우린 바로 실행되는 것을 원치않기 때문! >> submit event가 발생하면 브라우저가 알아서 해당 fucntion을 실행시켜줄 것 ★★★

// onLoginSubmit() // () << 이것을 더한다면 브라우저가 보자마자 자동으로 이 fucntion을 실행시킴

// 즉, 현재 상태에서는 addEventListener를 활용할 때는 바로 실행시키려고 하는 것이 X (지정한 event가 발생했을 때만 브라우저가 해당 func을 실행)
/*
★Point 
: event가 발생할 때 브라우저가 해당 function을 호출하게 되는데 () << 이처럼 빈 상태로 호출하는 것이 아니라,
() 안에 첫 번째 argument로써 추가적인 정보를 가진 채로 호출하게 된다.
*/

// function onLoginSubmit(tomato){ 
//   tomato.preventDefault(); 
//   console.log(tomato);
// }
// loginForm.addEventListener("submit", onLoginSubmit);

/*
해당 코드를 실행하게 될 경우,
onLoginSubmit function에 대한 argument로 무언가 정보를 얻게 된다는 것을 browser console에서 확인 가능.

해당 코드는 onLoginSubmit이라는 func이 하나의 argument(=tomato)를 받도록 하는 코드.
이 func이 하나의 argument를 받도록 하고 그것을 JS에 넘겨주고 있다.
누군가 form을 submit하면 JS가 이 func을 호출하도록 함.
>> onLoginSubmit({information})

★★★ 모든 EventListener function의 첫 번째 argument는 항상 지금 막 벌어진 일들에 대한 정보가 된다.
방금 일어난 event에 대한 정보를 지닌 argument를 채워넣게 될 것.
값 입력 후 browser의 console에서 여러 정보가 표시됨을 확인할 수 있으며 이 정보들은 방금 실행된 event이다.
*/

// preventDefault라는 function : 어떤 event의 기본 행동이든지 발생되지 않도록 막는다.

// [관행] tomato → event      >> event object를 argument로 주는
function onLoginSubmit(event){ 
event.preventDefault(); 
console.log(loginInput.value); // 버튼을 클릭해도 새로고침이 안되도록
}
loginForm.addEventListener("submit", onLoginSubmit);