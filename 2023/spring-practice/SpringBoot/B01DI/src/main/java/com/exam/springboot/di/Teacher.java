package com.exam.springboot.di;

public class Teacher implements IPerson {
	@Override
	public void print(String message) {
		System.out.println("Teacher : "+ message);
	}
}
