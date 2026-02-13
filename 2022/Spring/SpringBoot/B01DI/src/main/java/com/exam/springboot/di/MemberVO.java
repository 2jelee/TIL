package com.exam.springboot.di;

public class MemberVO {
	//멤버변수
	private String name;
	private IPerson iPerson;
	//생성자
	public MemberVO() {}
	public MemberVO(String name, IPerson iPerson) {
		super();
		this.name = name;
		this.iPerson = iPerson;
	}
	//setter()메소드
	public void setName(String name) {
		this.name = name;
	}
	public void setiPerson(IPerson iPerson) {
		this.iPerson = iPerson;
	}
	//이름을 출력
	public void memberPrint() {
		iPerson.print("안녕하세요? "+ name +" 님");
	}
}
