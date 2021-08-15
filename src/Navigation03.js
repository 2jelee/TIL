import React from 'react'
import { Link } from 'react-router-dom';
import "./Navigation.css";

function Navigation() {
    return (
        <div className="nav">
            <Link to="/">Home</Link>
            <Link to="/about">About</Link>
        </div>
    );
}

export default Navigation;
/*
현재 Navigation.js는 a태그를 사용함으로써 html 상태이므로
네비게이션바를 클릭 시 페이지 자체가 새로고침 됨.
  >> 리액트가 죽고 새 페이지가 새로고침 되는 상태

해결방법] Link라는 것을 import.
기억해야할 2가지
    1. Link를 router밖에서 사용할 수 없음. (App06.js 주석 확인)
*/