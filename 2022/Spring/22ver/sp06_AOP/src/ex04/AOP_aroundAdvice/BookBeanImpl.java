package ex04.AOP_aroundAdvice;

public class BookBeanImpl implements iBookBean {

	@Override
	public void testHello(String str) {
		System.out.println("public void testHello(String str) 호출됨 / str : "+ str);
	}

	@Override
	public int korHello() {
		System.out.println("public int korHello() 호출됨");
		return 5;
	}

}
