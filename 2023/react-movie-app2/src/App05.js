import React from 'react'
import {HashRouter, Route} from "react-router-dom"
import About from "./routes/About";
import Home from "./routes/Home";


function App() {
  return (
  <HashRouter>
    <Route path="/" exact={true} component={Home} />
    <Route path="/about" component={About} />
  </HashRouter>
  )
}

export default App;
/*

  리액트 라우터는 기본적으로 url을 가져옴. 그다음 비교함. 나의 라우터에서.
  그러므로 /home/introduction을 가져오고 기본적으로 나의 라우터와 비교하며 매치가 된다면 컴포넌트를 보여줌.
  >> /가 라우트로 여겨진 것. 

  2개의 컴포넌트가 동시에 렌더링 되는 것을 방지하기 위한 방법!!!
  : exact true를 첫번째 route에 추가. >> url이 /일때만 home을 렌더링.
  exact의 의미 : 이것이 아니면 렌더링하지 않겠다.!
*/