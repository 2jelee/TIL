/* eslint-disable */
import React, { useEffect, useState } from 'react'
import { useHistory, useParams } from 'react-router-dom'
import styled from 'styled-components'
import './Detail.scss'

let 박스 = styled.div`
  padding-top: 30px;
`;

let 제목 = styled.h4`
  font-size: 25px; 
  color: ${ props => props.색상 };
`;

function Detail(props) {
  let history = useHistory();  
  let { id } = useParams(); 
  let find_product = props.shoes.find( product => product.id == id );
  let [alert, changeAlert] = useState(true); 
  let [inputData, changeInputData] = useState();

  useEffect( () => {
    // axios.get()
    let timer = setTimeout(() => {
      changeAlert(false)
      return () => { clearTimeout(timer) }  
    }, 2000);
  }, [ alert ]);    

  function minusInv() {
    let inv = props.inventory[0]; 
    console.log(typeof(inv));
  }

  return (
    <div className="container">
      <박스>
        <제목 className='red'>Detail</제목>
      </박스>
      {
        alert === true
        ? 
          <div className="my-alert">
            <p>재고가 얼마 남지 않았습니다!</p>  
          </div>
        : null  
      }
      <input type="text" onChange={ (e) => { changeInputData(e.target.value) } }/> 

      <div className="row">
        <div className="col-md-6"> 
          <img src={"https://codingapple1.github.io/shop/shoes"+(parseInt(id)+1)+".jpg"} width="100%" />
        </div> 
        <div className="col-md-6 mt-4">
          <h4 className="pt-5">{find_product.title}</h4> 
          <p>{ find_product.content }</p>
          <p>{ find_product.price }원</p>
          <Info inventory={props.inventory} id={id} />
          <button className="btn btn-danger" 
            onClick={ () => { minusInv() }}>주문하기</button> 
          <button className="btn btn-primary" 
            onClick={ () => { history.push('/'); } }>
          뒤로가기</button> 
        </div>
      </div>
    </div> 
  )
}

function Info(props) {
  return (
    <div>재고 : {props.inventory[props.id]}</div>
  )
}

// [과거]
export class Detail2 extends React.Component {
  //가장 자주 사용하는 LifeCyle hook
  componentDidMount(){
    // Ajax 같은 것을 이러한 곳에 자주 사용
  }

  componentWillUnmount(){

  }

  render() {
    return (
      <div>Detail</div>
    )
  }
}


export default Detail