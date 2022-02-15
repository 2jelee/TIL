package ex01.lambda;

/*
 * return type이 있는 Lambda
 */

///* 
interface Message {
	public int something();				// void를 int로
}

class Person {
	public void greeting(Message msg) {  //인사		//인터페이스를 매개변수로 가짐
		int su = msg.something();
		System.out.println("Number is " + su);
	}
}

public class MainEntry_return {
	public static void main(String[] args) {
		Person person = new Person();		//인스턴스 생성
		
		//lambda를 이용하지 않은 코드
//		person.greeting("안녕하세요");		// ""는 String 이므로 매개변수의 Message 타입과 맞지 않다.
		person.greeting(new Message() {
			
			@Override
			public int something() { 	// void를 int로
				return 2;	//추가
			}
		});
		
		System.out.println("\n--------------Lambda----------------");
		
		//lambda를 이용한 코드
		person.greeting(
			// 매개변수_인자값 없는 상태이므로 ()
			() -> {	 return 20; }   //변
		); 
	}
}
//*/
