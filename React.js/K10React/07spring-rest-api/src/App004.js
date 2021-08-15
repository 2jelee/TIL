import React, { Component } from 'react';
import './App.css';

class Top extends Component {
  render(){
    return (
      <div className="row" id="lay_top">
          <p>TOP</p>
      </div>
    );
  }
}
class Left extends Component {
  render(){
    return (
      <div className="col-lg-2" id="lay_left">
          <p>LEFT</p>
      </div>
    );
  }
}
class Bottom extends Component {
  render(){
    return (
      <div className="row" id="lay_bottom">
          <p>BOTTOM</p>
      </div>
    );
  }
}
//목록 처리를 위한 컴포넌트
class ListContents extends Component {
  state = {
    blists : []
  }
  //render() 함수 호출전 전처리를 위한 수명주기 함수
  componentDidMount(){
    fetch('http://localhost:8081/jsonrestapi/restapi/boardList.do?nowPage=1')
      .then(function(result){
        return result.json();
      })
      .then(function(json){
        console.log(json);
        this.setState({blists:json});
      }.bind(this));
  }
  render(){
    let listTr = [];
    for(var i=0 ; i<this.state.blists.length ; i++){
      var row = this.state.blists[i];

      listTr.push(
        <tr align="center" key={row.num}>
            <td>{row.num}</td>
            <td align="left"><a href={row.num} data-id={row.num} onClick={
              (e)=>{
                e.preventDefault();
                this.props.myBoardView(e.target.dataset.id, 'view');
              }
            }>{row.title}</a></td>
            <td align="center">{row.id}</td>
            <td align="center">{row.visitcount}</td>
            <td align="center">{row.postdate}</td>
        </tr>
      );
    }
    return (
      <div className="col-lg-10" id="lay_contents">
        <h2>게시판목록</h2>
        <table className="table table-bordered">
        <thead>
            <tr>
                <th width="10%">번호</th>
                <th width="*">제목</th>
                <th width="15%">작성자</th>
                <th width="15%">조회수</th>
                <th width="15%">작성일</th>
            </tr>
        </thead>
        <tbody>
          {listTr}
        </tbody>
        </table>
      </div>
    );
  }
}
class App extends Component {
  render(){
    return (
      <div className="container">
        <Top></Top>
        <div className="row">
            <Left></Left>
            {/* 게시판 목록 or 내용보기 출력 */}
            <ListContents></ListContents>
        </div>
        <Bottom></Bottom>
      </div>
    );
  }
}

export default App;
