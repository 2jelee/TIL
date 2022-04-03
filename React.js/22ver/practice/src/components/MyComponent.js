import React, { Component } from 'react'

class MyComponent extends Component {
  state ={
    value: 0
  }

  //[getDerivedStateFromProps] static으로 값을 넣어주어야 한다.
  static getDerivedStateFromProps(nextProps, prevState){
    if(prevState.value !== nextProps.value){
      return{
        value: nextProps.value
      }
    }
    return null;
  }


  render() {
    return (
      <div>
        <p>props: {this.props.value}</p>
        <p>state: {this.state.value}</p>
      </div>
    )
  }
}

export default MyComponent