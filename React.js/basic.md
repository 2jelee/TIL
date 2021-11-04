public > favicon : 화면 맨 위에서 볼 수 있는 것처럼 상단에 나타나는 것

src]

리액트 페이지에서 소스코드 보기할 경우 보이는 것은 index.html임.
리액트는 소스코드에 처음부터 HTML을 넣지 않고
HTML에서 HTML을 추가하거나 제거하는 법을 알고 있다.
그러므로 application이 이를 로드할 때, 빈 html을 로드하게 되고
그 다음에 리액트가 HTML을 밀어 넣게 된다. (component에 작성해 두었던 것들을. << App.js)

index.js]
ReactDOM.render(<App />, document.getElementById('patato'));

<App /> 는 component다. 그리고 react는 component와 함께 동작함. 모든 것은 component다.
나는 component를 만들게 될 것이고 component를 보기 좋게 만들게 될 것이다.	
component : data를 보여주게 함.
	: HTML을 반환하는 함수.
react는 component를 사용해서 HTML처럼 작성하려는 경우에 필요.
javascript와 HTML사이의 이러한 조합 == jsx 
jsx는 리액트에서 나오는 유일한? 개념.
react에 특화된 개념 중 하나임(유일할지도..)

component를 작성할 때마다 import React from "react"를 써주어야한다.
이를 하지 않으면 react는 여기에 있는 jsx가 있는 component를 사용하는 것을 이해하지 X
 
index.js]
import App from './App'; 
import Potato from './Potato'; 

ReactDOM.render(<App /><Potato/>, document.getElementById('patato'));
>> error발생

이유? 
react applicaton이 하나의 component만을 rendering하기 때문임.
그 component가 App임.

>>해결
App.js에 Potato를 import하고
App 컴포넌트의 return문의 <div>태그 안에 <Potato/>를 적어주면 정상 작동한다!

만들고 싶은만큼 component를 만들 수 있고 많은 component를 return할 수 있다.
기억하기!
	react application은 한번에 하나의 component만 rendering할 수 있다는 것!!!!!!
	따라서 모든 것은 App.js(application) 안에 들어가야 한다.
	App.js안에서 많은 component를 넣을 수 있다.
	그리고 이러한 component 안에 더 많은 component를 import할 수 있다.

function Food({fav}){ 
  return <h1>I like {fav}</h1>;
}

function App() {
  return (
    <div>
      <h1>G HELLO</h1>
      <Food fav = "kimchi"/> 
    </div>
  );
}

export default App;
와

function Food(props){ 
  return <h1>I like {fav}</h1>;
}
는 같다.

또한, return에서 <h1>I like {fav}</h1>; 와 
		return <h1>I like {props.fav}</h1>; 도 같다.

단, {props.fav} 대신에 
Food 컴포넌트에 ({fav}){
와 return문에 <h1>I like {fav}</h1>;로 깔끔히 정리.



#3 STATE
state : 보통 우리가 동적 데이터와 함께 작업할때 만들어짐. 
	변하는 데이터, 존재하지 않는 데이터 그리고 생겨나고 사라지고 변경된 데이터, 하나인 데이터
	그리고 두개가 되고 또는 0이 되는 그런 종류의 것들.
	이게 dynamic date다. 그리고 이러한 props는 우리를 돕지 않으며 우리가 필요한건 state다.
 



[[[[[[[[[[[[[[[[깃 허브 커밋하기]]]]]]]]]]]]]]]]]
git init
git hub에서 Repository 생성하기 (단, Initialize this repository with a README << 체크 및 생성 X
상단 URL 복사
git remote add origin URL붙여넣기
git add . (.은 everything을 의미)
git commit -m "하고 싶은 말"
git push origin master

---done---

fetch보다 더 좋은 방법 >> Axios
axios는 마치 fetch위에 있는 작은 layer다.

라우터 : url을 가져다가 확인, 사용자가 무엇을 명령했는지에 따라..
import {HashRouter, Route} from "react-router-dom";
return절 <HashRouter>, <Route>

Route >> path, component 만듦.




----
props 의미 
: 컴포넌트 만들고나서 <내컴포넌트 id=아이디> 파라미터 처럼 들어가는 것들을 props이라고 해요
