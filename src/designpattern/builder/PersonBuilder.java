package designpattern.builder;

//절차 2. PersonBuilder 클래스 생성 - Person과 동일한 멤버변수 및 setter
public class PersonBuilder {
	
	//멤버변수
	private String firstName;
	private String lastName;
	private String addr1;
	private String addr2;
	private String gender;
	private boolean driverLicence;
	private boolean married;
	
	//setter만 생성 후 수정
	/*
	절차 3. setter를 아래와 같이 수정
			반환형 void -> PersonBuilder
			메소드형 setXXX -> set을 삭제하고 멤버변수명과 동일하게.
			return this를 각 메소드에 추가.
	 */
	public PersonBuilder firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	public PersonBuilder lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	public PersonBuilder addr1(String addr1) {
		this.addr1 = addr1;
		return this;
	}
	public PersonBuilder addr2(String addr2) {
		this.addr2 = addr2;
		return this;
	}
	public PersonBuilder gender(String gender) {
		this.gender = gender;
		return this;
	}
	public PersonBuilder driverLicence(boolean driverLicence) {
		this.driverLicence = driverLicence;
		return this;
	}
	public PersonBuilder married(boolean married) {
		this.married = married;
		return this;
	}
	
	/*
	절차 4. PersonBuilder 클래스 마지막에 build() 메소드 생성
			setter를 통해 각 멤버변수 초기화한 후 Person객체를 반환.
	 */
	public Person build() {
		Person person = new Person();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setAddr1(addr1);
		person.setAddr2(addr2);
		person.setGender(gender);
		person.setDriverLicence(driverLicence);
		person.setMarried(married);
		
		return person;
	}
	
}
