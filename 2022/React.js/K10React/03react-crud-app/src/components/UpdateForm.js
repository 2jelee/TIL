import React, {Component} from "react";

//게시물 수정을 위한 수정폼
class UpdateForm extends Component{
    //state를 추가하기 위한 생성자 선언
    constructor(props){
        super(props);
        //props로 전달된 데이터를 state로 초기화한다.
        this.state = {
            id : this.props.readData.id,
            title : this.props.readData.title,
            desc : this.props.readData.desc
        }
    }
    /*
    각 input상자에서 입력한 내용이 있을때 state값을 변경하기 위한 화살표 함수.
    setState의 name부분은 input의 name, 그리고 state의 key와 동일한 값을 가진다.
    (변경값들이 적용 되어진다.)
    */
    inputChangeHandler = (e) => {
        this.setState({[e.target.name] : e.target.value});
    }

    render(){
        return (
            <article>
                <h2>Update</h2>
                {/* submit 이벤트 리스너에서 이벤트 객체를 통해 입력한 값을 전송한다. */}
                <form action="/create_process" method="post" onSubmit={function(e){
                    e.preventDefault();
                    this.props.onSubmitValue(
                        e.target.id.value,
                        e.target.title.value,
                        e.target.desc.value
                    );
                }.bind(this)}>
                {/*기존 게시물에 대한 수정이므로 게시물 아이디를 저장할 Hidden 상자가 필요함. */}
                {/*
                App.js에서 기존 게시물을 읽어온 후
                props를 통해 전달한 데이터를 각 input상자에 삽입함. 하지만 값을 수정하는 것은 불가능함.
                props는 읽기전용(readOnly)이므로 '값에 대한 수정'을 하기 위해서는 '반드시 state'를 통해서만 가능!
                */}
                {/*
                읽기전용인 props값은 변경할 수 없으므로 state값을 통해 입력값을 변경한다.
                값이 변경될때 onChange이벤트를 통해 inputChangeHandler() 함수를 호출하여 state값을 변경시킨다.
                */}
                    <input type="hidden" name="id" value={this.state.id} />
                    <p><input type="text" name="title" placeholder="제목입력"
                            value={this.state.title}
                            onChange={this.inputChangeHandler} /></p>
                    <p><textarea name="desc" placeholder="내용입력"
                            value={this.state.desc} 
                            onChange={this.inputChangeHandler}></textarea></p>
                    <p><input type="submit" value="전송" /></p>
                </form>
            </article>
        );
    }
    
}

export default UpdateForm