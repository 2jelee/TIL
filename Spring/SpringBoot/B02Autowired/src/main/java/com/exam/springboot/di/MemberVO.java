package com.exam.springboot.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MemberVO {
	
	//멤버변수를 지정된 값으로 초기화
	@Value("장동건")
	private String name;
	
	/*
	@Qualifier
		: 유사한 객체가 여러개일때 이름으로 정확히 지정하여
		주입받을때 사용함. 
	 */
	@Autowired
	@Qualifier("student")
	private IPerson iPerson;
	
	public MemberVO() {}
	public MemberVO(String name, IPerson iPerson) {
		super();
		this.name = name;
		this.iPerson = iPerson;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setiPerson(IPerson iPerson) {
		this.iPerson = iPerson;
	}
	
	public void memberPrint() {
		iPerson.print("안녕하세요? "+ name +" 님");
	}
}

