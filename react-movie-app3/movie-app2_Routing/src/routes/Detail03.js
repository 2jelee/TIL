import React from 'react';

function Detail({location}) {
    console.log({location});
    return <span>hello</span>;
}

export default Detail;
/*
Link를 통해 정보를 라우터로 보내고 있음. 이는 라우터에서 사용할 수 있음.
movie-detail 페이지에서 개발자모드에서 확인한 props에서
location안의 state에 genres, poster, summary, title, year를 확인 O. << Movie.js에서 보낸.

여기서 props대신 {location}을 넣어본다면?
    개발자 모드에서 location 확인해보면 state가 undefined임을 확인할 수 있음.

    이는 movie를 클릭하지 않고
    http://localhost:3000/#/movie-detail 를 할 경우, state가 없는 상태(undefined)가 됨. 
    >> 이를 핸들링 해야한다.
*/