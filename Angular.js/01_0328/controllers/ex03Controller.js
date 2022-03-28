//chaining 방식

//총 argu 2개 들어간다. => argu1 : controller 이름 | argu2 : 할일 
//controller("컨트롤러 이름", function($scope { }))
//$scope는 일종의 변수 역할과 같다
angular.module("app", []).controller("ex03Controller", function ($scope) {
  $scope.controllerName = "app.ex03Controller";
  // 매개변수인 scope에 실어서
  //이는 <div ng-controller="~"> </div> 에서 받아온다.
}); 

