import React from 'react'
import {HashRouter, Route} from "react-router-dom"
import Navigation from './Navigation';
import About from "./routes/About";
import Home from "./routes/Home";
import Detail from "./routes/Detail";


function App() {
  return (
  <HashRouter>
    <Navigation />
    <Route path="/" exact={true} component={Home} />
    <Route path="/about" component={About} />
    <Route path="/movie-detail" component={Detail} />
  </HashRouter>
  );
}

export default App;
/* 
정리]
Detail.js와 같은 방식으로 리다이렉트하거나, 유저들의 네이게이션 방식을 바꿈.
>> Router를 통해서 주어진 props를 이용해서.

Detail은 컴포넌트 Route에 있는 것이기 때문. (네비게이션은 props가 없다.)
*/