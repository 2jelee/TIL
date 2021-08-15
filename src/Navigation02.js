import React from 'react'

function Navigation() {
    return (
        <div>
            <a href="/">Home</a>
            <a href="/about">About</a>

        </div>
    )
}

export default Navigation;
/* 
현재 Navigation.js는 a태그를 사용함으로써 html 상태이므로
네비게이션바를 클릭 시 페이지 자체가 새로고침 됨.
  >> 리액트가 죽고 새 페이지가 새로고침 되는 상태
*/