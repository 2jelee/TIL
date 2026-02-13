import React from 'react';

function Detail(props) {
    console.log(props);
    return <span>hello</span>;
}

export default Detail;
/*
Link를 통해 정보를 라우터로 보내고 있음. 이는 라우터에서 사용할 수 있음.
movie-detail 페이지에서 개발자모드에서 확인한 props에서
location안의 state에 genres, poster, summary, title, year를 확인 O. << Movie.js에서 보낸.


*/