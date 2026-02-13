package com.exam.springboot.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//자바코드를 통해 빈을 생성하기 위한 클래스
@Configuration
public class BeanConfig {

	//member1이라는 이름으로 빈 생성
	@Bean
	public MemberVO member1() {
		//setter를 통한 초기화
		MemberVO member1 = new MemberVO();
		member1.setName("정우성");
		member1.setiPerson(new Student());
		
		return member1;
	}
	//MissGo라는 이름으로 빈 생성
	@Bean(name="MissGo")
	public MemberVO member2() {
		//생성자를 통한 초기화
		return new MemberVO("고소영", new Teacher());
	}
}
