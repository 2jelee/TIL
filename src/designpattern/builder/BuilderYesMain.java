package designpattern.builder;

/*
Builder Pattern(빌더 패턴)
	: 객체의 생성과정에서 표현방법과 생성과정을 분리하여
	동일한 생성절차에서 다른 표현결과를 만들 수 있게 하는 디자인 패턴임.
	멤버변수 갯수가 많을 때 사용하면 편리.
	
절차]
	1. Person 클래스 생성 - 멤버변수, getter, setter
	2. PersonBuilder 클래스 생성 - Person과 동일한 멤버변수 및 setter
	3. setter를 아래와 같이 수정
		반환형 void -> PersonBuilder
		메소드형 setXXX -> set을 삭제하고 멤버변수명과 동일하게.
		return this를 각 메소드에 추가.
	4. PersonBuilder 클래스 마지막에 build() 메소드 생성
		setter를 통해 각 멤버변수 초기화한 후 Person객체를 반환.
	5. Person클래스의 '마지막'에 PersonBuilder를 반환하는 static 타입의 builder() 메소드 생성.
	
	
이와 같이 하면 객체생성 시 메소드 체인 형태로 각 멤버변수를
마음대로 설정할 수 O.
 */
public class BuilderYesMain {

	public static void main(String[] args) {
		
		//1번 객체 : 이름, 주소만 초기화
		Person p1 = Person.builder()
				.firstName("김")
				.lastName("이박")
				.addr1("가산디지털단지")
				.addr2("월드메르디앙")
				.build();
		
		//2번 객체 : 이름, 운전면허, 결혼유무
		Person p2 = Person.builder()
				.firstName("이")
				.lastName("박최")
				.driverLicence(true)
				.married(false)
				.build();
	}
}
