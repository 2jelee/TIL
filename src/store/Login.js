import { useNavigate } from 'react-router';
import { useDispatch } from 'react-redux';
import { useForm } from 'react-hook-form';
import { loginUser } from './Users';
import { setRefreshToken } from './Cookie';
import { SET_TOKEN } from './Auth';

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
            console.log(response.text) // refresh token 확인???? 아닌듯.
            return navigate("/");
        } else {
            alert('ID와 PASSWORD를 다시 한번 확인하세요.')
            console.log(response.text);
        }
        // 실패 시 초기화
        setValue("user_id", "");
        setValue("password", "");
    };

    return (
        <>
            <div className="App">
                <header className="App-header">
                    <div>
                        <h2>LOGIN</h2>
                    </div>
                    <form onSubmit ={ handleSubmit(onValid) }>
                        <div>
                            <div>
                                <input {...register("user_id")}
                                    type="text"
                                    placeholder="ID (사번)"
                                />
                            </div>
                            <div>
                                <input {...register("password")}
                                    type="password"
                                    placeholder="PASSWORD"
                                />
                            </div>
                        </div>
                        <div>
                            <button type="submit"> 로그인 </button>
                        </div>
                    </form>
                </header>
            </div>
        </>
    );
}

export default Login;