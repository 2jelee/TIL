package ex04.Di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ex04/Di/applicationContext.xml"); 
		
		// getBean 은 return type이 Object다. => 형변환 필요 
		NewRecordViewImpl view = (NewRecordViewImpl)context.getBean("view");
		view.print();
	}
}
