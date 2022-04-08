import React, { useState } from 'react';
import { useHistory } from 'react-router-dom';
import { useParams } from 'react-router-dom/cjs/react-router-dom.min';
import styled from 'styled-components';

let MyBox = styled.div`
  padding: 20px;
`;

let MyTitle = styled.h3`
  font-size: 25px;
  color: ${ props => props.myColor }; //변수 지정
`;

function Detail(props) {
  const history = useHistory();
  let {id} = useParams();
  let search = props.shirt.find((item) => {
    return item.id == id;
  });

  let [alert, set] 

  let inventContext

  return (
    <div className='container'>
      <MyBox>
        <MyTitle myColor='blue'>안녕하세요.</MyTitle>
        <MyTitle myColor={'red'}>반갑습니다.</MyTitle>
      </MyBox>
      <div className='row'>
        <div className='col-md-6'>
          <img src="https://raw.githubusercontent.com/ai-edu-pro/busan/main/t1.jpg" alt="" width='100%' />
        </div>
        <div>
          <h4>상품명</h4>
          <p>상품설명</p>
          <p>120000원</p>
          <button className="btn btn-danger">주문하기</button>
          {/* <button className="btn btn-danger" onClick={ () => { history.goBack()} }>뒤로가기</button> */}
          <button className="btn btn-danger" onClick={ () => { history.push('/')} }>뒤로가기</button>
        </div>
      </div>
    </div>
  )
}

function TestContext() {
  let invent = useContext(inventContext)
  return <p>재고</p>;
}

export default Detail;`