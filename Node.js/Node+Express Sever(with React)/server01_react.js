const express = require('express');
const path = require('path');
const app = express();

const http = require('http').createServer(app);
http.listen(8080, function() {
  console.log('listening on 8080');
})

// app.use = 미들웨어 : 어떠한 파일을 서버에서 잘 보내고 싶으면 그 static 파일들이 어디에 있는지 기록해주어야 한다.
// __dirname : 현재 경로
// app.use(express.static(path.join(__dirname, 'public')))
app.use(express.static(path.join(__dirname, 'test/build')))

// 의미 : 누가 / (즉, 메인페이지)로 접속했을 때 'public/main.html' 파일 보내주겠다.
app.get('/', function(req, resp ) {
  // resp.sendFile(path.join(__dirname, 'public/main.html'))
  resp.sendFile(path.join(__dirname, 'test/build/index.html'))
})

// 리액트의 라우팅 기능을 이용하고 싶다면?
// app.get('/about', function(req, resp ) { //이 아니라,
app.get('*', function(req, resp ) { //유저가 URL 아무거나 입력하면
  // resp.sendFile(path.join(__dirname, 'public/main.html'))
  resp.sendFile(path.join(__dirname, 'test/build/index.html')) //리액트 HTML을 보내라
})
