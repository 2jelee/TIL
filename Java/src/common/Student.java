package common;

public class Student extends Person {

	private String stNumber;
	public Student(String name, int age, String stNumber) {
		super(name, age);
		this.stNumber = stNumber;
	}
	@Override
	public String getInfo() {
		return super.getInfo()+",학번:"+stNumber;
	}
	@Override
	public void showInfo() {
		System.out.println("학생의정보");
		System.out.println(getInfo());
	}
	@Override
	public String toString() {
		/*
		부모의 멤버변수가 private이므로 getter를 통해 접근해야한다.
		 */
		return String.format("이름:%s,나이:%d,학번:%s", 
				getName(), getAge(), stNumber);
	}	
}