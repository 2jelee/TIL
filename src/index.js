import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import {BrowserRouter} from "react-router-dom";
import {Provider} from "react-redux";
import axios from "axios";
import store from "./store";
// import {persistStore} from "redux-persist";
// import {PersistGate} from "redux-persist/integration/react";
// import store from "./store";

axios.defaults.withCredentials = true;

// let persistor = persistStore(store);

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  // <React.StrictMode>
    <Provider store={store}>
    {/* store.js에 있는 state를 App이 전부 사용 가능 */}
    {/*    <PersistGate loading={null} persistor={persistor}>*/}
          <BrowserRouter>
            <App />
          </BrowserRouter>
        {/*</PersistGate>*/}
    </Provider>
  // </React.StrictMode>
);

reportWebVitals();
