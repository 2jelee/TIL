import React from 'react'; 
import PropTypes from "prop-types";
//node.js에 [명령어] npm i prop-types : 내가 전달받은 props가 내가 원하는 props인지를 확인해주는. 실수한 것을 알려주는 역할.

//클래스 컴포넌트 (React.Component를 extend)
class App extends React.Component{
  state = {
    count: 0
  }

  render(){
    return <h1>I'm a class component {this.state.count}</h1>;
  }
}
// class react component는 return을 가지고 있지 X
/*
function이 아니기 때문.
render method를 가지고 있고 App component 안에 있다. 이유? react compoent에서 확장했으므로!

Function component  VS  Class component
Function component는 function이고 무언가를 return함. 그리고 screen에 표시됨.
class component는 class이어야하지만 react component로부터 확장되고 screen에 표시됨.
  그것을 render method안에 넣어야함.
  리액트는 '자동적'으로 모든 class component의 render method를 실행하고자 한다.
*/
/*
class component를 이야기하는 이유?
  class component는 우리가 원하는 state를 가지고 있기 때문이다.
  state는 object이고,
    component의 data를 넣을 공간이 있고 '이 data는 변한다.' << state를 사용해야하는 이유
    ㄴ 내가 바꾸고 싶은 데이터를 state 안에 넣는다. ★★★
*/

export default App;
