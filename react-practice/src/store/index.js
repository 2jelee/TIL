import { configureStore } from '@reduxjs/toolkit';
import tokenReducer from '../auth/Auth';
// import tokenReducer, {tokenSlice} from './Auth';
// import {combineReducers} from "redux";
// import {persistReducer} from "redux-persist";
// import storage from "redux-persist/lib/storage";

// reducer를 사용을 위한 등록
export default configureStore({
    reducer: {
        ACCESS_TOKEN: tokenReducer,
    },
});



// const reducers = combineReducers({
//     ACCESS_TOKEN: tokenReducer
// });
//
// const persistConfig = {
//     key: 'root',
//     storage,
// };
//
// const persistedReducer = persistReducer(persistConfig, reducers);
//
// // reducer를 사용을 위한 등록
// // export default configureStore({
// const store = configureStore({
//     // reducer: {
//     reducer:
//         // ACCESS_TOKEN: tokenReducer,
//         persistedReducer
//
// });
//
// export default store;