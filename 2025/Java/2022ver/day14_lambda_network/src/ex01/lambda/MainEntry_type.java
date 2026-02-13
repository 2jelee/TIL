package ex01.lambda;

/*
 * type을 써야하는 상황 예제
 */
 
///*
interface Message {
	public void something(int x, int y);			 //parameter >> 매개변수 2개
//	void good(int x);		// 추가 시, 아래에서 error >> 인터페이스는 추상메소드 1개만 가지고 있어야 한다 	>> functional interface
}

//interface 추가		>> type을 달리
interface Talk{
	public void something(String x, String y);		//type이 Message와 다름
//	void view(int x);		// >> functional interface
}

class Person {
	public void greeting(Message msg) {  
		msg.something(3, 4);		 
	}

	//오버로드
	public void greeting(Talk msg) {  
		msg.something("Hi", "Hello");		 
	}
}
 
public class MainEntry_type {
	public static void main(String[] args) {
		Person person = new Person();		
		
		//lambda를 이용하지 않은 코드 
		person.greeting(new Message() {	//익명클래스 
			@Override
			public void something(int a, int b) { 	// 위의 int x, int y와 달라도 된다.
				System.out.println("parameger value : " + a + ", " + b); 
			}
		});
		
		System.out.println("\n--------------Lambda----------------");
		char ch = 'A'; //추가
		
		//lambda를 이용한 코드 
		//int형인지, String type인지 헷갈린다.
//		person.greeting( (c, d) -> {  System.out.println("parameger value : " + c + ", " + d); }); 
		//type 기재	  >> type 생략 불가능! 
		person.greeting( (int c, int d) -> {  System.out.println("[int] parameger value : " + c + ", " + d); }); 
		person.greeting( (String c, String d) -> {  
				System.out.println("[String] parameger value : " + c + ", " + d); 
				
				System.out.println(ch); //local variable 사용은 O, 
//				ch = 'B';				//그러나 값 변경은 X 
				num = 2000;				//static 변수 값은 변경 O	 >> static은 공유해서 사용
				System.out.println(num);
				});	
	} //end of Main
	
	static int num = 999;
} 
//*/