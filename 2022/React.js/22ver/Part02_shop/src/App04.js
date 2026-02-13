/* eslint-disable */
import React, { useEffect, useState } from 'react';
import Header from './components/Header';
import Carous from './components/Carous'; 
import './App.css'; 
import Datas from './data'
import Product from './Product'; 
import Detail from './components/Detail'; 
import axios from 'axios';

import { Switch, Route } from 'react-router-dom'
import { Button } from 'react-bootstrap'
// import { Axios } from 'axios';

function App() { 
  let [ shoes, setShoes ] = useState(Datas);
  // let [ notice, setNotice ] = useState(true);
  let [ btnCnt, setBtnCnt ] = useState(0); 

  // useEffect( () => {
  //   setTimeout(() => {
  //     notice(false)
  //   }, [ ]);
  // })

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
            <Button variant="primary" 
              style={ {fontWeight: 'bold', alignContent: 'right' } } 
              onClick={ () => { 
                // 더보기 버튼을 n번째 누를 경우 해당 새로운 URL로 데이터 요청 보내기
                setBtnCnt(btnCnt+1);

                // 미구현
                // {
                //   notice === true
                //   ? <p>Loading...</p>
                //   : null
                // }

                // 1. get 요청
                axios.get('https://codingapple1.github.io/shop/data'+(btnCnt+2)+'.json') 
                // 2. post 요청
                // axios.post('서버URL', { 서버에게 전달할 데이터 })
                // 요청 시의 header 설정(쿠키 전송 등..)도 가능 -> 라이브러리 사용법을 찾아보자
                // axios.post('https://codingapple1.github.io/shop/data2.json', { id: '2jelee', pw: 1234 }) 
                .then( (result) => {  
                  setShoes( [...shoes, ...result.data] );
                })
                .catch( () => { console.log('실패ㅠㅠ'); } );
              } }>더보기</Button>
          </div>
        </Route>
 
        <Route path="/detail/:id"> 
          <Detail shoes={shoes} />
        </Route> 
      </Switch>
    </div>
  );
} 
export default App;
