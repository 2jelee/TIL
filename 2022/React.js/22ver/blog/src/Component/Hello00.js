import React from 'react'; 
import './Hello.css';

// component 명명 : 대문자 권장
// jsx 문법 (-x: xml의 약자 => 엄격)
// return문에 div 하나로 전체 감싸줘야 한다. 이는 <>로 대체 가능하다!
// 주석은 { } 필요

function Hello() {
	const name = '2jelee';
	return (
		<>
			<div>
				<h1>안녕하세요. 여기는 Hello.js.</h1>
			</div>
			<div className='grey-div'> {/* class (X) -> className (O) */}
				<h2>안녕하세요 2, {name}</h2>
				<h2>안녕하세요 3, {/*'문자열'+*/ name}</h2>
				<input />
			</div>
		</>
	);
} 
 
export default Hello;