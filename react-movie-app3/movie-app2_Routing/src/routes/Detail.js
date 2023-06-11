import React from 'react';

class Detail extends React.Component {
    componentDidMount(){ //render 실행 후 componentDidMount가 실행됨을 주의!!!!
        console.log(this.props);
        const {location, history} = this.props;
        if(location.state===undefined){
            history.push("/"); //go back home //http://localhost:3000/#/movie-detail할 경우 홈으로 리다이렉트 시킴
        }
    }
    render() {
        const {location} = this.props;
        if(location.state){
            return <span>{location.state.title}</span>;
        }
        else{
            return null;
        }
    }
}

export default Detail;
/*
render check해보기]
    만약 location.state가 존재한다면 title을 return 해주고
    그렇지 않다면 null을 return해줄 것이다.

    또한 만약 render()가 먼저 끝났다면 home으로 돌아감.(componentDidMount를 불렀을때)
*/