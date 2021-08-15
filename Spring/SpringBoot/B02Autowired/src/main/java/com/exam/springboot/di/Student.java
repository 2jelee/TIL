package com.exam.springboot.di;

import org.springframework.stereotype.Component;

//프로젝트 실행시 빈을 자동으로 생성한다. 
@Component("student")
public class Student implements IPerson {
	@Override
	public void print(String message) {
		System.out.println("Student : "+ message);
	}
}
