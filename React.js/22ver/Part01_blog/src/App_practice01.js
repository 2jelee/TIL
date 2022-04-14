import React from 'react';
import logo from './logo.svg'
import './App.css';

function App() {
  let posts = '인천광역시'
  return (
    <div className='App'>
      <div className="black_nav">
        개발 blog
      </div>
    <img src={ logo } alt="" />
    <h4>{ posts }</h4>
    </div>
  )
}

export default App