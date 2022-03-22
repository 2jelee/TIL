// ready : html 페이지(?)를 끝까지 읽어 ready가 되면 가지고 와서 이를 실행해줘
// document가 준비가 되면
$(document).ready(function () {
  $('h1').css('color', 'red');
})

$(function () {
  $('h1').css('color', 'skyblue');

  // Q. id가 demo인 것의 class가 inner인 글자에 underline을 그어라
  $('#demo' > '.inner').css('font','u');
});