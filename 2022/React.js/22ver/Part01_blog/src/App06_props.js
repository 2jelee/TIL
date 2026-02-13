/* eslint-disable */

import React, { useState } from 'react';
import './App.css';


function App() {  
  let [title, setTitle] = useState( ['React.js', 'Java', 'JavaScript']);  
  // let [awesome, setAwesome] = useState([0, 0, 0]); 
  let [awesome, setAwesome] = useState(0); 
  let [modal, setModal] = useState(false);

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
    // let newAwesome = awesome;
    // console.log(newAwesome);
    setAwesome(awesome.map( (i) => { setAwesome[i] += 1 }))
    
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
              <h3>{ i } <span onClick={ () => { setAwesome(awesome+1) } }>👍</span>{awesome} </h3>
              {/* <h3>{ i } <span onClick={ changeAwesome }>👍</span>{awesome} </h3> */}
              <p>22년 04월 11일 발행</p>
              <hr />
            </div>
          )
        })
      } 
      <button onClick={ () => { setModal(!modal) } }>Modal Control</button>
      {
        modal === true
        // ? <Modal 작명={전송할state} />
        ? <Modal title={title} />
        : null
      } 
    </div> 
  ); 
}

//App의 자식 컴포넌트
//여기서 매개변수 props는 부모에서 전달받은 props가 여기에 다 들어있다.
function Modal(props) { 
  return(
    <div className='modal'>
      <h2>{props.title[0]}</h2>
      <p>날짜</p>
      <p>상세내용</p>
    </div> 
  );
}

export default App;
