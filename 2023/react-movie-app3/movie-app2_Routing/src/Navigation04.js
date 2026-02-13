import React from 'react'
import { Link } from 'react-router-dom';
import "./Navigation.css";

function Navigation() {
    return (
        <div className="nav">
            <Link to="/">Home</Link>
            <Link to={{
              pathname:"/about", /* url로 정보를 보낼 수 있으나 이 방법이 더 깔끔 */
              state:{
                  fromNavigation: true
                }
            }}
            >About</Link>
        </div>
    );
}

export default Navigation;
/*
하고자 하는 것 : movie를 클릭하면 movie 디테일 페이지로 이동.

react-router의 공식문서]
    Link to=
    에서 이 to를 교체할 수 있다. string으로.
    이를 object로 변경할 수 있도록 허용됨.

    여기에서는 pathname과 state를 정의할 것. >> to={{}} << object
    state를 보내는 부분..
        pathname:"/about",
        state:{
            fromNavigation: true
        }
    >> 개발자가 about페이지로 obj를 보냄

정리] 
링크를 클릭하면 리액트 라우터는 /about으로 이동하고
바로 컴포넌트 About이 되어야 함. 또한, props도 보내고 있음.(route로 정보를 보내는.)

*/