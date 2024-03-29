import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import {BrowserRouter} from "react-router-dom";
import {Provider} from "react-redux";
import axios from "axios";
// import store from "./store/store";

axios.defaults.withCredentials = true;

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  //   <Provider store={store}>
  <React.StrictMode>
    {/* store.js에 있는 state를 App이 전부 사용 가능 */}
      <BrowserRouter>
        <App />
      </BrowserRouter>
  </React.StrictMode>
    // </Provider>
);

reportWebVitals();
