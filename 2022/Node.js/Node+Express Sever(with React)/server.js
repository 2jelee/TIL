const express = require('express');
const path = require('path');
const app = express();

const http = require('http').createServer(app);
http.listen(8080, function() {
  console.log('listening on 8080');
})

// 해당 코드(use를 사용하는) 2개가 필요하며 경로 추가
// app.use(express.static(path.join(__dirname, 'test/build')))

// app.use는 미들웨어다. => 미들웨어 : 서버의 요청과 응답 사이에 실행할 코드
app.use('/', express.static(path.join(__dirname, 'public')))
// 유저가 /react 포함된 URL로 요청 시 요청과 응답사이에 실행할 코드
// 단, 이 코드만 추가할 겨우 해당 URL에서 /react 적어도 들어가지지 않는다. 추가 설정 필요
app.use('/react', express.static(path.join(__dirname, 'test/build')))

app.get('/', function(req, resp ) {
  resp.sendFile(path.join(__dirname, 'public/main.html'))
})
