import React from 'react'
import {BrowserRouter, HashRouter, Route} from "react-router-dom"
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
Navigation.js의 path는 당연히 App.js의 path와 같아야 한다.
다를 경우 동작 X.
*/