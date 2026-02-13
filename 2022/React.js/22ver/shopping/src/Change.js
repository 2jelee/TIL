import React, { Component, useEffect } from "react";

// function Change() { return(); }

class Change extends Component {

    componentDidMount(){
        // Change 컴포넌트가 Mount 되고나서 실행할 코드
    }

    componentWillUnmount() {
        // Change 컴포넌트가 Unmount 되기전에 실행할 코드
    }
  
}

function Update() {
    useEffect(()=>{
        // 코드 
    });

    return(
        <></>
    )
}

export default {Change, Update};