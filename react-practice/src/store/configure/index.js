import { configureStore } from '@reduxjs/toolkit';
import empReducer from '../modules/Reducer/EmpAuth';
import tokenReducer from '../modules/Reducer/TokenAuth';

export default configureStore({
    reducer: {
        EMP_INFO: empReducer,
        ACCESS_TOKEN: tokenReducer,
    },
});
