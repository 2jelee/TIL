package ex01.Di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		
//		MessageBean  mb = new MessageBeanImpl("yuna", "Hello");
//		mb.setGreeting("hi");
//		mb.setName("gildong");
//		mb.sayHello();
		
		ApplicationContext context = 
				//new ClassPathXmlApplicationContext("ex01/di/applicationContext.xml");
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//MessageBean bean = (MessageBean)context.getBean("messageBeanImpl");
		//MessageBean bean = (MessageBean)context.getBean("mb");  // 별칭 이름으로도 빈호출 가능
		MessageBean bean = context.getBean("m2", MessageBean.class); 
		bean.sayHello();
	}
}
