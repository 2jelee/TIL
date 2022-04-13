/* eslint-disable */

import React, { useState } from 'react';
import './App.css';


function App() {  
  let [title, setTitle] = useState( ['React.js', 'Java', 'JavaScript']);  
  let [awesome, setAwesome] = useState(0); 
  let [modal, setModal] = useState(false);

  let [titleClick, setTitleClick] = useState(0);

  function changeTitle() {
    let newArray = [...title];     
    newArray[0] = 'Spring';
    setTitle(newArray);
  }

  function changeSorted() {
    let newSorted = [...title].sort(); 
    setTitle(newSorted);
  }  
  
  function changeTitle() {
    
  }
 
  return (
    <div className="App"> 
      <div className='black_nav'>
        <div>개발 blog</div>
      </div>
      <div>
        <button onClick={ changeTitle }>제목변경 버튼</button> 
        <button onClick={ changeSorted }>순서변경 버튼</button> 
      </div>  
      {
        // 여기서 2번째 인자인 a는 반복문이 돌때마다 0, 1, 2, ... 가 되는(= 1씩 증가하는) 변수다.
        title.map(function(i, a) {
          return(
            <div className="list">
              <h3 onClick={ () => { setTitleClick(a)} }>{ i } <span onClick={ () => { setAwesome(awesome+1) } }>👍</span>{awesome} </h3>
              <p>22년 04월 11일 발행</p>
              <hr />
            </div>
          )
        })
      } 
      {/* <button onClick={ () => { setTitleClick(0)} }>1</button>
      <button onClick={ () => { setTitleClick(1)} }>2</button>
      <button onClick={ () => { setTitleClick(2)} }>3</button> */}

      <button onClick={ () => { setModal(!modal) } }>Modal Control</button>
      {
        modal === true
        ? <Modal title={title} titleClick={titleClick} />
        : null
      } 
    </div> 
  ); 
} 

function Modal(props) { 
  return(
    <div className='modal'>
      <h2>{props.title[props.titleClick]}</h2>
      <p>날짜</p>
      <p>상세내용</p>
    </div> 
  );
}

export default App;
