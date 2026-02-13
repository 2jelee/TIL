package ex03.net.tcp;  

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket; 

/* 
 * 항상 server를 먼저 실행하자!
 */
public class ClientTest {
	public static void main(String[] args) {
		Socket s = null;	 
		
		try { 						 
			s = new Socket("127.0.0.1", 9000); 
			
			// I/O
			InputStream is = s.getInputStream(); //read
			OutputStream os = s.getOutputStream();
			
			String str = "[Client] Server, Hi!";
			os.write(str.getBytes("utf-8"));  //UTF-8
			
			byte[] buffer = new byte[100];
			is.read(buffer);
			System.out.println(new String(buffer));
			
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally {
			try {
				s.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
