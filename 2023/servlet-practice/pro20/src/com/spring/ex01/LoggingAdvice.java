package com.spring.ex01;

//DI관련 라이브러리 > Build Path > Configuration Build Path.. > Libraries - Classpath - Add JARs..
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

// advice class : aspect(보조기능)의 실제 구현체(클래스)
public class LoggingAdvice implements MethodInterceptor { 
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("[메서드 호출 전] : LogginAdvice");
		System.out.println(invocation.getMethod() + "메서드 호출 전");
		
		Object object = invocation.proceed();
		
		System.out.println("[메서드 호출 후] : LogginAdvice");
		System.out.println(invocation.getMethod() + " 메서드 호출 후");
		return object; 
	}
}
