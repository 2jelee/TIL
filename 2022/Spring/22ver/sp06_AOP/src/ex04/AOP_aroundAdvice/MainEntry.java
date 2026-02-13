package ex04.AOP_aroundAdvice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ex04/AOP_aroundAdvice/ctx.xml");
		
		iMessageBean bean = context.getBean("messageBeanImpl", iMessageBean.class);
		bean.sayHello();
		System.out.println("-------------");
		bean.engHello();
		iBookBean bookBean = (iBookBean)context.getBean("bookBeanImpl");
		bookBean.testHello("KOSA");
		bookBean.korHello();
	}
}
