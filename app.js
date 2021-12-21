//querySelector() : 사용 시 대상이 id인지 명확히 해주어야 한다.
//querySelector로 classname, tagname 모두 검색이 가능하므로.
const loginForm = document.querySelector("#login-form"); //querySelector == getElementById
const loginInput = loginForm.querySelector("input");
const loginButton = loginForm.querySelector("button");
//[위 코드를 간결하게]
// const loginInput = document.querySelector("#login-form input");
// const loginButton = document.querySelector("#login-form button");

function onLoginBtnClick(){
  // console.dir(loginButton);

  // console.log("Hello", loginInput.value);
  // console.log("Click");
  const username = loginInput.value;
  if (username === ""){
      alert("Please write your name");
  } else if(username.length > 15) {
    alert("Your name is too long.");
  }
// const username = loginInput.value;
  // console.log(username);
}
// loginButton.addEventListener("click", onLoginBtnClick);

