package project1.ver06;

//ver 05
public class PhoneInfo	{
		
	String name; 
	String phoneNumber; 
	
	//생성자
	public PhoneInfo(String name, String phoneNumber, String birthday) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	//생성자 오버로딩
	public PhoneInfo(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public void showPhoneInfo() {
		System.out.println("이름 : "+ name);
		System.out.println("전화번호 : "+ phoneNumber);
	}
}