package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import config.JavaConfig2;
import spring.Client2;

public class MainEntry3 {
	public static void main(String[] args) {
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig2.class);
		// 추상클래스 -> 자체적으로 객체 생성 x
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig2.class);
		
		Client2 client2 = ctx.getBean("client2", Client2.class);
		Client2 client22 = ctx.getBean("client2", Client2.class); // Scope annotation으로 만든.

		client2.send();

		// spring은 singleton pattern
		System.out.println(client2.hashCode());
		System.out.println(client22.hashCode());
		
		ctx.close();
	}
}
