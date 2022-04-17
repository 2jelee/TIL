/* eslint-disable */

function Product(props) {
  return(
    <div className="col-md-4">
      {/* i가 1부터 시작하도록 +1 해줌 */}
      <img src={'https://codingapple1.github.io/shop/shoes'+ (props.i + 1) +'.jpg'} alt="" width="100%" />
      <h4>{ props.shoes.title }</h4>
      <p>{ props.shoes.content }</p>
      <p>{ props.shoes.price }</p>
    </div>
  )
}

export default Product