import React, { createContext, useContext, useState } from "react";
import ContextCtx  from "./ContextCtx";


export let InventContext = createContext();

function ContextComponent() {

    let [text, setText] = useState('hello');

    let invent = useContext(invent)

    return(
        <>
        <InventContext.provider value={invent} >
            <TestCtx text={text} />
        </InventContext.provider>
        </>
    )


}


function TestCtx() {  // props 사용 안했음

    let [message, setMsg] = useState('반갑죠!!');
    let invent = useContext(invent)

    // return <h1 style={{color: 'red'}}>context Test : { props.text } </h1>
    return (
        <>
            <h1>context Test : { invent.message } </h1>

            <ContextComponent.provider value={invent} >
                 <TestCtx2 message={message} setMsg={setMsg} />
            </ContextComponent.provider>
        </>
    )
}


function TestCtx2(){  // props 기재 안해도 적용됨
    let invent = useContext(invent);

    // return <h1 style={{color: 'red'}}>context Test : { props.text } </h1>
    return (
        <>
          <h1>ContextCtx : { invent } </h1>

        <ContextComponent.provider value={invent} >
            <h1>context ContextCtx : { invent } </h1>
            <ContextCtx invent={invent} />
        </ContextComponent.provider>
        </>
    )
}

export default {ContextComponent, TestCtx, ContextCtx};