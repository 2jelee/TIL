import React from 'react';
import "./About.css";

function About(props) {
    console.log(props);
    return (
        <div className="about__container">
          <span>
            “Freedom is the freedom to say that two plus two make four. If that is
            granted, all else follows.”
          </span>
          <span>− George Orwell, 1984</span>
        </div>
    );
}
    
export default About;
/*
props를 추가한 후 About페이지에서 개발자모드를 켜보면 props를 볼 수 있다.
history, location, match, staticContext.
이들은 아직 about으로 전송되지 않았음. 이것들은 react-router에 의해 넣어진 것임.
라우터에 있는 모든 라우트들은 props를 가진다. default로.

여기서 중요한 점 >> 이 props를 사용할 수 있다는 것임!
이로써 클릭 한 번으로 정보를 전달할 수 있게 된다.
그냥 about페이지로 가는 대신, 이 클릭은 정보를 보낼 수가 있다. props를 about 화면으로.

하고자 하는 것 : movie를 클릭하면 movie 디테일 페이지로 이동.

react-router의 공식문서] (Navigation.js 주석 확인)


*/
