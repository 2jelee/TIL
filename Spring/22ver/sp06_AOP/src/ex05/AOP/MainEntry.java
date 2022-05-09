package ex05.AOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("classpath:ex05/AOP/appCtx.xml");
		
		iCalc proxyCalc = (iCalc)context.getBean("proxy"); // xml의 id값인 proxy 부르기
		System.out.println(proxyCalc.add(22, 33));
	}
}
