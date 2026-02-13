package ex03.net.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 항상 Server가 먼저 준비되어야 한다.
 */

public class ServerTest {
	public static void main(String[] args) {
		ServerSocket ss = null;
		Socket s = null;
		System.out.println("---server test가 시작되었습니다---");
	 
		try {
			ss = new ServerSocket(9000);	 
			s = ss.accept();
			// I/O
			InputStream is = s.getInputStream(); //read
			OutputStream os = s.getOutputStream();
			
			byte[] arr = new byte[100];
			is.read(arr);
			System.out.println(new String(arr));
			String msg = "[Server] 안녕하세요. 이것은 ServerTest";
			os.write(msg.getBytes());
			
		} catch (Exception e) { 
			System.out.println(e.getMessage());
		} finally {
			try {
				s.close();
				ss.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
