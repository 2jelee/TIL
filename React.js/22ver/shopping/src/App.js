import { Navbar, Nav, NavDropdown, Button } from 'react-bootstrap';
import './App.css';

import Data from './data'; // Data라는 이름으로 쓰겠다.
import Card from './Card';
import { useState } from 'react';

// Router 사용하기
// npm i react-router-dom@5.2.0
// BrowserRouter : 서버까지 다녀옴 / HashRouter : 서버까지는 X
import { Link, Route, Switch } from 'react-router-dom'; 
import { Detail01, Detail02, Detail03 } from './Detail'; 
//라이브러리를 가져오므로 form ' ~ ' <-> 경로로 가져오는 것들은 라이브러리 X

function App(e) {
  //변경되어 사용되길 바란다 => useState
  let[shirt, setShirt] = useState(Data); //Data => data.js

  return (
    <div className="App">
      <Navbar bg="light" expand="lg">
          <Navbar.Brand><Link to="/">여성 의류 쇼핑몰</Link></Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <Nav.Link as={Link} to="/">Home</Nav.Link>
              <Nav.Link as={Link} to="/detail">상세페이지</Nav.Link>
              <NavDropdown title="Drop메뉴" id="basic-nav-dropdown">
                <NavDropdown.Item><Link to="/cart">abc</Link></NavDropdown.Item>
                <NavDropdown.Item><Link to="/cart">abc</Link></NavDropdown.Item>
                <NavDropdown.Item><Link to="/cart">abc</Link></NavDropdown.Item>
                <NavDropdown.Divider />
                <NavDropdown.Item><Link to="/cart">abc</Link></NavDropdown.Item>
              </NavDropdown>
            </Nav>
          </Navbar.Collapse>
      </Navbar>
      
      {/* <Switch> */}
        {/* <Route exact path="/"> */}
        <Route exact path="/">
          <div class="jumbotron">
            <p className='jp'>
              <Button variant="primary">Learn more</Button>
            </p>
          </div>

          <button onClick={ (e) => {
            console.log(e.target);
          }}>event</button>

          <div className="container">
            <div className="row">
              {
                shirt.map( (a, i) => {
                  return <Card shirt={shirt[i]} i={i} key={i} />
                })
              }
              <Card shirt={shirt} /> 
            </div>
          </div> 
        </Route>

        <Route path="/detail/01">
          <Detail01 /> 
        </Route>
        <Route path="/detail/02">
          <Detail02 /> 
        </Route>
        <Route path="/detail/03">
          <Detail03 /> 
        </Route>

        <Route path="/cart">
          <div>장바구니</div>
        </Route>
      {/* </Switch> */}
    </div>
  );
}


export default App;
