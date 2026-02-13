package project1.ver08;

import java.io.Serializable;

//ver 08
public class PhoneInfo implements Serializable{
		
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
		PhoneInfo pi = (PhoneInfo)obj;
		if(this.name.equals(pi.name)) {
			return true;
		}
		else {
			return false;
		}
	}
}