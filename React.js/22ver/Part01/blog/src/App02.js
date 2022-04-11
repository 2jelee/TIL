import React, { useState } from 'react';
import './App.css';


function App() {  
  // [ES6] destructuring 문법 => state
  // array : [state데이터, state데이터변경함수]
  let [title, setTitle] = useState( ['Java', 'JavaScript', 'React.js'] ); // 이는 사실 array 형태. ['여자 코트 추천', state 고쳐주는 함수]

  return (
    <div className="App"> 
      <div className='black_nav'>
        <div>개발 blog</div>
      </div>
      <div className="list">
        <h3>{ title[0] }</h3>
        <p>22년 04월 11일 발행</p>
        <hr />
      </div>
      <div className="list">
        <h3>{ title[1] }</h3>
        <p>22년 04월 11일 발행</p>
        <hr />
      </div>
      <div className="list">
        <h3>{ title[2] }</h3>
        <p>22년 04월 11일 발행</p>
        <hr />
      </div>
      </div>
  );
}

export default App;
