// function : 해당 코드를 캡슐화하여 실행을 여러번 할 수 있게 해준다.

function sayHello(nameOfPerson, age){
  console.log(nameOfPerson);
  console.log("Hello! My name is " + nameOfPerson + ". And my age is " + age +".");
}

sayHello();
sayHello();
sayHello();
sayHello();

//argument : function을 실행하는 동안 어떠한 정보를 function에게 보낼 수 있는 방법.

sayHello("2jelee", 20);
sayHello("jelee", 21);
sayHello("lee", 22);


function plus(a, b){
  console.log(a + b);
}
plus(8, 60);    //순서 중요



// function에게 정보 보내기
const player = {
  name: "2jelee",
  sayHello: function(otherPersonsName){
    console.log("Hello! " + otherPersonsName + ", Nice to meet you");
  },
};

console.log(player.name);
player.sayHello("jelee");
player.sayHello("lee");
