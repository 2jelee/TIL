import React, {useEffect, useState} from 'react';
import axios from "axios";

function Login() {

    return (
        <div className="App">
            <header className="App-header">
                <h2>LOGIN</h2>
                <form method="post">
                    {/*<form noValidate onSubmit={this.handleSubmit}>*/}
                    {/*    {" "}*/}
                    {/* submit 버튼 클릭 시 handleSubmit 실행됨 */}
                    <input type="text" id="user_id" name="user_id" placeholder="ID" /> <br/>
                    <input type="password" id="password" name="password" placeholder="PASSWORD" /> <br/>
                    <button type="submit" onClick={onSubmit}>
                        LOGIN
                    </button>
                </form>
            </header>
        </div>
    );
}

export default Login;