package ex01.lambda;

/*
 * 매개변수(parameter)가 1개 있는 Lambda
 */

/*
interface Message {
	public int something(int x);			 // int x 추가
}

class Person {
	public void greeting(Message msg) {  
		int su = msg.something(88);			//88추가
		System.out.println("Number is " + su);
	}
}

public class MainEntry_parameter1 {
	public static void main(String[] args) {
		Person person = new Person();		 
		
		//lambda를 이용하지 않은 코드 
		person.greeting(new Message() {
			
			@Override
			public int something(int y) { 	// 위의 int x와 달라도 된다.
				System.out.println("parameter 예제");
				System.out.println("parameger value : " + y);
				return 30;	
			}
		});
		
		System.out.println("\n--------------Lambda----------------");
		
		//lambda를 이용한 코드
		person.greeting(
			// parameter에 자료형을 써도 되고 쓰지 않아도 상관 X,
			// 매개변수가 1개일때는 괄호 생략 O
			x -> {
				 System.out.println("화이팅");
				 System.out.println("parameter value : " + x);
				 return 30;
				 } 
		); 
	}
}
*/