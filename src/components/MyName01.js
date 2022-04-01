import React, { Component } from 'react'

//rce : 클래스형 Component 만들기
class MyName extends Component {
  //2. 기본값으로 사용하는 방법 (App.js return 부분에서 <MyName name="2jelee" /> 값을 빠뜨리고 <MyName/>만 있는 경우 )
  // static으로 하는 것이 최신 JS 문법
  static defaultProps = {
    name: '기본 이름'
  }

  //1.{this.props.~}로 불러오기
  render() {
    return (
      <div>안녕하세요. 제 이름은 <b>{this.props.name}</b>입니다. </div>
    )
  }
}

export default MyName