package ex01.lambda;

/*
 * 매개변수(parameter)가 다중으로 있는 Lambda
 */
/*
interface Message {
	public int something(int x, int y);			 // int y 추가
}

class Person {
	public void greeting(Message msg) {  
		int su = msg.something(1, 2);			//88추가
		System.out.println("Number is " + su);
	}
}

public class MainEntry_parameter2 {
	public static void main(String[] args) {
		Person person = new Person();		 
		
		//lambda를 이용하지 않은 코드 
		person.greeting(new Message() {
			
			@Override
			public int something(int a, int b) { 	// 위의 int x, int y와 달라도 된다.
				System.out.println("parameter 예제");
				System.out.println("parameger value : " + a + ", " + b);
				return 70;	
			}
		});
		
		System.out.println("\n--------------Lambda----------------");
		
		//lambda를 이용한 코드
		// 변수의 자료형 생략 가능
		// 매개변수가 2개 이상일 때는 괄호 생략 X
		person.greeting( (c, d) -> {
				System.out.println("오늘은 화요일");
				System.out.println("parameger value : " + c + ", " + d);
				return 200;
				} 
		); 
	}
} 
*/