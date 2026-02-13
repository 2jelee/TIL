// useState() 함수를 쓸 때는 항상 useState import를 해야한다.
import React, {useState} from 'react';
import Navigation from './components/Navigation';
import Carous from './components/Carous'; 
import './App.css'; 
import Datas from './data'
import Product from './Product';
// import name from './data'
// import {name, name2} from './data'


function App() {
  // useState() 함수를 쓸 때는 항상 useState import를 해야한다.
  let [shoes, setShoes] = useState(Datas);

  return (
    <div className='App'>
      {/* {name} {name2} */} 

      {/* 상단 Navbar */}
      <Navigation /> 

      {/* 캐러셀 */}
      <Carous />

      {/* 가로로 3분할 */}
      {/* Origin Bootstrap 사용 O 
          단, css 사이즈가 커진다.
              아래 코드처럼 class명을 부여해서 사용해야 한다.
      */}
      <div className="container">
        <div className="row">
          <div className="col-md-4">
            <Product/>
          </div>
          <div className="col-md-4">
            <img src="https://codingapple1.github.io/shop/shoes2.jpg" alt="" width="100%" />
            <h4>{ shoes[1].title }</h4>
            <p>상품설명 및 가격</p>
          </div>
          <div className="col-md-4">
            <img src="https://codingapple1.github.io/shop/shoes3.jpg" alt="" width="100%" />
            <h4>{ shoes[2].title }</h4>
            <p>상품설명 및 가격</p>
          </div>
        </div>
      </div>
    </div>
  );
}

export default App;
