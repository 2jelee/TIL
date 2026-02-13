import React from "react";
import {login} from "../apis/ApiService";

class Login2jelee extends React.Component {
    constructor(props) {
        super(props);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(event){
        event.preventDefault();
        const data = new FormData(event.target);
        const user_id = data.get("user_id");
        const password = data.get("password");

        // ApiService의 login 메서드를 사용해 로그인
        login({user_id:user_id, password:password});
    }

    render(){
        return (
            <div className="App">
                <header className="App-header">
                    <h2>LOGIN</h2>
                    <form noValidate onSubmit={this.handleSubmit}>
                        <input type="text" name="user_id" id="user_id" placeholder="ID" required /> <br/>
                        <input type="password" name="password" id="password" placeholder="PASSWORD" required /> <br/>
                        <button type="submit"> 로그인 </button>
                    </form>
                </header>
            </div>
        );
    }
};

export default Login2jelee;