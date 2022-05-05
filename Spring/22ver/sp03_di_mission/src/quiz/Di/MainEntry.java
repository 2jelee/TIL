package quiz.Di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("quiz.Di.playerCtx.xml");
		Player player = context.getBean("curling", Curling.class);
	 	player.info();
	
		// 컬링, 축구, 농구 
//		player = ctx.getBean("soccer", Soccer.class);
//		player = ctx.getBean("soccer", Soccer.class);
//		player = ctx.getBean("soccer", Soccer.class);
		
	}
}
