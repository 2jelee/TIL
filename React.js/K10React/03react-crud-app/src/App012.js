import React, {Component} from 'react';
import './App.css';

import Subject from './components/Subject';
import Navi from './components/Navi';
import Content from './components/Content';
import Buttons from './components/Buttons';
import CreateForm from './components/CreateForm'; 
import UpdateForm from './components/UpdateForm';

class App extends Component {
  constructor(props){
    super(props);

    this.max_content_id = 3;
    this.state = {
      mode : 'welcome',
      selected_content_id : 2,
      welcome : {title:'Welcome', desc:'Hello, React..!!'},
      subject : {title:'WEB(st)', sub:'World Wide Web(st)'},
      contents : [
        {id:1, title:'HTML', desc:'HTML은 내용을 출력합니다.'},
        {id:2, title:'CSS', desc:'CSS는 스타일을 지정합니다.'},
        {id:3, title:'JavaScript', desc:"JS는 화면을 동적으로 제어합니다."}
      ]
    }
  }
  render(){
    let _title, _desc, _article = null;
    if(this.state.mode === 'welcome'){
      _title = this.state.welcome.title;
      _desc = this.state.welcome.desc;
      _article = <Content title={_title} desc={_desc}></Content>;
    }
    else if(this.state.mode === 'read'){
      //_title = this.state.contents[0].title;
      //_desc = this.state.contents[0].desc;
       var i = 0;
      while(i < this.state.contents.length){
        var data = this.state.contents[i];
        if(data.id === this.state.selected_content_id){
          _title = data.title;
          _desc = data.desc;
          break;
        }
        i++
      }
      _article = <Content title={_title} desc={_desc}></Content>;
    }
    else if(this.state.mode === 'create'){
      _article = <CreateForm onSubmitValue={function(_title, _desc){
        console.log(_title, _desc); 

        this.max_content_id = this.max_content_id + 1;
        var _contents = this.state.contents.concat(
          {id:this.max_content_id, title:_title, desc:_desc}
        );
        this.setState({
          contents : _contents,
          mode : 'read',
          selected_content_id : this.max_content_id
        });
      }.bind(this)}></CreateForm>
    }
    else if(this.state.mode==='update'){
      /*
      현재 read 중인 게시물의 id를 통해 객체를 얻어온 후, 변수에 저장한다.
      그리고 컴포넌트의 props로 전달한다.
      */
      // ※아래 코드는 게시물을 삭제하는 경우에 index에 문제가 발생할 수 있음.※  << 추후 수정
      let _readData = this.state.contents[this.state.selected_content_id-1];
      _article = <UpdateForm readData={_readData}
        onSubmitValue={function(_id, _title, _desc){
          console.log(_id, _title, _desc);
        }.bind(this)}></UpdateForm>;
    }
 
    return (
      <div className="App">
        <Subject 
          title={this.state.subject.title} 
          sub={this.state.subject.sub}
          onChangePage={function(){
            //alert('이벤트 확인용(Subject)');
            this.setState({mode:'welcome'});
          }.bind(this)}
          ></Subject>        
        <Navi data={this.state.contents}
          onChangePage={function(id){            
            console.log("content_id", id);
            this.setState({
              mode:'read',
              selected_content_id : Number(id)
            });
          }.bind(this)}></Navi>
        <Buttons onChangeMode={function(btn_mode){
          this.setState({
            mode : btn_mode
          });
        }.bind(this)}></Buttons>
       
        {_article}
      </div>
    );
  }
}

export default App;