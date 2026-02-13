import React from 'react';
import './App.css';
import { Routes, Route, Link } from 'react-router-dom';
import Login from "./routes/Login";
import Home from "./routes/Home";

function App() {
    return (
      <>
          <Link to="/">HOME</Link>&nbsp;
          <Link to="/login">LOGIN</Link>

          <Routes>
              <Route path="/" element={<Home />} />
              <Route path="/login" element={<Login />} />
              {/* 404 page */}
              <Route path="*" element={<div> 없는 페이지 </div>} />
          </Routes>

          {/*<div>*/}
          {/*    BE test : {test}*/}
          {/*</div>*/}
      </>
  );
}

export default App;
