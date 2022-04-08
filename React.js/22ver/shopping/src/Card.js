import React from 'react' 
import { useHistory } from 'react-router-dom';
import Data from './data';

//반복적인 component를 function component로 만든다.
function Card(props) {
  // const dd = <Data/>;
  // let arr = [];

  // for (let i = 0; i < contents.length; i++) {
  //   arr.push()
  // }
  const history = useHistory(); 
  return (
    <>
      {/* lg : large */}
      <div className="col-md-4">
      <img src={
                `https://raw.githubusercontent.com/ai-edu-pro/busan/main/t`
                + props.i + 1 + `.jpg` } alt="test" /> 
        <h4 onClick={() => { history.push('/detail')}}>{ props.shirt.title }</h4>
        <h6>{ props.shirt.content }</h6>
        <p>{ props.shirt.price }</p>
      </div>
    </>
  );
}  

export default Card