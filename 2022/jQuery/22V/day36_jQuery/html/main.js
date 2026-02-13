// ready : html 페이지(?)를 끝까지 읽어 ready가 되면 가지고 와서 이를 실행해줘
// document가 준비가 되면
$(document).ready(function () {
  $('h1').css('color', 'red');
})

$(function () {
  $('h1').css('color', 'skyblue');

  // Q. id가 demo인 것의 class가 inner인 글자에 underline을 그어라
  // $('#demo .inner').css('text-decoration','underline');
  
  //아래쪽에 5px 두께 실선 red
  // $('#demo .inner').css('border-bottom','5px solid red');

  // 기울기
  // $('#demo .inner').css('transform', 'rotate(45deg)');
  
  // $('#demo .inner').css('opacity', 0.5);

  // $('#demo .inner').css({'text-decoration':'underline',
  //                         'border-bottom':'5px solid red',
  //                         'transform':'rotate(175deg)',
  //                         'opacity': .3});

  // 앞(속성) : 뒤    >> 1가지일 경우 : 대신 , 쓰자
  // ' '를 쓰고 싶지 않다면 camelCase를 사용하자
  // $('#demo .inner').css({ textDecoration :'underline',
  //                         borderBottom :'5px solid blue',
  //                         transform :'rotate(175deg)',
  //                         opacity : .3});

  // [Step 01]
  // $('선택자').on('이벤트종류', 할일);
  // $('#demo').on('mouseover', function(){
  //   $('.inner').css('background', 'green');
  // })
  // $('#demo').on('mouseout', function(){
  //   $('.inner').css('background', 'none');
  // })
  
  // [Step 02]
  // $('#demo').on('mouseover', function(){
  //   $('.inner').css('background', 'orange');
  // }).on('mouseout', function(){
  //   $('.inner').css('background', 'none');
  // })

  // [Step 03]
  // $('#demo').mouseover(function(){
  //   $('.inner').css('background', 'yellow');
  // }).on('mouseout', function(){
  //   $('.inner').css('background', 'none');
  // })

  // [Step 04]
  $('#demo').mouseover(function(){
    $('.inner').css('background', 'yellow').html('글자 변경');
  }).mouseout (function(){
    $('.inner').css('background', 'none');
  })


});