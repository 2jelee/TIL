import React from 'react'
import {HashRouter, Route} from "react-router-dom"

function App() {
  return <span>something</span>;
}

export default App;
/*
이곳(App.js)에 라우터를 만들 것.
여기 App.js 그냥 home을 return하는 대신에 우리는 router를 반환할 것임.

기본적으로 router는 매우 심플한 컴포넌트임.
만약 이 페이지에 있다면 home.js로 가거나 혹은 about에 있을때 About.js로 보냄.

라우터가 기본적으로 하는 일 : 라우터는 url을 가져다가 확인하고
                            우리가 무엇을 명령했는지에 따라..

HashRouter : HashRouter를 import하게 되면,,
  react-router-dom은 다른 종류들의 라우터들이 있다. 그중 HashRouter를 쓸 것이며
  또한 Route를 임포트할 것.
*/