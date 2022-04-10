import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import { BrowserRouter } from 'react-router-dom'

import { Provider } from 'react-redux';
import { combineReducers, createStore } from 'redux';

let basicState = [
  {id:0, name:'이쁜여자옷', quan:2},
  {id:1, name:'완전이쁜옷', quan:1},
];

function reducer(state = basicState, action){
  let stateIndex = state.findIndex((item)=>{ return item.id === action.no});

  if(action.type === 'ADDITEM'){
    let searchIndex = state.find( (item) => { return item.id === action.no.id} );

    if(searchIndex >= 0 ) {  // 찾은 데이터가 있다면 
      let newState = [...state];
      newState[searchIndex].quan++;  //수량만 증가
      return newState
    } else {
      let newState = [...state];
      newState.push(action.payload);
      return newState
    } 
  } else if (action.type === 'INCREASE') {
    let newState = [...state];
    newState[stateIndex].quan++;
    return newState 
  } else if (action.type === 'DECREASE') {
    let newState = [...state];
   
    if(newState[stateIndex].quan < 0 ) {
      newState[stateIndex].quan = 0;
    }
    else {
      newState[stateIndex].quan--;
    }
    return newState

  } else {

    return state
  }
}

let alertBasic = true;

function reducerClose(state=alertBasic, action){
  if(action.type === 'alertClose'){
    return false
  } else {
    return state
  }
 
}

let store = createStore(combineReducers({reducer, reducerClose}));

ReactDOM.render(
  <React.StrictMode>
    <BrowserRouter>
      <Provider store={store}>
       <App />
      </Provider>
    </BrowserRouter>
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
