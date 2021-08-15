package designpattern.builder;

public class BuilderNoMain {

	public static void main(String[] args) { 
		
		// 빌더 패턴 적용 X인 상태의 객체 생성 및 초기화
		
		//객체생성
		Person person = new Person();
		
		//멤버변수 초기화
		person.setFirstName("홍");
		person.setLastName("길동");
		person.setAddr1("가산디지털단지");
		
		//정보 출력
		System.out.println(person.getFirstName());
		System.out.println(person.getLastName());
		System.out.println(person.getAddr1());

		/*
		클래스를 구성하는 멤버변수의 갯수가 많아지게 되면
		생성자나 setter()를 통해 초기화 하는 것이 어려워진다.
		또한, 개발자가 원하는 멤버변수만 선별해서 초기화 하는 것 역시 번거롭다.
		 */
			
		//생성자를 통한 초기화는 모든 형태를 만들어 놓아야 한다.
		//	Person person2 = new Person(null, null, false, false);
		
	}
	
}
