package common;

public class Person {
	
	//멤버변수
	String name;
	int age;
	
	//인자생성자  <= using field를 통해 생성
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	//getter/setter 생성
	public String getName() { 	// 테스트를 위해 주석처리
		return name; 
	}
//				오류 : [common.Person]에서 프로퍼티 [name]을(를) 읽을 수 없습니다.
//						getter가 없기 때문에 500 error
	
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
