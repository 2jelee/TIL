import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import { BrowserRouter } from 'react-router-dom';
import reportWebVitals from './reportWebVitals';
// import { HashRouter } from 'react-router-dom'; 

import { Provider } from 'react-redux'
import { createStore } from 'redux';

// return 뒤 state 초기값 설정
let store = createStore( () => { return [
  {id: 0, name: '왕발 신발', quantity: 2},
  {id: 1, name: '왕손 신발', quantity: 100},
  {id: 2, name: '마당발 신발', quantity: 299},
]
}); 

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
