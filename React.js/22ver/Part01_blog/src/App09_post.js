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

  function post() {
    let title_copy = [...title]; 
    title_copy.unshift(inputValue);
    setTitle(title_copy);
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
            <div className="list" key={a}> 
              <h3 onClick={ () => { setTitleClick(a)} }>{ i } <span onClick={ () => { setAwesome(awesome+1) } }>👍</span>{awesome} </h3>
              <p>22년 04월 11일 발행</p>
              <hr />
            </div>
          )
        })
      } 

      <div className='publish'>
        <input onChange={ (e) => { setInputValue(e.target.value); }}  />
        <button onClick={ post }>저장1</button>
        <button onClick={ () => {
          // unshift() : array 맨 앞에 자료를 추가하는 문법
          // state 데이터는 = 등호로 직접 수정하면 안되므로 사본을 만들어 그것을 수정해야 한다.
          let title_copy = [...title]; // copy하자!!!!!!
          title_copy.unshift(inputValue);
          setTitle(title_copy);
        } }>저장2</button>
      </div>

      <button onClick={ () => { setModal(!modal) } }>Modal Control</button>
      {
        modal === true
        ? <Modal title={title} titleClick={titleClick} />
        : null
      } 
      {/* <input onChange={ (e) => { setInputValue(e.target.value) } } /> */}

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
