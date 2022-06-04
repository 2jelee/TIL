import React, {useEffect, useState} from 'react';
import axios from 'axios';
import './App.css';
import {Routes, Route, Link} from 'react-router-dom';
import Login from "./routes/Login2jelee";
import Home from "./routes/Home";

function App() {
    // componentDidMount(){
    //     call("/login", "POST", null).then((response)=>{
    //         this.setState({items:response.data})
    //     })
    // }
    const [test, setTest] = useState('')
    useEffect(() => {
        // GET method -> POST
        axios.post('/postTTTT')
            .then(response => setTest(response.data))
            .catch(error => console.log(error))
    }, []);
    // const [test, setTest] = useState('')
    // useEffect(() => {
    //     // GET method -> POST
    //     axios.post('/postTTTT')
    //         .then(response => setTest(response.data))
    //         .catch(error => console.log(error))
    // }, []);

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

          <div>
              BE test : {test}
          </div>
      </>
  );
}

export default App;
