const API_BASE_URL = 'http://localhost:8080';

export function call(api, method, request) {
    let options = {
        headers: new Headers({
            "Content-Type": "application/json",
        }),
        url: API_BASE_URL + api,
        method: method,
    };
    if (request) {
        // GET method
        options.body = JSON.stringify(request);
    }
    return fetch(options.url, options)
        .then((response) =>
            response.json().then((json) => {
                if (!response.ok) {
                    // response.ok가 true이면 정상적인 리스폰스를 받은것, 아니면 에러 리스폰스를 받은것.
                    return Promise.reject(json);
                }
                return json;
            })
        )
        .catch((error) => {
            // 추가된 부분
            alert("error 발생 : ApiService: undefined / Unexpected token e ins JSON at position 0");
            console.log(error.status);
            if (error.status === 403) {
                window.location.href = "/"; // redirect
            }
            return Promise.reject(error);
        });
}

export function login(LoginDto) {
    return call("/login", "POST", LoginDto).then((response) => {
        console.log("response :" + response);
        alert("Login 토큰 : " + response.token)
    });
}