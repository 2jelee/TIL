/* eslint-disable */
import { useContext } from 'react'
import { inventoryContext } from './App';

function Product(props) {
  // useContext라는 hook 사용
  // let inventory = useContext();
  // useContext(범위이름)로 공유된 값 사용
  let inventory = useContext( inventoryContext ); 

  return(
    <div className="col-md-4">
      <img src={'https://codingapple1.github.io/shop/shoes'+ (props.i + 1) +'.jpg'} alt="" width="100%" />
      <h4>{ props.shoes.title }</h4>
      <p>{ props.shoes.content }</p>
      <p>{ props.shoes.price }</p>
      <p>재고 : { inventory[props.i] }</p>
    </div>
  )
}

export default Product