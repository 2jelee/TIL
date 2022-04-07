/* eslint-disable */

import { useState } from "react";
import { Navbar, Nav, NavDropdown, Button } from "react-bootstrap";
import "./App.css";
import Data from "./data.js";
import Card from "./Card";

import { Link, Route, Switch } from "react-router-dom";
import Detail from "./Detail";
import Cart from "./Cart";

//1.
// export let InventContext = React.createContext();

function App(e) {
  let [shrit, setShrit] = useState(Data);

  // 2. 재고, 전달할 데이터
  // let [invent, setInvent] = useState([9, 10, 11]);

  return (
    <div className="App">
      <div className="container">
        <Navbar bg="light" expand="lg">
          <Navbar.Brand to="/">여성의류 쇼핑몰</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <Nav.Link as={Link} to="/">
                Home
              </Nav.Link>
              <Nav.Link as={Link} to="/detail/0">
                상세페이지
              </Nav.Link>
              <NavDropdown title="드롭메뉴" id="basic-nav-dropdown">
                <NavDropdown.Item>
                  <Link to="/cart">Cart</Link>
                </NavDropdown.Item>
                <NavDropdown.Item href="#action/3.2">
                  Another action
                </NavDropdown.Item>
                <NavDropdown.Item href="#action/3.3">
                  Something
                </NavDropdown.Item>
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

            {/* <div>
      <Change />
     </div> */}

            <div className="container">
              <div className="row">
                {/* 3. 전달할 컴포넌트 감싸다 */}
                {/* <InventContext.Provider value={invent} > */}
                  <div className="col">
                    {shrit.map((a, i) => {
                      return <Card shrit={shrit[i]} i={i} key={i} />;
                    })}
                  </div>
                {/* </InventContext.Provider> */}
              </div>
            </div>
          </Route>

          <Route path="/detail/:id">
            <Detail shrit={shrit} />
          </Route>

          <Route path="/cart">
            <Cart />
          </Route>
        </Switch>
      </div>
    </div>
  );
}

export default App;
