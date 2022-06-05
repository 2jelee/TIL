import axios from "axios";

const API_BASE_URL = 'http://localhost:8080';
const JWT_EXPIRY_TIME = 24 * 3600 * 1000; // 만료시간 (24시간 밀리 초로 표현)

export function call(api, method, request) {
    let options = {
        // method: 'post',
        method: method,
        headers: new Headers({
            "Content-Type": "application/json",
            // "Content-Type": "text/plain;charset=UTF-8",
        }),
        // withCredentials: true, // axios
        credential: 'include',
        url: API_BASE_URL + api,
    };
    if (request) {
        // GET method
        options.body = JSON.stringify(request);
    } // 여기까지 가입된 user_id와 password가 맞는지 확인 OK
    // access token 가져오기
    return fetch(options.url, options)
        .then((response) =>
            response.text().then((text) => {
                if (!response.ok) {
                    // response.ok가 true 이면 정상적인 리스폰스를 받은 것, 아니면 에러 리스폰스를 받은 것.
                    return Promise.reject(text);
                }
                alert("access token OK");
                // history.go(-1);
                // console.log(response.headers.map["Set-Cookie"]);
                return text;
            })
        )
        .catch((error) => {
            // alert("error 발생 : ApiService: undefined / Unexpected token e ins JSON at position 0");
            console.log(error.status);

            if (error.status === 403) {
                window.location.href = ""; // redirect
            } if (error.status === 500) {
                alert("500 error: 존재하지 않는 사번 or 비밀번호가 맞지 않음. 근데 왜 500번일까..?");
                window.location.href = ""; // redirect
            }
            return Promise.reject(error);
        }
    );
}


export function login(LoginDto) {
    // const dispatch = useDispatch();

    return call("/login", "post", LoginDto)
        .then((response) => {
            // localStorage에 저장 -> Redux에 저장
            // localStorage.setItem("ACCESS_TOKEN", response);

            // Redux에 저장
            // dispatch((response));

            console.log("response(ACCESS_TOKEN) :" + response);
            alert("access token : " + response);

            let onSilentRefresh = () => {
                // axios.post('/refresh', String refresh_token or data)
                axios.post('/refresh', response)
                    .then(onLoginSuccess)
                    .catch(error => {
                        console.log(error)
                    });
            }
            let onLoginSuccess = response => {
                // ACCESS_TOKEN인 response를 헤더에 담아 보냄. : ACCESS_TOKEN 설정
                axios.defaults.headers.common['Authorization'] = `${response}`;

                // ACCESS_TOKEN 만료되기 1분 전 로그인 연장
                setTimeout(onSilentRefresh, JWT_EXPIRY_TIME - 60000);
            }
        })
        .catch(error=>{
            console.log(error)
        })
}

