import React from 'react'; 
import './Hello.css';
 
function Hello(props) {
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
			<div>
				<h2>{this.props.message} 전달 받음</h2>
			</div>
			<p>{props.name}</p>
		</>
	);
} 
 
export default Hello;