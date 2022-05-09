package spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Client implements InitializingBean, DisposableBean {

	// default 생성자
	public Client() {
		System.out.println("Client Default Constructor");
	}

	private String defaultHost;
	
	public void setDefaultHost(String defaultHost) {
		this.defaultHost = defaultHost;
		System.out.println("defaultHost : " + defaultHost);
	}
	
	public Client(String defaultHost) {
		this.defaultHost = defaultHost;
		System.out.println("Client 생성자 : " +this.defaultHost); 
	}
	
	private String host;
	
	public void setHost(String host) {
		this.host = host;
		System.out.println("setHost : " + host);
	}
	
	// 초기화 메서드(이벤트를 내부적으로 가지고 자동 호출: 호출 시점)
	// InitializingBean에 대한 구현부 
	// afterPropertiesSet : property (set method에 inject이 된 후에 실행)
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Client.afterPropertiesSet() 실행");
	}
	
	// JavaConfig.java의 초기화 메소드가 된다. 
//	public void connect() throws Exception{
//		System.out.println("Client.connect() 실행");
//	}
	
	// <property name="host" value="서버" /> 역할해줌 
	public void send() {
		System.out.println("Client.send() to : "+ host);
	}

	// 소멸 메서드(이벤트를 내부적으로 가지고 자동 호출 : 호출 시점)
	// DisposableBean에 대한 구현
	@Override
	public void destroy() throws Exception {
		System.out.println("Client.destroy() 실행");
	}

	
}
