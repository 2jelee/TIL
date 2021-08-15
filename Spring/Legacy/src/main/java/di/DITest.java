package di;

class Persons {
	String name;
	int age;
	//public Person() {} //생성자 만듦 | 이를 주석처리 후, private을 주석해제 해보기.
	private Persons() {} //public을 private으로 만들어보면 aPerson의 new Person()에서 error
}

public class DITest {

	/*
	강한 결합(독립성 낮) : new를 통해 '직접' 객체를 생성함.
							결합도가 높기때문에 Person클래스의 변화에 직접적인 영향을 받는다.
		<< 개발자가 주체
	 */
	public static void aPerson() {
		Persons person1 = new Persons();
		person1.name = "홍길동";
	}

	/*
	약한 결합(독립성 높) : 미리 생성된 객체를 주입(Injection) 받음.
							결합도가 낮아지기 때문에 Person 클래스에 변화가 생기더라도
							직접적인 영향을 받지 X.
							또한 코드도 좀 더 간결해짐.
		<< Spring이 주체(역제어)
	 */
	public static void bPerson(Persons p) { // '간접'적으로 생성
		p.age = 35;
	}
	
	public static void main(String[] args) {
		
	}
}
