package designpattern.builder;

//절차 1. Person 클래스 생성 - 멤버변수, getter, setter
public class Person {

	//멤버변수
	private String firstName;
	private String lastName;
	private String addr1;
	private String addr2;
	private String gender;
	private boolean driverLicence;
	private boolean married;
	
	//기본생성자, 인자생성자
	public Person() {}
	public Person(String firstName, String lastName, String addr1, String addr2, String gender, 
			boolean driverLicence, boolean married) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.gender = gender;
		this.driverLicence = driverLicence;
		this.married = married;
	}
	
	// getter/setter
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public boolean isDriverLicence() {
		return driverLicence;
	}
	public void setDriverLicence(boolean driverLicence) {
		this.driverLicence = driverLicence;
	}
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
	
	
	// static 타입으로 만들어서 클래스명만으로 호출 가능.
	//절차 5. Person클래스의 '마지막'에 PersonBuilder를 반환하는 static 타입의 builder() 메소드 생성.
	public static PersonBuilder builder() {
		return new PersonBuilder();
	}
	
	
}
