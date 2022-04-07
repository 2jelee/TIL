import React, { useContext, useState } from "react";

// import ContextComponent from './ContextComponet'

function ContextCtx(){
    let message = useContext(message)
 
    return(
        <div>
            <h1>{message}</h1>
            <p>ContextCtx component window</p>
        </div>
    )
}

export default ContextCtx;