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
                    <button onClick={ () => { props.dispatch( {type: 'quanIncrese'}) } }>+</button>&nbsp;
                    <button onClick={ () => { props.dispatch( {type: 'quanDecrease'}) } }>-</button>
                  </td> 
                </tr>
              )
            })
          } 
        </tbody> 
      </Table> 

      {/* 알림창 만들기 : 닫기 기능까지 */}
      {/* <div className="my-alert2">
        <p>지금 구매하시면 신규할인 20%</p>
        <button>닫기</button>
      </div> */}
      {
        props.alert확인 === true
        ? 
        <div className="my-alert2">
          <p>지금 구매하시면 신규할인 20%</p>
          <button onClick={ () => { props.dispatch( { type: 'off' } )} }>닫기</button>
        </div>
        : null  
      }
    </>
  )
}

// store 생김새 {reducer: ?, reducer2: ?}
function useRedux(state){
  console.log(state);  
  return { 
    // state: state
    state: state.reducer, //현재 array 데이터임
    alert확인: state.reducer2 //리듀서2에 담긴 데이터 //현재 true임
  }
}

export default connect(useRedux)(Cart)
