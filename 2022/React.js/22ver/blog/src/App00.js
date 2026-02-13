//App.js = 하나의 컴포넌트

import './App.css';
import Hello from './Hello';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <p>
          Hi, React.js!
          Here is App.js.
        </p>
      </header>
        <Hello message="hi 123456 react"/>
    </div>
  );
}

export default App;
