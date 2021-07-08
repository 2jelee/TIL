import React, { Component } from 'react';
import './App.css';

class App extends Component {
  render(){
    return (
      <div className="container">
        <div className="row" id="lay_top">
            <p>TOP</p>
        </div>
        <div className="row">
            <div className="col-lg-2" id="lay_left">
                <p>LEFT</p>
            </div>
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
                    <tr align="center">
                        <td>100</td>
                        <td align="left"><a href="#">나는 제목</a></td>
                        <td align="center">홍길동</td>
                        <td align="center">20</td>
                        <td align="center">2020.02.20</td>
                    </tr>
                </tbody>
                </table>
            </div>
        </div>
        <div className="row" id="lay_bottom">
            <p>BOTTOM</p>
        </div>
      </div>
    );
  }
}

export default App;
