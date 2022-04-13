/* eslint-disable */

import React, { useState } from 'react';
import './App.css';


function App() {  
  let [title, setTitle] = useState( ['React.js', 'Java', 'JavaScript']);  
  // let [awesome, setAwesome] = useState(0); 
  let [awesome, setAwesome] = useState([0, 0, 0]); 
  let [modal, setModal] = useState(false);

  // let array = [1,2,3];
  // let newArray = array.map(function(a) { //여기서 a는 array 안에 있던 하나하나의 데이터들을 의미
  //   return a * 2; //출력 : [2,4,6]  << 대신 기존의 [1, 2, 3]은 사라진다. 
  // });
  // console.log(newArray);

  function changeTitle() {
    let newArray = [...title];     
    newArray[0] = 'Spring';
    setTitle(newArray);
  }

  function changeSorted() {
    let newSorted = [...title].sort(); 
    setTitle(newSorted);
  }  

  function changeAwesome() {
    let newAwesome = [...awesome];
    
  }

  function UUII() {
    let arr = [];
    for (let i = 0; i < 3; i++) {
      arr.push(<div>push했음</div>)      
    }
    return arr
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
        // title.map( () => { return <div></div>} )
        title.map(function(i) {
          return(
            <div className="list">
              {/* <h3>{ i } <span onClick={ () => { setAwesome(awesome+1) } }>👍</span>{awesome} </h3> */}
              <h3>{ i } <span onClick={ () => { setAwesome(awesome+1) } }>👍</span>{awesome} </h3>
              <p>22년 04월 11일 발행</p>
              <hr />
            </div>
          )
        })
      }
      {
        UUII()
      }
      <button onClick={ () => { setModal(!modal) } }>Modal Control</button>
      {
        modal === true
        ? <Modal/>
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
