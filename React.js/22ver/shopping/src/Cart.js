import React from "react";
import { Table } from "react-bootstrap";
import{ connect } from 'react-redux';

function Cart(props) {
  return (
    <div>
      <Table>
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
               props.state.map((item, i)=>{
                   return(
                    <tr key={i}>
                        <td>1</td>
                        <td>{item.id}</td>
                        <td>{item.name}</td>
                        <td>{item.quan}</td>
                        <td><button onClick={()=>{props.dispatch({type: 'INCREASE', no : item.id})}}> + </button></td>
                        <td><button onClick={()=>{props.dispatch({type: 'DECREASE', no : item.id})}}> - </button></td>
                    </tr>
                   )
               }) 
            }
        </tbody>
      </Table>
          
          {
             props.alertClose === true
             ? (<div className="my-alert-yellow">
                 <p>신규 구매하는 분들에게는 30% DC</p>
                  <button  onClick={()=>{props.dispatch({type: 'alertClose'})}} className="btn btn-primary mt-3">닫기</button>
                </div> )
            : null
          }
         
    </div>
  );
}

function stateStatus(state){
    console.log(state);
    // console.log(state.reducer);
    return {
        state : state.reducer,
        alertClose : state.reducerClose,
    }
}
export default connect(stateStatus)(Cart);
