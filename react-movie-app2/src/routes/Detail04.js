import React from 'react';

class Detail extends React.Component {
    componentDidMount(){
        const {location} = this.props;
        console.log(location.state);
    }
    render() {
        return <span>hello</span>;
    }
}

export default Detail;
/*
여기서 props대신 {location}을 넣어본다면?
    개발자 모드에서 location 확인해보면 state가 undefined임을 확인할 수 있음.

    이는 movie를 클릭하지 않고
    http://localhost:3000/#/movie-detail 를 할 경우, state가 없는 상태(undefined)가 됨. 
    >> 이를 핸들링 해야한다.

state:undefined을 해결하고자
function Detail({location}) {
    console.log({location});
    return <span>hello</span>;
}
를(현 rfce : function component) class component로 변환
*/