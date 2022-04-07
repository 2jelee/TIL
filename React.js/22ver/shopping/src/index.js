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

function reducer(state=basicState, action){
  let stateIndex = state.findIndex(
      (item)=>{ return item.id === action.no});

  if(action.type === 'ADDITEM'){
    let newState = [...state];
    newState.push(action.payload);
    return newState

  } else if(action.type === 'INCREASE') {

    let newState = [...state];
    newState[stateIndex].quan++;
    return newState

  } else if(action.type === 'DECREASE') {
    let newState = [...state];
   
    if(newState[stateIndex].quan === 0 ) newState[stateIndex].quan= 0;
    else  newState[stateIndex].quan--;
    
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
