import React from 'react'; 
import PropTypes from "prop-types";

class App extends React.Component{
  state = {
    count: 0
  };
  add = () =>{ 
    //this.setState({count : this.state.count +1}); // state값에 계속적 증가 (단, bad code << state를 사용하므로)
    this.setState(current => ({count : current.count +1})); // good code : state를 set할 때 react에서 외부의 상태에 의존하지 않는 가장 좋은 방법
  };
  minus = ()=>{ 
    this.setState(current => ({count : current.count -1})); // 매순간 setState를 호출할 때마다 react는 새로운 state와 함께
                                                            // render function을 호출한다! (rerender)
  };

  render(){
    return (
      <div>
        <h1>The number is {this.state.count}</h1>
        <button onClick={this.add}>Add</button>
        <button onClick={this.minus}>Minus</button>
      </div>
    );
  }
}
/*
react component에서 사용하는 유일한 function은 render function이다.
*/

export default App;
