import React from 'react'
import { Carousel } from 'react-bootstrap';

function Carous() {
  return (
    <>
    <Carousel>
        <Carousel.Item>
          <img
            className="d-block w-100"
            src="/images/1.jpg"  
            alt="First slide"
          />
          <Carousel.Caption>
            <h1 className='carousel_title'>20% Seasons Off</h1>
            <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
          </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item>
          <img
            className="d-block w-100"
            src="/images/2.jpg"  
            alt="Second slide"
          />

          <Carousel.Caption>
            <h3>Second slide label</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
          </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item>
          <img
            className="d-block w-100"
            src="/images/3.jpg"   
            alt="Third slide"
          />

          <Carousel.Caption>
            <h3>Third slide label</h3>
            <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
          </Carousel.Caption>
        </Carousel.Item>
      </Carousel>
    </>
  )
}

export default Carous