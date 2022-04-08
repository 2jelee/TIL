import React, { useContext, useEffect, useState } from "react";
import {Link, useHistory } from 'react-router-dom'
import axios from "axios";

// import { InventContext } from "./App";

function Card(props) {

  // 4. 전달 받을 컴포넌트에서 가져와서 변수에 저장. useContext() hook 상단에 임포트 
  // let invent = useContext(InventContext);   
 
  let history = useHistory();
  const titleOK = () => { history.push(`/detail/${props.i}`) }
  
  const [message, setMessage] = useState("메세지!");

  useEffect(()=>{
    // fetch('/basic/api/hello')
    axios('https://raw.githubusercontent.com/ai-edu-pro/busan/main/data2.json')  // ajax 통신
          .then((result)=>{
              console.log(result.data); // 객체로 변환
          }) // 성공했을때
          .then((message)=>{
              setMessage(message)
          })
          .catch(()=>{
            console.log('fail!');
          })
  }, []);

  return (
    <div className="container">

      <h1>{message}</h1>
      <div className="row">
        <div className="col">
          {/* <img src='https://raw.githubusercontent.com/ai-edu-pro/busan/main/t' + ( props.i + 1) + '.jpg' alt="티셔츠" width="100%" /> */}
          {/* <img src={'https://raw.githubusercontent.com/ai-edu-pro/busan/main/t1.jpg' } /> */}
          <Link to={`detail/${props.i}`}>
            <img
              src={
                `https://raw.githubusercontent.com/ai-edu-pro/busan/main/t` +
                (props.i + 1) +
                `.jpg`
              }
              alt="티셔츠"
              width="100%"
            />
          </Link>

          <h4 onClick={ titleOK } style={{ cursor: 'pointer' }}>
            {props.shrit.title}
          </h4>
          <h6>{props.shrit.content}</h6>
          <p>{props.shrit.price}</p>
        </div>
        {/* <div>남은 갯수 :  { props.invent[props.i] } </div> */}
        {/* <div>남은 갯수 :  { invent[props.i] } </div> */}
      </div>
    </div>
  );
}

export default Card;
