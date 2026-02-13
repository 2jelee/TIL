package com.exam.springboot.di;

import org.springframework.stereotype.Component;

//주석으로 처리하면 자동으로 빈이 생성되지 않음
//@Component("teacher")
public class Teacher implements IPerson {
	@Override
	public void print(String message) {
		System.out.println("Teacher : "+ message);
	}
}
