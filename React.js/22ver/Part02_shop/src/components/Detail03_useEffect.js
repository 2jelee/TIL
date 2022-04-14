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

  
  // useEffect라는 훅을 통해 과거 사용하던 LifeCycle과 동일한 기능
  // Hook의 정확한 명칭은 Lifecycle Hook 이다.
  /*
  이는 자주 실행되며
  1. 컴포넌트가 mount 되었을 때
  2. 컴포넌트가 update 될 때
  특정 코드를 실행할 수 있다!
  
  이 훅 안에 callback함수를 적어주는데, 이는 arrow function으로 보통 축약 가능하다.
  ---
  또한, 컴포넌트가 사라질 때 코드를 실행시킬 수도 있다.
  필수 : return function 함수명(){ 실행할 코드 };
  필수 : return ()=>{ 실행할 코드 }; 
  여기서 실행할 코드는 사라질 때(즉, unmount 될 때) 실행된다.
  여기서의 return은 뱉는다의 개념이 아닌, 이걸 실행해주라는 뜻
  ---
  여러 개를 실행해야 한다면? (실행할 것이 많다면?)
  useEffect( () => { } );
  useEffect( () => { } );
  useEffect( () => { } );
  이처럼 useEffect 자체를 여러개 만들면 된다. 단, 실행은 상단에 있는 것부터 차례로 실행
  */
  useEffect( () => {
    // 2초 뒤에 안보이게 해줘
    setTimeout(() => {
      changeAlert(false)
    }, 2000);
  }); 
 
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