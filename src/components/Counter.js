import React, { Component } from 'react'

class Counter extends Component { 
  state = {
    number: 0,
  }

  /************************ */
  /*
  Why? render는 render()로 만들어 놓고
  다른 것들은 arrow function으로 만드는가?
  => 해결책 : constructor 생성하여 this를 지정해주면 된다!
   */

  //constructor : 컴포넌트가 만들어질 때마다 호출되는 함수
  constructor(props){
    super(props);
    this.handleIncrease = this.handleIncrease.bind(this); //여기서 사용하는 this가 constructor 내부의 this다.를 명시적으로 
    this.handleDecrease = this.handleDecrease.bind(this);
  }

  //변화를 주기 위한 custom method
  handleIncrease() {
    //여기서 this : undefined
    console.log(this); // af를 사용하지 않고 일반 함수로 정의한 경우 this가 뭔지 모르게 된다.
    this.setState({
      number: this.state.number +1
    })
  } 
  
  handleDecrease() {
    console.log(this);
    this.setState({
      number: this.state.number -1
    })
  } 

  render() {
    return (
      <div>
        <h1>카운터</h1>
        <div>값: {this.state.number}</div>
        <button onClick={this.handleIncrease}>+</button>
        <button onClick={this.handleDecrease}>-</button>
      </div>
    )
  }
}

export default Counter