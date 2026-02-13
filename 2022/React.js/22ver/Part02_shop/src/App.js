/* eslint-disable */
import React, { useEffect, useState, useContext } from 'react';
import Header from './components/Header';
import Carous from './components/Carous'; 
import './App.css'; 
import Datas from './data'
import Product from './Product'; 
import Detail from './components/Detail'; 
import Cart from './components/Cart'; 
import axios from 'axios';
import { Switch, Route } from 'react-router-dom'
import { Button } from 'react-bootstrap' 

export let inventoryContext = React.createContext(); 

function App() { 
  let [ shoes, setShoes ] = useState(Datas); 
  let [ btnCnt, setBtnCnt ] = useState(0);  
  let [ inventory, setInventory ] = useState([10, 11, 12]);

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

            <inventoryContext.Provider value={ inventory }>
              <div className="row"> 
                { 
                  shoes.map((a, i) => {
                    return <Product shoes={a} i={i} key={i} />  
                  })
                }
              </div>
            </inventoryContext.Provider>

            <Button variant="primary" 
              style={ {fontWeight: 'bold', alignContent: 'right' } } 
              onClick={ () => { 
                setBtnCnt(btnCnt+1);
 
                axios.get('https://codingapple1.github.io/shop/data'+(btnCnt+2)+'.json') 
                .then( (result) => {  
                  setShoes( [...shoes, ...result.data] );
                })
                .catch( () => { console.log('실패ㅠㅠ'); } );
              } }>더보기</Button>
          </div>
        </Route>
 
        <Route path="/detail/:id"> 
          <inventoryContext.Provider value={ inventory }>
            <Detail shoes={shoes} inventory={inventory} setInventory={setInventory} />
          </inventoryContext.Provider>
        </Route> 

        <Route path='/cart'>
          <Cart />
        </Route>
      </Switch>
    </div>
  );
} 

 
export default App;
