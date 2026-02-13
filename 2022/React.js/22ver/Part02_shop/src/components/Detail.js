/* eslint-disable */
import React, { useContext, useEffect, useState } from 'react'
import { useHistory, useParams } from 'react-router-dom'
import styled from 'styled-components'
import { inventoryContext } from '../App';
import './Detail.scss'
import { Nav } from 'react-bootstrap';

import { CSSTransition } from 'react-transition-group';
 

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
  let inventory = useContext( inventoryContext );
  let [tab, clickTab] = useState();
  let [swit, changeSwit] = useState(false);

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
          <p>재고 : { inventory } </p>
          <Info inventory={props.inventory} id={id} />
          <button className="btn btn-danger" 
            onClick={ () => { minusInv() }}>주문하기</button> 
          <button className="btn btn-primary" 
            onClick={ () => { history.push('/'); } }>
          뒤로가기</button> 
        </div>
      </div>

      {/* className='mt-5' : bootstrap이 기본적으로 부여하는.. 의미 : margin top 5만큼 부여 */}
      {/* 
        eventKey="" : 부트스트랩 문법 -> 버튼들마다 유니크한 eventKey 부여 
        defaultActiveKey : 기본으로 눌러진 버튼의 eventKey (즉, default 값 부여)
      */}
      <Nav className='mt-5' variant="tabs" defaultActiveKey="link-1">
        <Nav.Item>
          <Nav.Link eventKey="link-0" onClick={ () => { clickTab(0); changeSwit(false); }}>Active</Nav.Link>
        </Nav.Item>
        <Nav.Item>
          <Nav.Link eventKey="link-1" onClick={ () => { clickTab(1); changeSwit(false); }}>Option 2</Nav.Link>
        </Nav.Item> 
      </Nav>

      {/* 여기서 in={ }는 애니메이션 동작 스위치로, true일 경우에 동작한다. */}
      <CSSTransition in={swit} classNames="animation" timeout={500}>
        <TabContent tab={tab} changeSwit={changeSwit}/> 
      </CSSTransition>
    </div> 
  )
}

// 조건을 2개 초과를 걸어 삼항연산자를 사용할 수 없는 경우 따로 function을 뺀다.
function TabContent(props){
  // useEffect : 컴포넌트가 등장/업데이트할 때 스위치 true
  useEffect( () => {
    props.changeSwit(true);
  });
  
  if(props.tab === 0){
    return <div>0번 내용</div>
  } else if(props.tab === 1){
    return <div>1번 내용</div>
  } else if(props.tab === 2){
    return <div>2번 내용</div>
  }
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