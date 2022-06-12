import React from 'react';
import { useNavigate } from 'react-router';
import { useDispatch } from 'react-redux';
import { useForm } from 'react-hook-form';
import { loginUser } from '../auth/Users';
import { setRefreshToken } from '../auth/Cookie';
import { SET_TOKEN } from '../auth/Auth';
import Fade from 'react-reveal';
import '../css/login.css'
import logo from '../img/logo_team.png';

function Login() {
    const navigate = useNavigate();
    const dispatch = useDispatch();

    // useForm 사용을 위한 선언
    const { register, setValue,
        formState: { errors },
        handleSubmit } = useForm();

    // submit 이후 동작할 코드
    const onValid = async ({ user_id, password }) => {
        const response = await loginUser({ user_id, password });

        if (response.status) {
            // 쿠키에 Refresh Token, store에 Access Token 저장
            setRefreshToken(response.text.refresh_token); // refresh_token을 Cookie에 저장
            dispatch(SET_TOKEN(response.text.access_token));
            alert('로그인 성공')
            console.log(response.status) //true
            console.log(response) // status ...
            console.log(response.text)
            return navigate("/");
        } else {
            alert('사번과 PASSWORD를 다시 한번 확인하세요.')
            console.log(response.text);
        }
        // 실패 시 초기화
        setValue("user_id", "");
        setValue("password", "");
    };

    // Login 버튼을 누르면
    // function LoginBtn() {
    //     alert("jj");
    // }

    return (
        <>
            <div className="login-bg" />
            <Fade bottom>
                <form className='form-login' onSubmit={handleSubmit(onValid)}>
                    <div>
                        <img className="logo" src={logo} alt="logo" />
                    </div>
                        {/*<img src="../img/logo_team.png" alt="logo-team" width='300px' height='auto' />*/}
                    {/*</div>*/}
                    <div className="form-input">
                        <input {...register("user_id")} type="text" placeholder="사 번" />
                    </div>
                    <div className="form-input">
                        <input {...register("password")} type="password" placeholder="비밀번호" />
                    </div>
                    <div>
                        <button className="btn-login" type="submit">LOGIN</button>
                    </div>
                </form>
            </Fade>
        </>
    );
}

export default Login;