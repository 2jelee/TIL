//부분적으로 필요한 것만 가져오겠다 -> { } 사용
// use ... -> hook

import React, { useState } from 'react';
import './App.css';
import Modal from './Modal';

function App() {
  let nickName = "2jelee";
  let [title, setTitle] = useState(['인천광역시 ', '경기도 성남시 ', '서울특별시 ']);   
  let [like, setLike] = useState(0);
  
  function changeTitle() { 
    let newTitle = [...title]; 
    newTitle[0] = '강촌 '; 
    setTitle(newTitle);
  }

  return ( 
    <div className='App'>
      <div className='nav'>
        <div>나의 일상 소개</div>
      </div>  
      <div style={ {color: 'black', fontSize: '30px'} }>{nickName}님, 안녕하세요</div>

      <div className='list'>
        <h3>{ title }</h3>
        <button onClick={ changeTitle }>제목 변경</button>
        <h3> 
          { title[0] } <span onClick={ () => { setLike(like+1) } }>👍</span> {like}  
        </h3>
        <p>3월 31일 발행</p>
      </div>
      <hr/>
      <div className='list'>
        <h3>{ title[1] } <span>👍</span> {like} </h3>
        <p>3월 31일 발행</p>
      </div>
      <hr/>
      <div className='list'>
        <h3>{ title[2] } <span>👍</span> {like} </h3>
        <p>3월 31일 발행</p>
      </div>
      <Modal/>
    </div>
  );
}

export default App;
