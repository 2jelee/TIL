// .js 파일 자체를 import해서 쓰겠다.

export default random();
function random() {
  //어떻게 내보낼래?(export)
  // floor : 내림 정수하여 | ceil : 올림 정수 하여
  return Math.floor(Math.random()*10)
}
