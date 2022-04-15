/* eslint-disable */
import React, { useState } from 'react';
import Header from './components/Header';
import Carous from './components/Carous'; 
import './App.css'; 
import Datas from './data'
import Product from './Product'; 
import Detail from './components/Detail'; 
import axios from 'axios';

import { Switch, Route } from 'react-router-dom'
import { Button } from 'react-bootstrap'
import { Axios } from 'axios';

function App() { 
  let [shoes, setShoes] = useState(Datas);

  function sort_price() {
    let newShoes = [...shoes]; 
    let price_compare = newShoes.sort(function(a, b) {
      return a.price-b.price;
    });
    setShoes(price_compare); 
  }

  function add_data() {
    let addProducts = [...shoes];
    addProducts.push(result.data);
    setShoes(addProducts);
    console.log(setShoes);
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
            <Button variant="primary" 
              style={ {fontWeight: 'bold', alignContent: 'right' } } 
              onClick={ () => { 
                //get 요청 코드
                // [1. axios]
                axios.get('https://codingapple1.github.io/shop/data2.json')
                // [2. fetch()]
                // fetch('https://codingapple1.github.io/shop/data2.json')
                // .then( () => { console.log('성공!'); } )
                // .then( (result) => { console.log(result); } )
                // .then( (result) => { console.log(result.data); } )
                .then( (result) => { 
                  console.log(result.data); 
                  let spreadData = [...result.data];
                  let addProducts = [...shoes];
                  addProducts.push(spreadData);
                  console.log(addProducts);
                  setShoes(addProducts);
                  
                  // shoes.map((a, i) => {
                  //   return <Product shoes={a} i={i} key={i} />  
                  // })
                })
                .catch( () => { console.log('실패ㅠㅠ'); } );
               } }>더보기</Button>
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
