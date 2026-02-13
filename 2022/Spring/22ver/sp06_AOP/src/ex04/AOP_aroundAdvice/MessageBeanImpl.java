package ex04.AOP_aroundAdvice;

public class MessageBeanImpl implements iMessageBean {

	@Override
	public void sayHello() {
		System.out.println("public void sayHello() 호출됨");
	}

	@Override
	public void engHello() {
		System.out.println("public void engHello() 호출됨");
	
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
