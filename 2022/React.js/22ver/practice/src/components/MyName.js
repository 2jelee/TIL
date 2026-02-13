import React from 'react'
// 함수형 컴포넌트를 만들 경우, 더 이상 import 시 Component까지 할 필요 없다.
/* 
import React를 사용하는 이유?
내부적으로 JSX 만들어질 때 React를 사용하므로 이를 유지해주어야 한다.
*/
/*
When 함수형 컴포넌트 사용?
- 초기 마운트 속도 조금 더 빠름 (컴포넌트 수가 많아졌을 때 최적화 가능)
- 불필요한 기능도 없으므로 메모리 자원 덜 사용 
*/

// rafce : 함수형 컴포넌트 만들기 
/*
{ name } [문법] 비구조할당 
: 하나의 객체 형태의 parameter인데 이 경우, name을 props로 받아와서 값을 사용하는.
*/

const MyName = ({ name }) => {
  return (
    <div>
      안녕하세요! 제 이름은 {name}입니다요.
    </div>
  )
} 

MyName.defaultProps = {
  name: 'rafce_함수형 컴포넌트'
}

export default MyName