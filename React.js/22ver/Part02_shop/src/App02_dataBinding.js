/* eslint-disable */
import React, { useState } from 'react';
import Navigation from './components/Navigation';
import Carous from './components/Carous'; 
import './App.css'; 
import Datas from './data'
import Product from './Product'; 

function App() { 
  let [shoes, setShoes] = useState(Datas);

  return (
    <div className='App'> 
      <Navigation />  
      <Carous /> 

      <div className="container">
        <div className="row"> 
        {
          // shoes.map(function(a, i) {
          //   return <Product shoes={shoes[i]} />  
          // })

          // shoes라는 데이터 갯수만큼 HTML을 생성하기
          shoes.map((a, i) => {
            // return <Product shoes={shoes[i]} />  //아래 코드와 동일한 결과.
            return <Product shoes={a} i={i} key={i} />  
          })
        }
        </div>
      </div>
    </div>
  );
}

export default App;
