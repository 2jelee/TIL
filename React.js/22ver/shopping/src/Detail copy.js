/* eslint-disable */

import React from "react";
import { useHistory, useParams }  from 'react-router-dom';

function Detail(props) {

    
    let history = useHistory();
    let { id } = useParams();

    let search = props.shrit.find(function (item) {  //////
        return item.id == id;
    });

    return(
        <div className="container">
            <h3>Detail Page</h3>
            <div className="row">
                <div className="col-md-12">
                    <img src={"https://raw.githubusercontent.com/ai-edu-pro/busan/main/t" + (props.i +1) + ".jpg"} alt= "shirt" width="100%"></img>
                </div>
            </div>
            <div className="col-md-6  mt-4">
                {/* <h4>{props.shirt.title}</h4>     <h4>{props.shirt[id].title}</h4>  */}
                {/* <h5>{props.shirt.content}</h5>   <h5>{props.shirt[id].content}</h5> */}
                {/* <h6>{props.shirt.price}</h6> */}

                <h4 className="pt-5">{search.title}</h4>
                <p>{search.content}</p>
                <p>{search.price}</p>

                <button className="btn btn-danger">주문하기</button>
                <button onClick={()=>{history.goBack()}}className="btn btn-danger">뒤로가기</button>
                <button onClick={()=>{history.push("/")}}className="btn btn-danger">홈</button>
            
            </div>
        </div>
    );
}

export default Detail;


// // 1. 
// <div>
//     <h4>{props.shrit[:1].title}</h4>
//     <p>{props.shrit[:1].content}</p>
//     <p>{props.shrit[:1].price}원</p>
//     <button className="btn btn-danger">주문하기</button>
//     <button onClick={()=>{ history.push('/') }}  className="btn btn-danger">뒤로가기</button>
// </div> 

// // 2. 
// <div>
//     <h4>{props.shrit[id].title}</h4>
//     <p>{props.shrit[id].content}</p>
//     <p>{props.shrit[id].price }원</p>
//     <button className="btn btn-danger">주문하기</button>
//     {/* <button onClick={()=>{ history.goBack() }}  className="btn btn-danger">뒤로가기</button> */}
//     <button onClick={()=>{ history.push('/') }}  className="btn btn-danger">뒤로가기</button>
// </div> 

//  <div className="col-md-6 mt-4">
//                 <h4 className="pt-5">{searchPro.title}</h4>
//                 <p>{searchPro.content}</p>
//                 <p>{searchPro.price } 원</p>
//                 <button className="btn btn-danger">주문하기</button>
//                 {/* <button onClick={()=>{ history.goBack() }}  className="btn btn-danger">뒤로가기</button> */}
//                 <button onClick={()=>{ history.push('/') }}  className="btn btn-danger">뒤로가기</button>
// </div>  