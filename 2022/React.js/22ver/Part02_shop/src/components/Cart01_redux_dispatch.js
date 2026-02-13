import React from 'react'
import { Table } from 'react-bootstrap'
import { connect } from 'react-redux'

function Cart(props) {
  return ( 
    <>
      <Table responsive="sm">
        <thead>
          <tr>
            <th>#</th>
            <th>상품명</th>
            <th>수량</th>
            <th>변경</th>
          </tr>
        </thead>
        <tbody> 
          {
            props.state.map( (a, i) => {
              return(
                <tr key={i}>
                  <td>{ a.id }</td>
                  <td>{ a.name }</td>
                  <td>{ a.quantity }</td>
                  <td>
                    {/* 만약 quantity 데이터가 잘못되면 reducer만 찾으면 된다. (또는 dispatch) */}
                    <button onClick={ () => { props.dispatch( {type: 'quanIncrese'}) } }>+</button>&nbsp;
                    <button onClick={ () => { props.dispatch( {type: 'quanDecrease'}) } }>-</button>
                  </td> 
                </tr>
              )
            })
          } 
        </tbody> 
      </Table> 
    </>
  )
}

/*
  state : store 안에 있던 데이터를 가져오는 역할의 함수
          즉, redux store 데이터 가져와서 props로 변환해주는 함수
  => 일종의 props화 해주는.. >> props로 바꿔서 써야 한다!

  store 데이터 사용하려면 원하는 컴포넌트에서 props로 등록하고 사용해야 한다.
*/
function useRedux(state){ //state를 props화 //이곳의 매개변수 state는 store안에 있던 모든 데이터를 지칭
  return {
    //방법1
    // 상품명 : state[0].name

    // 방법2 / 의미 : state라는 이름의 props로 바꿔줘
    state: state 
  }
}

// export default Cart
export default connect(useRedux)(Cart)
