package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.JavaConfig2;
import spring.Client2;

public class MainEntry2 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig2.class);
		
		Client2 client2 = ctx.getBean("client2", Client2.class);
		Client2 client22 = ctx.getBean("client2", Client2.class); // Scope annotation으로 만든.

		client2.send();

		// spring은 singleton pattern
		System.out.println(client2.hashCode());
		System.out.println(client22.hashCode());
		
		ctx.close();
	}
}
