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
    <Route path="/movie/:id" component={Detail} /> 
  </HashRouter>
  );
}

export default App;
/* 
Route path="/movie-detail" component={Detail}를 더 나은 코드로 만들기]

path="/movie/:id"로 바꾸기 >> id는 변수가 됨.
*/