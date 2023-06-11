import React from 'react'
import {HashRouter, Route} from "react-router-dom"
import About from "./routes/About";
import Home from "./routes/Home";


function App() {
  return (
  <HashRouter>
    <Route path="/" component={Home} />
    <Route path="/about" component={About} />
  </HashRouter>
  )
}

export default App;
/*
HashRouter : HashRouter를 import하게 되면,,
  react-router-dom은 다른 종류들의 라우터들이 있다. 그중 HashRouter를 쓸 것이며
  또한 Route를 임포트할 것.

이것을 return하는 대신에 HashRouter를 리턴.
이 안에 Route를 넣어줌.
Route 안에는 매우 중요한 props가 한 개 들어간다.
그 prop은 렌더링할 스크린이 들어가며 다른 prop은 무엇을 할지 정해줌.

http://localhost:3000/#/ 할 경우 Home만 보이지만
http://localhost:3000/#/about 할 경우, 보고자하는 페이지(about) 외에도 Home이 보인다.
즉, 2개에 컴포넌트가 동시에 렌더링되는 것임.
이유? >> 이것이 리액트가 작동하는 방식임.
  리액트 라우터에 url부분을 설명하려면,,,
*/