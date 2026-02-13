/* eslint-disable */

import { useState } from "react";
import { Navbar, Nav, NavDropdown, Button } from "react-bootstrap";
import "./App.css";
import Data from "./data.js";
import Card from "./Card";

import { Link, Route, Switch } from "react-router-dom";
import Detail from "./Detail";

function App(e) {

  let [shrit, setShrit] = useState(Data);

  return (
    <div className="App">
      <Navbar bg="light" expand="lg">
        <Navbar.Brand href="#home">여성의류 쇼핑몰</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link as={Link} to="/">
              Home
            </Nav.Link>
            <Nav.Link as={Link} to="/detail">
              상세페이지
            </Nav.Link>
            <NavDropdown title="드롭메뉴" id="basic-nav-dropdown">
              <NavDropdown.Item>
                {/* <a href="" > KBS </a> */}
                <Link to="/cart">Cart</Link>
              </NavDropdown.Item>
              <NavDropdown.Item href="#action/3.2">
                Another action
              </NavDropdown.Item>
              <NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item href="#action/3.4">
                Separated link
              </NavDropdown.Item>
            </NavDropdown>
          </Nav>
        </Navbar.Collapse>
      </Navbar>

      <Switch>
        <Route exact path="/">
          <div className="jumbotron">
            <p className="jp">
              <Button variant="primary">Learn more</Button>
            </p>
          </div>

 
          <div className="container">
            <div className="row">
              {shrit.map((a, i) => {
                return <Card shrit={shrit[i]} i={i} key={i} />;
              })}
            </div>
          </div>
        </Route>

        <Route path="/detail/0">
          <Detail shirt={shirt[0]} i={0} />
        </Route>

        {/* <Route path="/detail/1">
          <Detail shirt={shirt[1]} i={1} />
        </Route>
        <Route path="/detail/2">
          <Detail shirt={shirt[2]} i={2} />
        </Route> */}

       <Route  path="/detail/:id">
        <Detail shrit={shrit} />
      </Route>
       {/* <Route  path="/:id">
        <Detail shrit={shrit} />
      </Route>  */}

        <Route path="/cart">
          <div>장바구니</div>
        </Route>
      </Switch>
    </div>
  );
}



export default App;
