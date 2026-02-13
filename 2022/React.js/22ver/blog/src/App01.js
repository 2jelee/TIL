//부분적으로 필요한 것만 가져오겠다 -> { } 사용
// use ... -> hook

import React, { useState } from 'react';
import './App.css';
import Hello from './Hello';

function App() {
  let nickName = "2jelee";
  let value = {color: 'red', fontSize: '30px'};
  // let values = useState('data'); // 데이터 2개 전달 1, 요소, 변경할 수 있는

  //useState를 통해 값을 변경한다. | 현 => 배열 형태
  let [title, setTitle] = useState(['인천광역시 ', '경기도 성남시 ', '서울특별시 ']); 
  // 1번째 요소(ex. title) : 실제 데이터 값
  // 2번째 요소(ex. setTitle) : 값을 바꿀 수 있는 ? -> 변경될 값

  //useState : 수시로 값이 변경되길 원할 때 사용
  //useState(초기값) 
  let [like, setLike] = useState(0);
  
  function changeTitle() {
    // let newTitle = title;
    let newTitle = [...title];
    // title[0] = '강촌';
    // setTitle(newTitle);
    newTitle[0] = '강촌 ';
    // newTitle[0] = setTitle(newTitle);
    setTitle(newTitle);
  }

  return ( 
    <div className='App'>
      <div className='nav'>
        <div>나의 일상 소개</div>
      </div>

      {/* style을 줄 경우, {}를 사용하며 camelCase를 적용한다. */}
      {/* CSS 적용하기 1 : 변수 선언으로 값 주기 */}
      <div style={ value }>
        {nickName}님, 안녕하세요!
      </div>

      {/* 2. 직접 값 넣어주기 */}
      <div style={ {color: 'black', fontSize: '30px'} }>{nickName}님, 안녕하세요</div>

      <div className='list'>
        <h3>{ title }</h3>
        <button onClick={ changeTitle }>제목 변경</button>
        <h3>
          {/* arrowFunction (매개변수) => { 실행할코드 }  */}
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
    </div>
  );
}

export default App;
