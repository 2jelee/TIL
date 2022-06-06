import { useEffect } from 'react';
import { useNavigate } from 'react-router';
import { useDispatch, useSelector } from 'react-redux';
import { Link } from 'react-router-dom';
import { getCookieToken, removeCookieToken } from './Cookie';
import { DELETE_TOKEN } from './Auth';
import { logoutUser } from './Users';


function Logout(){
    // store에 저장된 Access Token 정보를 받아 온다
    // const { accessToken } = useSelector(state => state.token);

    const ACCESS_TOKEN = useSelector((state) => { return state })

    const dispatch = useDispatch();
    const navigate = useNavigate();

    // Cookie에 저장된 Refresh Token 정보를 받아 온다
    const refreshToken = getCookieToken();

    async function logout() {
        // 백으로부터 받은 응답
        const data = await logoutUser({ refresh_token: refreshToken }, ACCESS_TOKEN);

        if (data.status) {
            // store에 저장된 Access Token 정보를 삭제
            dispatch(DELETE_TOKEN());
            // Cookie에 저장된 Refresh Token 정보를 삭제
            removeCookieToken();
            return navigate("/");
        } else {
            window.location.reload();
        }
    }

    // 해당 컴포넌트가 요청된 후 한 번만 실행되면 되기 때문에 useEffect 훅을 사용
    useEffect( () => {
        logout();
    }, [])

    return (
        <>
            <Link to="/" />
        </>
    );
}

export default Logout;

//정상적인 응답이 왔을 경우 removeCookieToken 을 통해 Cookie에 저장된 Refresh Token 정보와 dispatch()를 통해 store에 저장된 Access Token 정보를 모두 삭제한다
// Cookie와 store에서 데이터를 모두 삭제한 후 홈으로 이동한다.
// 로그아웃에 대한 요청은 해당 컴포넌트 요청 후 한 번만 실행되면 되기 때문에 useEffect 훅을 사용했으며, deps를 비워 두었다.