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
//페이지 처리를 위한 state추가
class ListContents extends Component {  
  state = {
    blists : [],
    pageNum :1
  }
  //render() 함수 호출전 전처리를 위한 수명주기 함수
  componentDidMount(){
    let pageNum = this.state.pageNum;
    //페이지번호 변수로 처리
    fetch('http://localhost:8081/jsonrestapi/restapi/boardList.do?nowPage='+pageNum)
      .then(function(result){
        return result.json();
      })
      .then(function(json){
        console.log(json);
        this.setState({blists:json});
      }.bind(this));
  }
  render(){
    console.log("ListContents render완료");
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
class ViewContents extends Component {
  state = {
    bview : {
      content : "하하하"
    }
  }
  //render() 함수 호출전 전처리를 위한 수명주기 함수
  componentDidMount(){
    fetch('http://localhost:8081/jsonrestapi/restapi/boardView.do?num='+this.props.num)
			.then((result)=>{
			  return result.json();
			})
			.then((json)=>{
			  console.log(json);
			  this.setState({bview:json});
			});
  }
  render(){
    console.log("ViewContents->num", this.props.num);
    return (
      <div className="col-10" id="lay_contents">    
        <h3>게시판내용보기</h3>
        <table className="table table-bordered">
        <tbody>
          <tr>
              <td>번호</td>
              <td>{this.state.bview.num}</td>
              <td>작성자</td>
              <td>{this.state.bview.id}</td>
          </tr>
          <tr>
              <td>작성일</td>
              <td>{this.state.bview.postdate}</td>
              <td>조회수</td>
              <td>{this.state.bview.visitcount}</td>
          </tr>
          <tr>
              <td>제목</td>
              <td colSpan="3">{this.state.bview.title}</td>
          </tr>
          <tr>
              <td>내용</td>
              <td colSpan="3" height="100">{
                this.state.bview.content.split('\n').map(line=>{
                  return (
                    <span key={Math.random()}>{line}<br/></span>
                  );
                })
              }</td>
          </tr>
          <tr>
              <td colSpan="4" align="center">                     
                  <button type="button" onClick={(e)=>{
                    e.preventDefault();
                    this.props.myBoardList('list');
                  }}>목록보기</button>
              </td>
          </tr>
        </tbody>  
        </table>
      </div>
    );
  }
}
class App extends Component {
  constructor(props){
    super(props);
    this.state = {
      mode : 'list',
      num : 0
    };
  }
  render(){
    let content ;
    if(this.state.mode==='list'){
      content = <ListContents myBoardView={(pnum, pmode)=>{
        console.log("num", pnum, "mode", pmode);
        this.setState({
          mode:pmode, num:pnum
        });
      }}></ListContents>
    }
    else if(this.state.mode==='view'){
      content = <ViewContents num={this.state.num} myBoardList={(pmode)=>{
        console.log("mode", pmode);
        this.setState({mode:pmode});
        }}></ViewContents>
    }
    return (
      <div className="container">
        <Top></Top>
        <div className="row">
            <Left></Left>
            {/* 게시판 목록 or 내용보기 출력 */}
            {content}
        </div>
        <Bottom></Bottom>
      </div>
    );
  }
}

export default App;
