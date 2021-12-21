// const a = 5;    //constant(상수) : 바뀌지 않는 값. 계속 유지.
// const b = "2";
// // [규칙] 기본적으로 const 사용, 필요할 때만 let 사용(변O), var는 사용 X

// console.log(a + b);
// console.log(a * b);
// console.log(a / b);


const dayOfWeek = ["mon", "tue", "wed", "thu", "fri", "sat"];

//Get Item from Array.
console.log(dayOfWeek[5]);

//Add one more day to the array.
dayOfWeek.push("sun");

console.log(dayOfWeek);

const toBuy = ["potato", "tomato", "pizza"];
toBuy.push("chicken");
console.log(toBuy[3]);



// const playerName = "2jelee";
// const playerPoints = 1234;
// const playerGood = false;
// const playerThin = "little thin";

// const player = ["2jelee", 1234, false, "little thin."];

// object
const player = {
    name: "2jelee",
    points: 1234,
    good: false,
}
console.log(player);
console.log(player.name);
console.log(player["name"]);
// player.name;

console.log(player);
player.good = true;  // 2. 여기서 const는 boolean으로 바뀌는 것. >> update
console.log(player); // 1.const인데 값이 변했다?

player.fmName = "LEE"; //원하는 어떤 property든 만들 수 O
console.log(player); 

player.points = player.points + 15;
console.log(player.points);