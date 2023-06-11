import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import {BrowserRouter} from "react-router-dom";
import {Provider} from "react-redux";
import axios from "axios";
import store from "./store/configure";
import {CookiesProvider} from "react-cookie";

import {PersistGate} from "redux-persist/integration/react";
// import { persistor, store } from './redux/store';

axios.defaults.withCredentials = true;

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <CookiesProvider>
        <Provider store={store}>
            {/*<PersistGate loading={null} persistor={persistor}>*/}
                <BrowserRouter>
                    <App />
                </BrowserRouter>
            {/*</PersistGate>*/}
        </Provider>
    </CookiesProvider>
);
reportWebVitals();
