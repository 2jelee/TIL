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

  // useEffect : 컴포넌트 등장/업데이트 시 실행된다. => 업데이트될 때도 실행되므로 ★중요★
  useEffect( () => {
    let timer = setTimeout(() => {
      changeAlert(false)
      // console.log('안녕');

      // [ setTimeout 사용 시 주의점 ] 타이머 해제 스킬
      // 여기서의 return : 실행해라 O (뱉는다 X)
      return () => { clearTimeout(timer) } // 타이머를 제거해주는 clearTimeout 함수를 사용하여 
      // 의미 : Detail 컴포넌트가 사라질 때 timer를 제거를 실행해라
    }, 2000);
  // }); 
  }, [ alert ]); // []에 실행조건을 적는다. => alert라는 state가 변경이 될 때만 재랜더링 하라.
  // 만약 [ alert ]가 아니라, [ ] 빈 공간이라면? _가 변경될 때만 useEffect 실행해라.
  // 즉, <Detail /> 업데이트 시 실행 안된다는 소리.

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