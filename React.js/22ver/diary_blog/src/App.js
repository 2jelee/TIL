import React from 'react';
import './App.css';
import MyComponents from './components/MyComponents';

// props를 통해 값을 전달한다. 부모가 자식에게
function App() {
  const str = "React!";

  return ( 
    <div>
      <p>안녕</p>
      <MyComponents msg={ str } age={27} />
      <MyComponents age={100} />
      <MyComponents hi={'안녕하세요'} nai={99} />

      {/* <MyComponentsFunc /> */}

    </div> 
  );
}

export default App;
