package project1.ver07;

//ver 07
public class PhoneInfo	{
		
	String name; 
	String phoneNumber; 
	
	
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
	
	
	//set 컬렉션에 저장 시, 중복 제거를 위한 메소드 오버라이딩
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
//		System.out.println(name+"equals메소드 호출됨--디버깅용");
		PhoneInfo pi = (PhoneInfo)obj;
		if(this.name.equals(pi.name)) {
//			System.out.println("equals메소드"+this.name.equals(pi.name));
			return true;
		}
		else {
			return false;
		}
	}
}