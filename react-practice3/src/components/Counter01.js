import React, { Component } from 'react'

class Counter extends Component {
  //state는 객체라고 정의
  state = {
    number: 0,
  }

  //변화를 주기 위한 custom method
  handleIncrease = () => {
    this.setState({
      number: this.state.number +1
    })
  } 

  handleDecrease = () => {
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