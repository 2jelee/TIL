import React, { Component } from 'react'

//rce : 클래스형 Component 만들기
class MyName extends Component {
  //2. 삭제(MyName01.js 참고)

  //1.{this.props.~}로 불러오기
  render() {
    return (
      <div>
        안녕하세요. 제 이름은 <b>{this.props.name}</b>입니다. 
      </div>
    )
  }
}

//3. 따로 defaultProps를 class 바깥으로 빼서 기본값 지정하기
MyName.defaultProps = {
  name: '[기본값] 2jelee'
}

export default MyName