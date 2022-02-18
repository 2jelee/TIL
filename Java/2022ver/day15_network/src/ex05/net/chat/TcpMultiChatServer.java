package ex05.net.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;

/*
 * 원래 분리해서 작업해야하나 한 곳에 다 몰아넣었음
 */

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

//outer class
public class TcpMultiChatServer {
	HashMap clients; //key, value  => 닉네임과 메세지를 같이 받기 위해 map type으로 설정
	//socket 1, 2
	ServerSocket ss = null; // 1
	Socket s = null;		// 2
	
	//생성자 함수
	public TcpMultiChatServer() {
		//객체생성
		clients = new HashMap();
		
//		Collection은 interface, Collections는 class
		//동기화 작업
		Collections.synchronizedMap(clients); //map 타입의 clients >> HashMap clients;
	}
	
	//사용자 메소드 => User method
	//해당 메소드는 서버 시작하고 accept 걸어줄 역할로 만들 것.
	public void start() {
		try {
			ss = new ServerSocket(8000);
			System.out.println("---서버가 시작되었습니다. Chat 준비 완료됨---");
			while(true) {
				//응답 대기 상태. 클라이언트 소켓임.
				s = ss.accept(); 
				System.out.println("[ "+s.getInetAddress()+" : " + s.getPort()+" ]에서 접속 시작");
				
				//user class
				ServerReciver thread = new ServerReciver(s);  
				
				//start를 부름으로써 'run() method 유도'됨 => thread가 실행
				thread.start(); 
			}
//		} catch (Exception e) { e.printStackTrace(); }
		} catch (Exception e) { System.out.println("서버 접속 실패!"); }
	}
	
	//user method
	public void sendToAll(String msg) {
		//iterator를 이용하여 key값을 분리 => key값 출력
		Iterator it = clients.keySet().iterator();
		
		while (it.hasNext()) {
			try {
//				DataOutputStream dos = clients.get(it.next()); //error >> DataOutputStream은 String type
				DataOutputStream dos = (DataOutputStream)clients.get(it.next());
				dos.writeUTF(msg);
			} catch (Exception e) { e.printStackTrace(); }
		}
	}
	
	//inner class
	class ServerReciver extends Thread { 
		//client socket
		Socket s;
		DataInputStream dis;
		DataOutputStream dos;
		
		String name = " ";
		
		//매개변수 가진 생성자함수
		public ServerReciver(Socket s) { 
			this.s = s;
			
			try {
				//네트워크를 통해서 읽기
				dis = new DataInputStream(s.getInputStream());
				//네트워크를 통해서 쓰기
				dos = new DataOutputStream(s.getOutputStream());
			} catch (Exception e) {	System.out.println("Server Recive 실패"); }
		}

		//run method 오버라이드 >> run method는 실제 구현부(실행부)
		@Override
		public void run() { //start method에 의해 유도되어야 한다.
			try {
				name = dis.readUTF();
				
				//user method
				sendToAll("#"+name+"님이 입장했습니다.");
				clients.put(name, dos); // MashMap에 넣기
				System.out.println("현재 Server 접속자 수는 " + clients.size()+"명 입니다."); //접속자 수 확인
				
				while(dis != null) {
					sendToAll(dis.readUTF());
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sendToAll("#"+name+"님이 퇴장했습니다.");
				clients.remove(name); //접속자 수 제거
				System.out.println("["+s.getInetAddress()+" : "+s.getPort()+"]에서 접속 종료");
				System.out.println("현재 Server 접속자 수는 " + clients.size()+"명 입니다."); //접속자 수 확인
			}
		}
	}
	
	public static void main(String[] args) {
		new TcpMultiChatServer().start();
	}
}
