package ex03.net.tcp;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/*
 * 항상 Server가 먼저 준비되어야 한다.
 */

public class ServerTime {
	public static void main(String[] args) {
		int port = 7000;		// 0~1024는 예약되어 있다. (port number)
	
		// Server는 socket 2개 필요
		try {
			System.out.println("---server가 시작되었습니다---");
			ServerSocket ss = new ServerSocket(port);	//socket1  	//port번호 7000번을 가지고 하겠다.
			
			while(true) {
				Socket s = ss.accept();		//socket2
				//accept에서 >> 대기중 ★★★
				
				//socket을 통해 stream을 얻어옴
				OutputStream os = s.getOutputStream(); // network를 통해 출력하겠다.
				
				ObjectOutputStream oos = new ObjectOutputStream(os); // 객체를 생성하여 os를 보내주고
				oos.writeObject(new Date()); //서버측 날짜
				oos.flush(); //통로를 통해 다 보내라
				s.close();
			}
		} catch (Exception e) { 
//			e.printStackTrace(); 와 아래 코드 동일
			System.out.println(e.getMessage());
		}
	}
}
