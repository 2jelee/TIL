package com.spring.ex01;

// target class : advice(aspect의 실제 구현체 - 클래스)가 적용되는 클래스
public class Calculator {
	public void add(int x, int y) {
		int result = x + y;
		System.out.println("결과:"+result);
	}
	
	public void substract(int x, int y) {
		int result = x - y;
		System.out.println("결과:"+result);
	}

	public void multiply(int x, int y) {
		int result = x * y;
		System.out.println("결과:"+result);
	}
	
	public void divide(int x, int y) {
		int result = x / y;
		System.out.println("결과:"+result);
	}
	
}
