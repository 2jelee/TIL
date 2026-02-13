import React, { Component } from 'react'

//class
class Mycomponent extends Component {
  static defaultProps = {
    name: '플라밍고'
  }
  render() {
    return (
      <div>내 이름은 {this.props.name}야.</div>
    )
  }
}

export default Mycomponent