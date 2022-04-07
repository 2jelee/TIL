import React, { useContext, useEffect, useState } from "react";
import { useHistory, useParams } from "react-router-dom";
import styled from "styled-components";
import {Nav} from 'react-bootstrap'
import {CSSTransition} from 'react-transition-group'

import {connect, useDispatch, useSelector } from "react-redux";
import "./Detail.scss";

// import InventContext from './App.js'   // import 안해서 인식 못했음.

let MyBox = styled.div`
  padding: 20px;
  font-size: 25px;
  font-weight: bold;
`;

let MyTitle = styled.h3`
  font-size: 25px;
  color: ${(props) => props.color};
`;

function Detail(props) {
  let history = useHistory();
  let { id } = useParams();

  let search = props.shrit.find((item) => {
    return item.id == id;
  });
  // 재고 글자 2초후에 사라짐
  let [alert, setAlert] = useState(true);

  useEffect(() => {
    let timer = setTimeout(() => {
      setAlert(false);
    }, 2000);
    return () => {
      clearTimeout(timer);
    };
  }, []);

  // let invent = useContext(InventContext);
  // 탭버튼 누른 상태 변화 제어
  let [clickTab, setClickTab] = useState(0);

  // 적용된 애니메이션 켜고 끄기
  let [ani, setAni] =useState(false);

  // function stateStatus(state) 대신 간단히 하기 - useSelector, useDispatch Hook 이용
  // let state = useSelector((state)=> state );
  // console.log(state.reducer);
  // let dispatch = useDispatch();


  return (
    <div className="container">
      <MyBox>Detail Page</MyBox>
      {/* <img src={"/images/t8.jpg"} alt="" /> */}
      {/* <img src={"../images/t8.jpg"} alt="" /> */}
      {/* 
            <MyBox>
                <MyTitle color="blue">안녕하세요.</MyTitle>
                <MyTitle color={'red'}>반갑습니다.</MyTitle>
                <h4>328482374</h4>
            </MyBox> */}
      {alert === true ? (
        <div className="my-alert-yellow">
          <p>재고가 얼마 남지 않았습니다.</p>
        </div>
      ) : null}

      <div className="row align-items-center">
        <div className="col-md-6  red ">
          {/* <img src={"https://raw.githubusercontent.com/ai-edu-pro/busan/main/t1.jpg"} alt= "shirt" width="100%"></img> */}
          <img
            src={
              `https://raw.githubusercontent.com/ai-edu-pro/busan/main/t` +
              (search.id + 1) +
              `.jpg`
            }
          />
          <h4>{search.title}</h4>
          <p>{search.content}</p>
          <p>{search.price}원</p>
          {/* <Infomation invent={props.invent} setInvent={props.setInvent} /> */}
          <button
            className="btn btn-danger"
            onClick={()=>{
              props.dispatch({type:'ADDITEM', payload: {id:2, name:'New이쁜옷', quan:4} });
              history.push('/cart');
            }}
          >주문하기
          </button>
          &nbsp;
          <button
            onClick={() => {
              history.goBack();
            }}
            className="btn btn-primary"
          >
            뒤로가기
          </button>
          &nbsp;
          <button
            onClick={() => {
              history.push("/");
            }}
            className="btn btn-success"
          >
            MainPage
          </button>
        </div>
      </div>

      <div className="mt-5">
        <Nav variant="tabs" defaultActiveKey="link-0">
          <Nav.Item>
          <Nav.Link eventKey="link-0" onClick={()=>{
              setClickTab(0)
            }}>환불정책</Nav.Link>
          </Nav.Item>
          <Nav.Item>
            <Nav.Link eventKey="link-1" onClick={()=>{
              setClickTab(1)
            }}>교환방법</Nav.Link>
            
          </Nav.Item>
          <Nav.Item>
            <Nav.Link eventKey="link-2" onClick={()=>{
              setClickTab(2)
            }}>상품평</Nav.Link>
          </Nav.Item>
        </Nav>

        <CSSTransition in={ani} classNames="tabcxt" timeout={500}>
          <TabCotrol clickTab={clickTab} setAni={ setAni } />
        </CSSTransition>
      </div>
    </div>
  );
}

function TabCotrol(props){

  useEffect(()=>{
    props.setAni(true);  // 탭내용 컴포넌트가 로드될 때 true
  });

  if(props.clickTab === 0 ){
    return <div className="tabfont mt-3">제품 하자 있을시 돈 돌려드립니다.</div>
  } else  if(props.clickTab === 1 ){
    return <div  className="tabfont  mt-3">제품에 마음에 안들면 같은 값에 원하는 제품교환가능</div>
  } else  if(props.clickTab === 2 ){
    return <div className="tabfont  mt-3">좋아요~ 완전 좋아요.</div>
  }
}


//export default Detail;

function stateStatus(state){
  console.log(state);
  // console.log(state.reducer);
  return {
      state : state.reducer,
      alertClose : state.reducerClose,
  }
}
export default connect(stateStatus)(Detail);