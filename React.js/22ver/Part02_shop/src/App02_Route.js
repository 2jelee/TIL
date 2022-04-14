/* eslint-disable */
import React, { useState } from 'react';
import Header from './components/Header';
import Carous from './components/Carous'; 
import './App.css'; 
import Datas from './data'
import Product from './Product'; 
import Detail from './components/Detail'; 

//Route를 만들어보자(페이지 나누기)
import { Switch, Route, Link } from 'react-router-dom'

function App() { 
  let [shoes, setShoes] = useState(Datas);

  return (
    <div className='App'> 
      <Header />  

      {/* Switch에 담으면 Route들이 하나씩만 보이게 된다. 위에서만 매칭된 것 보여주게 되는.*/}
      <Switch>
      {/* 매칭되는 것 다 보여주므로 exact를 사용하여 경로가 정확히 일치할 때만 보여준다 */}
        <Route exact path="/"> 
          <Carous /> 
          <div className="container">
            <div className="row"> 
            { 
              shoes.map((a, i) => {
                return <Product shoes={a} i={i} key={i} />  
              })
            }
            </div>
          </div>
        </Route>

        <Route path="/detail"> 
          <Detail />
        </Route>
        
        {/* :~ / 뒤에 아무 문자열이나 적었을 때를 의미(/모든 문자라는 경로를 의미) */}
        {/* Switch 컴포넌트 : 여러 개가 맞더라도 하나만 보여줘라.  */}
        <Route path="/:id"> 
          <div>아무거나 보여줘</div>
        </Route>

      {/* Route를 쓰는 다른 방법 : 해당 component만 보여주기 */}
      {/* <Route exact path="/Carous" component={Carous} /> */}
      </Switch>
    </div>
  );
}

export default App;
