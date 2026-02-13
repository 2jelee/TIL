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
        return <span>{location.state.title}</span>;
    }
}

export default Detail;
/*
class Detail extends React.Component {
    componentDidMount(){
        const {location} = this.props;
        console.log(location.state);
    }
    render() {
        return <span>hello</span>;
    }
}
에서 http://localhost:3000/movie_app#/movie-detail
그대로 이동할 경우 아직 undefined이므로 수정.

if(location.state===undefined) {
            
    }
함으로써 사용자를 데려와 홈으로 redirect 시킴.
또한 history는 go, goBack, goFoward처럼 많은 것이 있는데 이들은 url을 변경한다.
즉, 이제 웹사이트가 어디있는지 장소를 바꿀 수 있다는 것임.

http://localhost:3000/#/movie-detail >> home으로 redirect
movie-detail로 이동하는 유일한 방법 : Movie 클릭을 통해서.
*/