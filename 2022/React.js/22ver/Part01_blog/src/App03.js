/* eslint-disable */

import React, { useState } from 'react';
import './App.css';


function App() {  
  // [ES6] destructuring 문법 => state
  // array : [state데이터, state데이터변경'함수']
  let [title, setTitle] = useState( ['Java', 'JavaScript', 'React.js']); // 이는 사실 array 형태. ['여자 코트 추천', state 고쳐주는 함수]
  
  // state 변경 방법이 따로 존재한다. 2번째 값의 setAwesome함수를 사용
  // setAwesome(대체할데이터)
  let [awesome, setAwesome] = useState(0); 

  function changeTitle() {
    // setTitle : state를 아예 대체해주는(갈아치우는) 함수 | 아래는 하드코딩 방식
    // setTitle(['Spring', 'JavaScript', 'React.js']);
    
    // let newArray = title[0]~~~ 불가. 원본 State 수정 불가능! (특히 state가 Array. Object가 자료형이면)

    // [하드코딩 하지 않는 방법]
    // 1. 수정된 데이터를 만든다. 단, state의 복사본을 만들어서 수정한다.
    // let newArray = title; // 2. 단, state를 deep copy해서 수정해야 한다. 이는 복사가 아니라 값 공유일뿐. >> reference data type 특징
    // deep copy : 값 공유 X, 서로 독립적인 값을 가지는 복사 skill
    let newArray = [...title];    // 3. spread operator : 중괄호, 대괄호 모두 제거해라. 이는 괄호들 제거 후 다시 담았음
    //리액트 대원칙 : immutable data => 데이터는 직접 수정이 되면 안된다.
    newArray[0] = 'Spring';
    setAwesome(newArray);
  }

  return (
    <div className="App"> 
      <div className='black_nav'>
        <div>개발 blog</div>
      </div>
      <div className="list">
        {/* <h3>{ title[0] } <span onClick={ () => { console.log(1) } }>👍</span>0 </h3> */}
        <h3>{ title[0] } <span onClick={ () => { setAwesome(awesome+1) } }>👍</span>{awesome} </h3>
        <p>22년 04월 11일 발행</p>
        {/* <button onClick={ changeTitle() }>버튼</button> 의 onClick에 함수명()하면 안된다. 이는 바로 실행하라는 뜻이기 때문  */}
        <button onClick={ changeTitle }>버튼</button> 
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
