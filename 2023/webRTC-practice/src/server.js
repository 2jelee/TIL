import express from "express";

const app = express();

// console.log("server.js 입니다.");

// app.listen(3000);

// 2. 나중에 pug 페이지들을 렌더하기 위해 pug 설정하기
app.set('view engine', 'pug');
app.set("views", __dirname + "/views"); //views 디렉토리 입력하기 >> views가 src안에 있다.

// 3. 사용할 유일한 route 만들기
// app.get("/", (req, res) => res.render("home"));
app.get("/", (_, res) => res.render("home"));
// home으로 가면 request, response를 받고 res.render를 한다. (만든 home을 렌더하는 것)

// 4. 유저가 /public으로 가게 되면 __dirname + "/public" 폴더를 보여주게 한다.
app.use("/public", express.static(__dirname+"/public"));

// 5. catchall URL을 만들고 싶다면?
// app.get("/*", (req, res) => res.redirect("/")); //app.get 입력 후 여기서 유저가 어떤 URL로 이동하던지 home으로 돌려보내기
app.get("/*", (_, res) => res.redirect("/")); //app.get 입력 후 여기서 유저가 어떤 URL로 이동하던지 home으로 돌려보내기
// 다른 URL 사용하지 않을 것임. => 앞으로 home만 사용할 것이다!

// 1.
const handleListen = () => console.log(`Listening on http://localhost:3000`);
app.listen(3000, handleListen);

///////////////// 여기까지 express 방식. 여기 express는 ws을 지원하지 않는다 /////////////////