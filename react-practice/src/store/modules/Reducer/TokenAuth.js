import { createSlice } from '@reduxjs/toolkit';
import {persistReducer} from "redux-persist";

// access_token 만료 시간 설정
export const TOKEN_TIME_OUT = 600 * 1000;

export const tokenSlice = createSlice({
    name: 'token',
    initialState: {
        authenticated: false,
        accessToken: null,
        expireTime: null
    },
    reducers: {
        SET_TOKEN: (state, action) => {
            state.authenticated = true;
            state.accessToken = action.payload;
            state.expireTime = new Date().getTime() + TOKEN_TIME_OUT;
        },
        DELETE_TOKEN: (state) => {
            state.authenticated = false;
            state.accessToken = null;
            state.expireTime = null
        },
    }
})

export const { SET_TOKEN, DELETE_TOKEN } = tokenSlice.actions;
export default tokenSlice.reducer;
