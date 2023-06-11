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

/* 순서 2. item 이름을 dish로 정함 */
function renderFood(dish){ 
  return <Food name={dish.name} picture={dish.image} />;
}
/* return하는 이유 >> map은 여기서 뭐가 돌아오든 array로 돌려주므로 */

function App() {
  return (
    <div>
      {console.log(foodILike.map(renderFood))} {/*여기서 console.log하는 이유? 이게 어떻게 생겼는지 보여주기 위해서 */}
      {foodILike.map(renderFood)}
    </div>
    /* 순서 1. 여기서 map은 각각 item별로 function을 호출함 */
  );
}

export default App;
