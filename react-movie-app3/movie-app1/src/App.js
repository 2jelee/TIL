import React from 'react';  

class App extends React.Component {
  state = {
    isLoading: true,
    movies:[]
  };
  /*
  2. 미래에 쓰고자하는 state를 선언하는 것은 필수가 X
    future state, 단지 미래를 위해 계획한 것일 뿐, movie state 안에 movie의 array를 가지고 있음.
    처음부터 movies:[] << 이 부분에 선언할 필요는 없음. 미래에 있을 수도 있는 것에 대한 것임.
  
    결론] state를 추가하는 것은 자유다.
          setState를 사용할 때 state안에 default 값들을 선언할 필요는 없다!
  */

  // render 다음 호출되므로 6000의 시간이 지나면 삼항연산자의 뒷부분 ""이 호출된다. >> 동적!
  componentDidMount(){
    setTimeout(()=>{
      this.setState({isLoading: false, book: true}); //1. 여기서 사용하지 않는 book을 추가한다면? error? NO!
    }, 6000);
  }

  render() {  
    const { isLoading} = this.state;
    return <div>{isLoading ? "Loading..." : "We are ready!!"}</div>;
  }
}

export default App;
