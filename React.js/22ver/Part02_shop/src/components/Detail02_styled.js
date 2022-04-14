/* eslint-disable */
import React from 'react'
import { useHistory, useParams } from 'react-router-dom'
import styled from 'styled-components'
import './Detail.scss'

// CSS를 미리 입혀놓은 components를 쓰겠다
// 백틱(``) 안에서 사용할 수 있는 JS 문법 사용 : ${ }
// `글자${변수명} 글자`
let 박스 = styled.div`
  padding-top: 30px;
`;

// 만약 색깔만 다른 제목이 여러 개 필요하다면? props를 사용하자
let 제목 = styled.h4`
  font-size: 25px; 
  color: ${ props => props.색상 };
`;

function Detail(props) {
  let history = useHistory();  
  let { id } = useParams(); 

  // let find_product = props.shoes.find(function(product) { 
  //   return product.id == id
  // })
  // let find_product = props.shoes.find( product => { return product.id == id })
  let find_product = props.shoes.find( product => product.id == id );

  return (
    <div className="container">
      <박스>
        {/* 보낼이름={변수명} */}
        {/* <제목 색상={'blue'}>Detail</제목> */}
        {/* 보낼이름="일반문자" */}
        {/* <제목 색상="red">Detail</제목> */}
        <제목 className='red'>Detail</제목>
      </박스>

      <div className="my-alert"><p>my-alert</p></div>
      <div className="my-alert2"><p>my-alert2</p></div>
      <div className="my-alert3">
        <p>재고가 얼마 남지 않았습니다!</p>  
      </div>      

      <div className="row">
        <div className="col-md-6"> 
          <img src={"https://codingapple1.github.io/shop/shoes"+(parseInt(id)+1)+".jpg"} width="100%" />
        </div> 
        <div className="col-md-6 mt-4">
          <h4 className="pt-5">{find_product.title}</h4> 
          <p>{ find_product.content }</p>
          <p>{ find_product.price }</p>
          <button className="btn btn-danger">주문하기</button> 
          <button className="btn btn-primary" 
            onClick={ () => { history.push('/'); } }>
          뒤로가기</button> 
        </div>
      </div>
    </div> 
  )
}

export default Detail