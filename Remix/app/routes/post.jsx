import { Outlet } from "remix";

export default function Post() {
  return (
    <div>
      <h1>포스트 페이지입니다.</h1> 
      <Outlet></Outlet>
    </div>
  );
}
// /post/comment로 접속 -> <Post> 안에 <Comment> 보여주고 싶은 경우 >> Outlet 태그 import