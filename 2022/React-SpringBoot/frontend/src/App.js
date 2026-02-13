import React, {useEffect, useState} from 'react';
import axios from 'axios';
import './App.css';

function App() {
    const [test, setTest] = useState('')
    useEffect(() => {
        axios.get('/tttt')
            .then(response => setTest(response.data))
            .catch(error => console.log(error))
    }, []);
  return (
      <>
          <div>
              BE test : {test}
          </div>
          <div className="App">
              <header className="App-header">
                  <h2>LOGIN</h2>
                  <form action="post">
                      <input type="text" placeholder="ID" /> <br/>
                      <input type="password" placeholder="PASSWORD" />
                  </form>
              </header>
          </div>
      </>
  );
}

export default App;
