package project1.ver07;

public class PhoneSchoolInfo extends PhoneInfo {
	String major;
	int grade;
	
	public PhoneSchoolInfo(String name, String phoneNumber, String major, int grade) {
		super(name, phoneNumber);
		this.major = major;
		this.grade = grade;
	}
	
	@Override
	public void showPhoneInfo() {
		System.out.println("데이터 입력을 시작합니다.");
		super.showPhoneInfo();
		System.out.println("전공 : "+ major);
		System.out.println("학년 : "+ grade);
	}
}
