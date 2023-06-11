import React from 'react'; 

function Food({fav}){ 
  return <h1>I like {fav}</h1>;
}

function App() {
  return (
    <div>
      <h1>G HELLO</h1>
      <Food fav = "kimchi"/> 
      <Food fav = "ramen"/> 
      <Food fav = "chukumi"/>  
    </div>
  );
}

export default App;
