package ex01.lambda;

/* 
형식 : (매개변수 목록) -> { 실행문(=lambda식 body) }
- 불필요한 클래스의 정의가 없다
- 메소드에 대한 return 타입도 없다
- 이름도 없다 (익명 메소드)
- Annonymous Function(익명 함수) ⇒ 익명 클래스로 봐도 무방
 */

/*
interface Message {
	public void something();				// = void something();
}

class Person {
	public void greeting(Message msg) {  //인사		//인터페이스를 매개변수로 가짐
		msg.something();
	}
}

public class MainEntry {
	public static void main(String[] args) {
		Person person = new Person();		//인스턴스 생성
		
		//lambda를 이용하지 않은 코드
//		person.greeting("안녕하세요");		// ""는 String 이므로 매개변수의 Message 타입과 맞지 않다.
		person.greeting(new Message() {
			
			@Override
			public void something() {
				System.out.println("반가워요!");
				System.out.println("Good Morning!");
			}
		});
		
		System.out.println("\n--------------Lambda----------------");
		
		//lambda를 이용한 코드
		person.greeting(
			// 매개변수_인자값 없는 상태이므로 ()
			() -> {	System.out.println("반가워요오");  System.out.println("Good Morning!!!!!!!!"); }
		); 
	}
}
*/