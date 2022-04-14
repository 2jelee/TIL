/* eslint-disable */

import React, { useState } from 'react';
import './App.css';


function App() {  
  let [title, setTitle] = useState( ['React.js', 'Java', 'JavaScript']);  
  let [awesome, setAwesome] = useState(0); 
  let [modal, setModal] = useState(false); //모달창을 켜고 닫는 스위치

  function changeTitle() {
    let newArray = [...title];     
    newArray[0] = 'Spring';
    setTitle(newArray);
  }

  function changeSorted() {
    let newSorted = [...title].sort();
    // console.log(newSorted.sort()); 
    setTitle(newSorted);
  }  

  return (
    <div className="App"> 
      <div className='black_nav'>
        <div>개발 blog</div>
      </div>
      <div>
        <button onClick={ changeTitle }>제목 변경버튼</button> 
        <button onClick={ changeSorted }>순서변경버튼</button> 
      </div>
      <div className="list">
        <h3>{ title[0] } <span onClick={ () => { setAwesome(awesome+1) } }>👍</span>{awesome} </h3>
        <p>22년 04월 11일 발행</p>
        <hr />
      </div>
      <div className="list">
        <h3>{ title[1] } <span onClick={ () => { setAwesome(awesome+1) } }>👍</span>{awesome} </h3>
        <p>22년 04월 11일 발행</p>
        <hr />
      </div>
      <div className="list">
        <h3>{ title[2] } <span onClick={ () => { setAwesome(awesome+1) } }>👍</span>{awesome} </h3>
        <p>22년 04월 11일 발행</p>
        <hr />
      </div>
      
      {/* <button onClick={ () => { setModal(true) } }>Modal on/off</button> */}
      <button onClick={ () => { setModal(!modal) } }>Modal on/off</button>
      {/* if대신 삼항연산자 : JSX 안의 { } 내에서 쓸 수 O */}
      {
        modal===true 
        ? <Modal />
        : null
      }
    </div>
  ); 
}

function Modal() {
  return(
    <div className='modal'>
      <h2>제목</h2>
      <p>날짜</p>
      <p>상세내용</p>
    </div> 
  );
}

export default App;
