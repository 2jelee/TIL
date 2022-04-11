/* eslint-disable */

import React, { useState } from 'react';
import './App.css';


function App() {  
  let [title, setTitle] = useState( ['React.js', 'Java', 'JavaScript']);  
  let [awesome, setAwesome] = useState(0); 

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
        <h3>{ title[1] } <span>👍</span>{awesome} </h3>
        <p>22년 04월 11일 발행</p>
        <hr />
      </div>
      <div className="list">
        <h3>{ title[2] } <span>👍</span>{awesome} </h3>
        <p>22년 04월 11일 발행</p>
        <hr />
      </div>
      </div>
  );
}

export default App;
