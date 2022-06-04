// 데이터 서비스
// 서버에서 데이터를 검색하는 방법도 있습니다. 보호된 리소스에 액세스하는 경우
// HTTP 요청에는 Authorization 헤더가 필요합니다.

// auth-header.jsauthHeader() 내부 에 호출되는 도우미 함수를 만들어 보겠습니다 .

export default function authHeader() {
    const user = JSON.parse(localStorage.getItem('user'));
    if (user && user.accessToken) {
        return { Authorization: 'Bearer ' + user.accessToken };
    } else {
        return {};
    }
}

// user위의 코드는 항목 에 대한 로컬 저장소를 확인합니다 . (JWT) 로 로그인한 경우
// userHTTP accessTokenAuthorization 헤더를 반환합니다. 그렇지 않으면 빈 객체를 반환합니다.