/* eslint-disable */
import React, { useState } from 'react';
import Header from './components/Header';
import Carous from './components/Carous'; 
import './App.css'; 
import Datas from './data'
import Product from './Product'; 
import Detail from './components/Detail'; 

import { Switch, Route } from 'react-router-dom'
import { Button } from 'react-bootstrap'

function App() { 
  let [shoes, setShoes] = useState(Datas);

  function sort_price() {
    let newShoes = [...shoes]; 
    let price_compare = newShoes.sort(function(a, b) {
      return a.price-b.price;
    });
    setShoes(price_compare); 
  }

  return (
    <div className='App'> 
      <Header />  

      <Switch>
        <Route exact path="/"> 
          <Carous /> 
          <br />
          <Button variant="outline-success" style={ {fontWeight: 'bold', alignContent: 'right' } } onClick={ () => { sort_price() } }>낮은 가격순 정렬</Button>
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
 
        <Route path="/detail/:id"> 
          <Detail shoes={shoes} />
        </Route>
        
        {/* <Route path="/:id"> 
          <div>아무거나 보여줘</div>
        </Route> */}

      </Switch>
    </div>
  );
}

export default App;
