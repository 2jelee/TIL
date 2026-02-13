import React, {Component} from 'react';

class MyComponents extends Component() {
  // //생성자
  // constructor(props){
  //   super(props);
  //   this.state = {
  //     //상태 변수(state variable)
  //     number: 0
  //   }
  // } 

  //상태변수 선언 >> { } 객체
  state = {
    number: 0,
    message: '',
    validate: false,
    messages: ['Angular.js', 'React.js', 'Vue.js', 'Ember']
  }
 
  //event handler 함수 선언(arrow function)
  onDecrease = () => {
    this.setState({
      number: this.state.number -1
    })
  } 
  
  handlerClick = () => {
    //상태값 변화시키기
    // validate의 false를 true로 바꿔주겠다.
    this.setState({
      validate: true 
    });
    this.myInput.focus();
  }
  
  // 어떠한 키가 눌렸는가?
  // handlerKeyPress = (e) => {
  handlerKeyPress = (event) => {
    const { messages, message } = this.state;
    // if(event.keyCode === 'Enter'){
    if(event.keyCode === 13){
      this.setState({
        messages: message.concat(message),
        message: '' //초기화 해라
      });
    }
  };

  // (index) >> 마음대로 지정했음
  handleDoubleClick=(index)=>{
    this.setState({
      //filter 함수 : 골라줘라.
      messages: this.state.messages.filter( (item, idx) => idx !== index )
    })
  }

  render(){
    //변수 선언 << props를 통해 값 받아서 변수에 저장
    const {msg, age} = this.props; //한 번에 App.js의 msg와 age 받아옴
    const {number, message, validate, messages} = this.state;
    const{ onDecrease, handleDoubleClick, handlerKeyPress, handlerClick } = this.event;
    const message_list = messages.map((item, idx) => {
      <li key={idx} onDoubleClick={ () => handleDoubleClick(idx) }>{item}</li>
    });

    return(
      <>
        <h3>MyComponents의 return문 { this.props.msg } </h3>
        {/* <ul>
          { message_list }
        </ul>  */}
      </>
    );
  };
}


export default MyComponents;