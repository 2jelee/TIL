package project1.ver04;

public class PhoneCompanyInfo extends PhoneInfo {
	String companyName;
	
	public PhoneCompanyInfo(String name, String phoneNumber, String companyName) {
		super(name, phoneNumber);
		this.companyName = companyName;
	}

	@Override
	public void showPhoneInfo() {
		System.out.println("데이터 입력을 시작합니다.");
		super.showPhoneInfo();
		System.out.println("회사 : "+ companyName);
	}
}