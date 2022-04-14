/* eslint-disable */
import React from 'react' 
import { Navbar, Container, Nav } from 'react-bootstrap';
import { Link } from 'react-router-dom'

function Header() {
  return (
    <> 
      <Navbar bg="dark" variant="dark">
        <Container>
        <Navbar.Brand>
          <Link to="/">
            <img src="/logo192.png" width="30px" alt="" />공룡발
          </Link> 
        </Navbar.Brand>
        <Nav className="me-auto">
          <Nav.Link as={Link} to="/">Home</Nav.Link>
          <Nav.Link as={Link} to="/detail">Detail</Nav.Link>
          <Nav.Link as={Link} to="/">Features</Nav.Link>
          <Nav.Link as={Link} to="/">Pricing</Nav.Link>
        </Nav>
        </Container>
      </Navbar>
    </>
  )
}

export default Header