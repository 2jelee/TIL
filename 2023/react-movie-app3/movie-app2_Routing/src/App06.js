import React from 'react'
import {HashRouter, Route} from "react-router-dom"
import Navigation from './Navigation';
import About from "./routes/About";
import Home from "./routes/Home";


function App() {
  return (
  <HashRouter>
    <Navigation />
    <Route path="/" exact={true} component={Home} />
    <Route path="/about" component={About} />
  </HashRouter>
  )
}

export default App;
/* 
Navigation 관련하여 기억해야할 2가지
    1. Link를 router밖에서 사용할 수 없음. (App.js)
      즉, 
      function App() {
        return (
          <Navigation />
        <HashRouter>
          <Route path="/" exact={true} component={Home} />
          <Route path="/about" component={About} />
        </HashRouter>
        )
      }
      
      위 코드처럼 HashRouter 상단에 위치(바깥에 위치)
      >> Link는 라우터 안에 있어야 한다.

    2. 그러나 모든 것을 Router안에서 할 필요는 없다.
      ex. 페이지에 footer가 있다면
      function App() {
        return (
        <HashRouter>
          <Navigation />
          <Route path="/" exact={true} component={Home} />
          <Route path="/about" component={About} />
        </HashRouter>
        <footer></footer>
        )
      }
      
      위 코드는 당연히 fragment가 필요함. 두 개를 동시에 렌더링하기 위해서는.
      function App() {
        return (
        <>
        <HashRouter>
          <Navigation />
          <Route path="/" exact={true} component={Home} />
          <Route path="/about" component={About} />
        </HashRouter>
        <footer></footer>
        </>
        )
      }

      결론>> Router안에 모든 것을 넣은 필요가 없으나,
             Link를 쓰고 있다면 Router 안에 넣기.
*/