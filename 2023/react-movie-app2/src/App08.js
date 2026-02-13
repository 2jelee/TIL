import React from 'react'
import {BrowserRouter, HashRouter, Route} from "react-router-dom"
import Navigation from './Navigation';
import About from "./routes/About";
import Home from "./routes/Home";


function App() {
  return (
  <BrowserRouter>
    <Navigation />
    <Route path="/" exact={true} component={Home} />
    <Route path="/about" component={About} />
  </BrowserRouter>
  )
}

export default App;
/* 
HashRouter 대신 BrowserRouter를 사용하는 경우]

큰 차이점은 없음. 
단, HashRouter의 경우 http://localhost:3000/#/ 와 같은 것이 없음.
또한 github pages에 정확히 설정하기가 다소 어렵.
*/