/* eslint-disable */
import React from 'react'
import { useHistory, useParams } from 'react-router-dom'

function Detail(props) {
  // 방문기록 등을 저장해놓는 Object
  // [Hook] useHistory 
  let history = useHistory();  

  // [Hook] 라우터의 useParams hook
  let { id } = useParams(); // useParams 자리에 {}가 남는다. 이는 사용자가 입력한 URL 파라미터들이 들어있다.

  // 현재 shoes라는 상품데이터들 안에 {id : 0} 이런 영구번호가 있으므로
  // '/:id' 자리에 입력한 값과 영구번호가 같은 {상품데이터}를 찾아서 데이터바인딩
  let find_product = props.shoes.find(function(product) { //콜백함수의 파라미터 = array안에 있던 각각의 데이터를 의미함.
    return product.id == id //이것이 참인 데이터만 새로운 변수에 저장
  })

  return (
    <>
      <div className="container">
        <div className="row">
          <div className="col-md-6">
            <img src="https://codingapple1.github.io/shop/shoes1.jpg" width="100%" />
          </div> 
          <div className="col-md-6 mt-4">
            {/* <h4 className="pt-5">{props.shoes[id].title}</h4> */}
            <h4 className="pt-5">{find_product.title}</h4> 
            <p>{ find_product.content }</p>
            <p>{ find_product.price }</p>
            <button className="btn btn-danger">주문하기</button> 
            <button className="btn btn-primary" 
              // onClick={ () => { history.goBack(); } }>
              // 특정 경로로 이동시키기
              onClick={ () => { history.push('/'); } }>
            뒤로가기</button> 
          </div>
        </div>
      </div> 
    </>
  )
}

export default Detail