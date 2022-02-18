package ex05.net.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpMultiChatClient {
	public static void main(String[] args) {

//		Thread send = new Thread(socket, args[0]);
		if(args.length != 1) {
			System.out.println("USAGE : java TcpMultiChatClient Nickname"); //닉네임이 없다. => 가져온게 없다?
			System.exit(0); //빠져나가겠다.
		}
		
		try {
			String ip = "192.168.0.19";
			Socket socket = new Socket(ip, 8000);		//하는 순간 accept 메소드에 접근
			System.out.println("---Server에 연결되었습니다---");
			
			//socket과 닉네임을 담아서 보내겠다.
//			Thread send = new Thread(socket, args[0]);
			Thread send = new Thread(new ClientSender(socket, args[0]));	//error >>  ClientSender -> inner class 생성
//			Thread send = new Thread(args[0]);
//			System.out.println(args[0]);
			
			Thread receiver = new Thread(new ClientReceiver(socket)); 		//error >>  ClientReceiver -> inner class 생성
			
			//run 유도
			send.start(); 
			receiver.start();
			
		} catch (Exception e) { e.printStackTrace(); }
	}
	
	//inner class
	static class ClientSender extends Thread {
		
		Socket socket;
		DataOutputStream dos;
		String name;	//이름(닉네임)을 받아줄 변수
		
		//생성자함수 추가
		public ClientSender(Socket socket, String name) {	//매개변수 2개 생성자함수
			this.dos = dos;
			try {
				dos = new DataOutputStream(socket.getOutputStream());
				this.name = name;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() { 
			//System.in >> 표준입력 (키보드로 입력받을 예정이므로)
			Scanner sc = new Scanner(System.in); 
			
			try {
				if(dos != null) {
					dos.writeUTF(name);
					
					while(dos!=null) {
						dos.writeUTF("["+name+"] " + sc.nextLine());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		
	}

	//inner class
	static class ClientReceiver extends Thread {
		Socket socket;
		DataInputStream dis;
		
		//생성자함수 추가
		public ClientReceiver(Socket socket) { 
			this.socket = socket; //setting 작업
			
			try {
				dis = new DataInputStream(socket.getInputStream()); //통로 생성
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() { 
			//읽을 것이 없다면
			while(dis!=null) {
				try {
					System.out.println(dis.readUTF());
				} catch (Exception e) { e.printStackTrace(); }
			}
		}
	}
}
