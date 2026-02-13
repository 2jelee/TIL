/* eslint-disable */

import React, { useContext, useState, createContext } from "react";
import { Navbar, Nav, NavDropdown, Button } from "react-bootstrap";
import "./App.css";
import Data from './data.js'
import Card from "./Card";

import { Link, Route, Switch } from 'react-router-dom'
import Detail from "./Detail";
import axios from "axios";

// 1. 전역 컨텍스트 변수 생성
// export let InventContext = React.createContext();

function App(e) {

  let [shrit, setShrit] = useState(Data);

  // let [invent, setInvent] = useState([9, 8, 12]);
  let invent = useContext(InventContext)


  return (
   
    <div className="App">
      <div className="container">
      <Navbar bg="light" expand="lg">
        <Navbar.Brand to="/">여성의류 쇼핑몰</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link as={Link}  to="/">Home</Nav.Link>
            <Nav.Link as={Link} to="/detail/0">상세페이지</Nav.Link>
            <NavDropdown title="드롭메뉴" id="basic-nav-dropdown">
              <NavDropdown.Item><Link to="/cart">Cart</Link></NavDropdown.Item>
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
      
     {/* <div>
      <Change />
     </div> */}

    
      <div className="container" >
        <div className="row">
        {/* <InventContext.Provider value={invent}> */}
          <div className="col">
            {
              shrit.map((a, i) => {
                return  <Card shrit={shrit[i]} i={i} key={i} />
              })
            }
          </div>
          {/* </InventContext.Provider> */}
        </div>
      </div>
      
      </Route>

      <Route  path="/detail/:id">  
        {/* <InventContext.Provider value={invent}> */}
          <Detail shrit={shrit} invent={invent} setInvent={setInvent} />
        {/* </InventContext.Provider> */}
      </Route>
     
      <Route path="/cart">
        <div>장바구니</div>
      </Route>
    </Switch>
    </div>

    <button className="btn btn-primary" 
          onClick={()=>{
            // fetch('https://raw.githubusercontent.com/ai-edu-pro/busan/main/data2.json')
          // .then()
          // .catch()

          // axios.post('서버URL', {id: 'kingsmile', pw : 1234 }).then().catch()
          // axios({
          //     method: get,
          //     url: 'https://raw.githubusercontent.com/ai-edu-pro/busan/main/data2.json',

          //   }
          // )

          axios.get('https://raw.githubusercontent.com/ai-edu-pro/busan/main/data2.json')
          .then((result)=>{
              setShrit([...shrit, ...result.data]);
              // console.log(result.data)
          })
          .catch(()=>{
            console.log("실패!!")
          })
    }} >더보기</button>
    </div>
  );
}

function Test(){
  // let invent = useContext(InventContext);
  return <p>재고 : {invent[props.i]} </p>
}

export default App;
