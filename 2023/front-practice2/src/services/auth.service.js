//이 서비스는 HTTP 요청에 Axios를 사용하고 사용자 정보 및 JWT에 Local Storage를 사용합니다.
// 다음과 같은 중요한 기능을 제공합니다.
//
// login(): POST {username, password} & JWT로컬 저장소에 저장
// logout(): JWT로컬 저장소에서 제거
// register(): POST {사용자 이름, 이메일, 비밀번호}
// getCurrentUser(): 저장된 사용자 정보 가져오기(JWT 포함)

import axios from "axios";
const API_URL = "http://localhost:8080/";

// const register = (username, email, password) => {
//     return axios.post(API_URL + "signup", {
//         username,
//         email,
//         password,
//     });
// };

const login = (user_id, password) => {
    return axios
        .post(API_URL + "login", {
            user_id,
            password,
        })
        .then((response) => {
            if (response.data.accessToken) {
                localStorage.setItem("user", JSON.stringify(response.data));
            }
            return response.data;
        });
};
//
// const logout = () => {
//     localStorage.removeItem("user");
// };
// const getCurrentUser = () => {
//     return JSON.parse(localStorage.getItem("user"));
// };
const AuthService = {
    // register,
    login
    // logout,
    // getCurrentUser,
};
export default AuthService;