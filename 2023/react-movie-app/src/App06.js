import React from 'react'; 
import PropTypes from "prop-types";

class App extends React.Component{
  state = {
    count: 0
  };
  add = () =>{
    console.log("add"); 
    /*this.state.count = 1;   << Do not mutate state directly. Use setState() 
                                이렇게 직접적으로 변경한다면 react는 render function을 refresh하지 않는다.
                                즉, 매번 state의 상태를 변경할때 react가 render function을 호출해서 바꿔주길 원한다는 의미.
                                state는 object이고 따라서 setState는 새로운 state를 받아야하므로 setState({count:1})을 한다.

                                state를 바꾸고(update)싶을 경우, 결론] 
                                                  setState를 사용하지 않으면 새 state와 함께 render function이 호출되지 X
    */
    this.setState({count:1}); /*setState()를 호출하면 react는 state를 refresh하고 또한, render function을 호출함. */
  };
  minus = ()=>{
    console.log("minus");
    /*this.state.count = -1;*/
    this.setState({count:-1});
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
과연 App에서 data를 어떻게 바꿀 것인가?


<button onClick={this.add}>Add</button> 옳
<button onClick={this.add()}>Add</button> 틀림. << click했을 때만 function이 호출되길 원하므로. 즉시가 아님.
                                                   ()는 즉시 나타냄.
*/

export default App;
