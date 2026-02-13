import React, { Component } from 'react';
import './App.css';
import MyComponent from './components/MyComponent';
class App extends Component {
  // 일반 state
  // state = {
  //   a: '1'
  // }

  // [Mounting] constructor
  // constructor(props){
  //   super(props);
  //   this.state={
  //     a: '1'
  //   }
  // }

  // constructor와 super() 반드시 묶음으로!
  constructor(props){
    super(props);
    console.log('constructor');
  }

  // [Mounting] componentDidMount
  // componentDidMount(){
  //   console.log('componentDidMount');
  //   console.log(this.myDiv.getBoundingClientRect());
  //   // console.log(this.myDiv.getBoundingClientRect().width);
  // }
  render(){ 
    return ( 
      // <div ref={ref => this.myDiv = ref}>
      <div>
        <h1>Hi, React.js</h1>
        <MyComponent value={5}/>
        {/* props: value가 없을 경우, 값이 안나타남 */}
      </div>
    )
  }
}

export default App