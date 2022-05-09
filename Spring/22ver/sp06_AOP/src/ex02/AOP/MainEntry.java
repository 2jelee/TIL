package ex02.AOP;

import java.lang.reflect.Proxy;

public class MainEntry {
	public static void main(String[] args) {
		iCalc ic = new CalcImpl();
		// Proxy.newProxyInstance는 Object 타입이므로 형변환 필요 
		iCalc proxy = (iCalc)Proxy.newProxyInstance(
														ic.getClass().getClassLoader(), // loader : 클래스 찾 
														ic.getClass().getInterfaces(), // interfaces : 행위(함수)
														new LogPrintHandlerImpl(ic) // handler : 보조업무 구현 
													);
		
		// Class를 통해서 실행
		System.out.println(ic.add(1, 2));
		System.out.println(ic.mul(10, 30));
		
		System.out.println("-----------------");
		
		// Proxy를 통해서 실행 - 이들은 Log까지 나와야 한다. 
		System.out.println(proxy.add(5, 5));
		System.out.println(proxy.mul(3, 9));
	}
}
