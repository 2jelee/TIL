import React, {Component} from 'react';

class MyComponents extends Component() { 
  state = {
    number: 0,
    message: '',
    validate: false,
    messages: ['Angular.js', 'React.js', 'Vue.js', 'Ember']
  }
  
  onDecrease = () => {
    this.setState({
      number: this.state.number -1
    })
  } 
  
  handlerClick = () => { 
    this.setState({
      validate: true 
    });
    this.myInput.focus();
  }
   
  handlerKeyPress = (event) => {
    const { messages, message } = this.state; 
    if(event.keyCode === 13){
      this.setState({
        messages: message.concat(message),
        message: ''  
      });
    }
  }; 
  handleDoubleClick=(index)=>{
    this.setState({ 
      messages: this.state.messages.filter( (item, idx) => idx !== index )
    })
  }

  render(){ 
    const {msg, age} = this.props;  
    const {number, message, validate, messages} = this.state;
    const{ onDecrease, handleDoubleClick, handlerKeyPress, handlerClick } = this.event;
    const message_list = messages.map((item, idx) => {
      <li key={idx} onDoubleClick={ () => handleDoubleClick(idx) }>{item}</li>
    });

    return(
      <>
        <h3>MyComponents의 return문 { this.props.msg } </h3> 
      </>
    );
  };
}


export default MyComponents;