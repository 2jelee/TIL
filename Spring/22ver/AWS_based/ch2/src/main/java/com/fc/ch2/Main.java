package com.fc.ch2;

import java.lang.reflect.Method;

public class Main {
	public static void main(String[] args) throws Exception {
//		Hello hello = new Hello();
//		hello.main(); // 접근제어자가 public이 아닌, private 이므로 외부 호출 X
		
		//아까는 Reflection API를 사용 - class 정보를 얻고 다룰 수 있는 강력한 기능 제공
		// java.lang.reflect 패키지 제공
		
		// 의미 : Hello 클래스의 Class 객체(클래스의 정보를 담고 있는 객체)를 얻어온다.
		// class = 설계도
		Class helloClass = Class.forName("com.fc.ch2.Hello");
		Hello hello = (Hello)helloClass.newInstance(); // Class객체가 가진 정보로 객체 생성 
		Method main = helloClass.getDeclaredMethod("main");
		main.setAccessible(true); // private인 main()을 호출 가능하게 한다.
		
		main.invoke(hello);
	}
}
