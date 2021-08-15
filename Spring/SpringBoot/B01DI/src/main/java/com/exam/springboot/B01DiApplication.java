package com.exam.springboot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.exam.springboot.di.BeanConfig;
import com.exam.springboot.di.MemberVO;

//@SpringBootApplication
public class B01DiApplication {

	public static void main(String[] args) {
		//SpringApplication.run(HelloBootApplication.class, args);
		
		//BeanConfig클래스를 기반으로 스프링 컨테이너 생성
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		//컨테이너를 통해 빈을 주입 받음
		MemberVO member1 = (MemberVO)context.getBean("member1");
		member1.memberPrint();
		
		MemberVO member2 = context.getBean("MissGo", MemberVO.class);
		member2.memberPrint();
	}
}
