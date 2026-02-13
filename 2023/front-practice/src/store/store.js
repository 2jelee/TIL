import {configureStore, createSlice} from "@reduxjs/toolkit";

// Redux store에 보관
// useState() 역할과 유사

let token = createSlice({
    name: 'ACCESS_TOKEN',
    // 실제 값
    initialState: ''
})
// state 하나를 slice라고 부른다.

export default configureStore({
    reducer: {
        // slice를 만든 후에 여기에 등록을 해야 사용이 가능하다
        token: {
            ACCESS_TOKEN: token.reducer
        }
    }
})