package com.exam.springboot.di;

public class Student implements IPerson {
	@Override
	public void print(String message) {
		System.out.println("Student : "+ message);
	}
}
