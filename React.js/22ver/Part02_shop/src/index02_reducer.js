import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import { BrowserRouter } from 'react-router-dom';
import reportWebVitals from './reportWebVitals';
import { Provider } from 'react-redux'
import { createStore } from 'redux';

let initState = [ 
  {id: 0, name: '왕발 신발', quantity: 2},
  {id: 1, name: '왕손 신발', quantity: 100},
  {id: 2, name: '마당발 신발', quantity: 299},
];

// Redux에서는 state 데이터의 수정방법을 미리 정의해야 한다.
/*
  reducer 함수 : state 데이터 수정방법을 정의해놓자.
  이 함수는 항상 state 데이터를 return(퉤) 해야 한다. << 수정된 state를 뱉는 함수

  [ES6의 기본 파라미터 문법(default parameter)] state = initState 이처럼 파라미터 뒤에 등호를 붙일 수 있다.
  파라미터 자리에 뭔가 값을 입력하지 않으면 'initState'(default)를 변수에 집어넣어 기본으로 만들어달라는 의미

  state 초기값을 initState 자리에 넣으면 된다.

  action.type : 데이터 수정되는 조건
*/
function reducer(state = initState, action){
  if ( action.type === 'quanIncrese') {
    let increase = [...state];
    increase[0].quantity++;

    // return modifyState
    return increase
  } 
  else if(action.type === 'quanDecrease') {
    let decrease = [...state];
    decrease[0].quantity--;
    if (decrease[0].quantity < 1){
      alert('수량을 0 이하로 선택할 수 없습니다.') 
      return history.go()
    }
    return decrease
  } 
  else { return state }
}

let store = createStore(reducer);
// 만약 quantity 데이터가 잘못되면 reducer만 찾으면 된다. (또는 dispatch) => [결론] Redux 사용 이유2. state데이터 관리가 용이(일명 상태관리)

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <BrowserRouter>
      <Provider store={ store }>
        <App />
      </Provider>
    </BrowserRouter>
  </React.StrictMode> 
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
