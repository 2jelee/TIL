import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import { BrowserRouter } from 'react-router-dom';
import reportWebVitals from './reportWebVitals';
import { Provider } from 'react-redux'
import { combineReducers, createStore } from 'redux';

let initState = [ 
  {id: 0, name: '왕발 신발', quantity: 2},
  {id: 1, name: '왕손 신발', quantity: 100},
  {id: 2, name: '마당발 신발', quantity: 299},
];

// 알림창 상태를 저장하는 state + reducer 하나 더 만들기
let alertState = true;
 
function reducer(state = initState, action){
  if ( action.type === 'quanIncrese') {
    let increase = [...state];
    increase[0].quantity++;
    return increase
  } 
  else if(action.type === 'quanDecrease') {
    let decrease = [...state];
    decrease[0].quantity--;
    if (decrease[0].quantity < 1){
      alert('수량을 0 이하로 선택할 수 없습니다.') 
      // return history.go()
    }
    return decrease
  } 
  else { return state }
}

// function reducer2(state = alertState, action) {
function reducer2(state = true, action) {
  if(action.type === 'off'){
    state = false
    return state;
  } else {
    return state
  }
}

// let store = createStore(reducer);
// reducer가 여러개일 때 하나로 합치는 문법 combineReducers( )
let store = createStore(combineReducers({reducer, reducer2}));
 


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
 
reportWebVitals();
