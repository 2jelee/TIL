import React from 'react'; 
import PropTypes from "prop-types";

class App extends React.Component{
  constructor(props){
    super(props);
    console.log("hello");
  }
    state = {
      count: 0
    };
  add = () =>{ 
    this.setState(current => ({count : current.count +1})); 
  };
  minus = ()=>{ 
    this.setState(current => ({count : current.count -1})); 
  };
  componentDidMount(){
    console.log("component rendered");
  } //render 후 이것 출력됨. 
  componentDidUpdate(){
    console.log("I just updated")
  }
  /* 
  결론] 
    Add버튼을 눌러(예시일뿐) setState를 호출하면 component를 호출하고
    먼저 render를 호출한 다음, 업데이트가 완료됬다고 말하면 componentDidUpdate가 실행된다.

    setState - component ? - render - componentDidUpdate
  */

  componentWillUnmount(){
    console.log("GoodBye")
  }


  render(){ 
    console.log("I am rendering");
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

life cycle method ]
    기본적으로 react가 component를 생성, 없애는 방법이다.
    component가 생성될 때 render전에 호출되는 몇가지 function이 존재.
    component가 render된 후 호출되는 다른 function들이 존재.
    component가 update될 때 호출되는 다른 function도 존재.

    1. Mounting : 태어나는 것과 같다.
    2. Updating : 일반적인 업데이트
    3. Unmounting : component가 죽는 것. >> 페이지를 바꿀 때, state를 사용해서 component를 교체하는 등 다양한 방법 존재.

    [Mounting]
    -component가 mount될 때, component가 screen에 표시될때, component가 Website에 갈 때 constructor를 호출함.
    -componentDidMount() : "이 component는 처음 render 되었다"고 알려준다.

    [Update]
    -업데이트의 원인? 바로 나!
    -
*/

export default App;
