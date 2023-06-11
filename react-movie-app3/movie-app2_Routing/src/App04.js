import React from 'react'
import {HashRouter, Route} from "react-router-dom"
import About from "./routes/About";
import Home from "./routes/Home";


function App() {
  return (
  <HashRouter>
    <Route path="/home" >
      <h1>Home</h1>
    </Route>
    <Route path="/home/introduction" >
      <h1>Introduction</h1>
    </Route>
    <Route path="/about">
      <h1>About</h1>
    </Route>
  </HashRouter>
  )
}

export default App;
/*
http://localhost:3000/#/ 할 경우 Home만 보이지만
http://localhost:3000/#/about 할 경우, 보고자하는 페이지(about) 외에도 Home이 보인다.
즉, 2개에 컴포넌트가 동시에 렌더링되는 것임.
이유? >> 이것이 리액트가 작동하는 방식임.
  리액트 라우터에 url부분을 설명..
  
  http://localhost:3000/#/home/introduction 해보기 >> 리액트 라우터가 2개의 컴포넌트(Home, Introduction)를 랜더링함을 볼 수 있음.

  리액트 라우터는 기본적으로 url을 가져옴. 그다음 비교함. 나의 라우터에서.
  그러므로 /home/introduction을 가져오고 기본적으로 나의 라우터와 비교하며 매치가 된다면 컴포넌트를 보여줌.
  >> /가 라우트로 여겨진 것. 
*/