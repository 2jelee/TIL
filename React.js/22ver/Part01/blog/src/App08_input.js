/* eslint-disable */

import React, { useState } from 'react';
import './App.css';

function App() {  
  let [title, setTitle] = useState( ['React.js', 'Java', 'JavaScript']);  
  let [awesome, setAwesome] = useState(0); 
  let [modal, setModal] = useState(false);
  let [titleClick, setTitleClick] = useState(0);

  let [inputValue, setInputValue] = useState(''); //초기값

  function changeTitle() {
    let newArray = [...title];     
    newArray[0] = 'Spring';
    setTitle(newArray);
  }

  function changeSorted() {
    let newSorted = [...title].sort(); 
    setTitle(newSorted);
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
        title.map(function(i, a) {
          return(
            // map으로 돌린 HTML에는 key = {}가 필요해서 console에 warning이 뜬다.
            <div className="list" key={a}> 
              <h3 onClick={ () => { setTitleClick(a)} }>{ i } <span onClick={ () => { setAwesome(awesome+1) } }>👍</span>{awesome} </h3>
              <p>22년 04월 11일 발행</p>
              <hr />
            </div>
          )
        })
      } 

      <button onClick={ () => { setModal(!modal) } }>Modal Control</button>
      {
        modal === true
        ? <Modal title={title} titleClick={titleClick} />
        : null
      } 
      {/* { inputValue } */}
      {/* React에서는 onChange나 onInput이나 비슷하므로 혼용 O */}
      <input onChange={ (e) => { setInputValue(e.target.value) } } />

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
