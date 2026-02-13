import React, { Component } from 'react'

class Box extends Component {
  render() {
    return (
      <>
        <div>
          <p> 상품명 <input type="text" /></p> 
          <p> 수 량 <input type="text" /></p> 
          <input type='button' value='add'/>
        </div>
      </>
    )
  }
}

export default Box