package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.Client;
import spring.Client2;

public class MainXML {
	public static void main(String[] args) {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] {"appCtx.xml", "appCtx2.xml"});
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(new String[] {"appCtx.xml", "appCtx2.xml"});
		
		// getBean 뒤에 id값 적어주기 
		Client c1 = (Client)ctx.getBean("client");
		Client2 c2 = ctx.getBean("client2", Client2.class);
		
		c1.send();
		c1.setHost("1111");
		System.out.println("--------");
		c2.send();
		c2.setHost("2222");
	}
}
