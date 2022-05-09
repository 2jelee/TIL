package spring;

// Client.java와 달리 implements 하지 않았다. 
public class Client2 {

	private String host;
	
	public void setHost(String host) {
		this.host = host;
		System.out.println("Client2.setHost() call : " + host);
	}
	
	public void connect() throws Exception{
		System.out.println("Client.connect() 실행 - 초기화 메소드");
	}
	
	public void send() {
		System.out.println("Client2.send() to : " + host);
	}
	
	public void close() throws Exception {
		System.out.println("Client2.close() 실행 - 소멸 메소드");
	}
}
