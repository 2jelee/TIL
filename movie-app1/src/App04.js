import React from 'react'; 
import PropTypes from "prop-types";
//node.js에 [명령어] npm i prop-types : 내가 전달받은 props가 내가 원하는 props인지를 확인해주는. 실수한 것을 알려주는 역할.

const foodILike = [
  {
    id : 1,
    name : "Kimchi",
    image : "https://ssl.pstatic.net/tveta/libs/1347/1347740/67d946ab154f0a6844c2_20210723140836041.png",
    rating : 5
  },
  {
    id : 2,
    name : "Samyeopsal",
    rating : 4.9
  },
  {
    id : 3,
    name : "coffee",
    rating : 4.8
  },
  {
    id : 4,
    name : "peach",
    rating : 4.7
  }
];

function Food({name, picture, rating}){ 
  return <div>
    <h2>I like {name}</h2>
    <h4>평점 : {rating}/5.0</h4>
    <img src={picture} alt={name} /> 
  </div>; 
}

//여기서 prototype를 통해 props를 체크 (prototype는 이름 변경X)
Food.prototype = {
  name: PropTypes.string.isRequired,
  picture: PropTypes.string.isRequired,
  rating: PropTypes.number
};

function App() {
  return (
    <div>
      {foodILike.map(dish => (
        <Food key={dish.id} name={dish.name} picture={dish.image} rating={dish.rating}/>
      ))}
    </div>
  );
}

export default App;
