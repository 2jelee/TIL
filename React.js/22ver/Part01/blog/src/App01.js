import './App.css';
import logo from './logo.svg';

function App() {
  let post = '인천광역시'
  let add_style = { color: 'blue', fontSize: '30px' }

  function count() {
    return 100
  }
  return (
    <div className="App"> 
      <div className='black_nav'>
        <div style={ add_style }>
        개발 blog
        </div>
      </div>
      <img src={ logo } alt="" />
      <h4>{ post }</h4>
      <h4> { count() }</h4>
    </div>
  );
}

export default App;
