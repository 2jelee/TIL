package ex01.Di;

public class MessageBeanImpl implements MessageBean {

	private String name, greeting;
	
	// 1. Constructor << DI
	public MessageBeanImpl() { }
	public MessageBeanImpl(String name, String greeting) {
		super();
		this.name = name;
		this.greeting = greeting;
	}
	 
	// 2. Setter Method << DI
	public void setName(String name) {
		this.name = name;
	} 
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	
	@Override
	public void sayHello() { 
		System.out.println(greeting + " / " + name);
		
	}

}
