import React, { useState } from 'react';
import './App.css';
import Modal from './Component/Modal';

function App() {
  let nickName = "2jelee"; 
  let [title, setTitle] = useState(['인천광역시 ', '경기도 성남시 ', '서울특별시 ']);  
  let [like, setLike] = useState(0);

  function changeTitle() {
    let newTitle = [...title]; 
    newTitle[0] = '강촌 '; 
    setTitle(newTitle);
  }

  function titleSort() {
    
  }

  /***************************************/
  // useState : 변경이 필요할 때 사용
  // 제어를 위한 flag 변수
  let [flag, setFlag] = useState(false); //현재 flag 안에는 false가 들어가 있다. << 즉, 기본값으로 false를 사용한다.
  
  //true면 false로, false면 true로 바꿔주기
  function onOff() {
    this.setFlag( { flag: !this.state.Modal } )
  }

  function toDay() {
    let todayNow = document.getElementById('date').value = new Date().toISOString().slice(0, 7);
    console.log(todayNow);
    return todayNow;
  }

  return ( 
    <>
    <div className='App'>
      <div className='nav'>
        <div>나의 일상 소개</div>
      </div>  
      <div style={ {color: 'black', fontSize: '30px'} }>{nickName}님, 안녕하세요</div>

      <div className='list'>
        <h3>{ title }</h3>
        <button onClick={ changeTitle }>제목 변경</button>
        <button onClick={ titleSort }>제목 오름차순 정렬보기</button>
        <h3> 
          { title[0] } <span onClick={ () => { setLike(like+1) } }>👍</span> {like}  
        </h3>
        {/* <p>3월 31일 발행</p> */}
        <p id="date">{ toDay }</p>
        <p id="date"> </p>
      </div>
      <hr/>
      <div className='list'>
        <h3>{ title[1] } <span>👍</span> {like} </h3>
        <p>3월 31일 발행</p>
      </div>
      <hr/>
      <div className='list'>
        <h3 onClick={()=>{ setFlag(true) }}>{ title[2] } <span>👍</span> {like} </h3>
        <p>3월 31일 발행</p>
      </div> 
    </div>

    <hr />

    {/* <button onClick={ () => { onOff } }>Modal ON / OFF</button> */}
    
    {/* JSX에서는 if문을 사용할 수 없으므로 '삼항연산자'를 사용한다.*/}
    {/* 다른 component도 같은 파일 내에 여러 개 만들 수 있다. */}
    {/* <Modal/> */}
    {
      flag === true ? <Modal/> : null
    } 
    </>
  );
}

export default App;
