import React from 'react'; 

function Food({name, picture}){ 
  return <div>
    <h2>I like {name}</h2>
    <img src={picture} />
  </div>; 
}

const foodILike = [
  {
    name : "Kimchi",
    image : "https://ssl.pstatic.net/tveta/libs/1347/1347740/67d946ab154f0a6844c2_20210723140836041.png"
  },
  {
    name : "Samyeopsal"
  },
  {
    name : "coffee"
  },
  {
    name : "peach"
  }
];

function App() {
  return (
    <div>
      {foodILike.map(dish => <Food name={dish.name} picture={dish.image}/>)}
    </div>
  );
}

export default App;
