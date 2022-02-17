package ex03.net.tcp;
 
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Date;

/*
 * Server측에서 시간을 받아옴
 * 항상 server를 먼저 실행하자!
 */
public class ClientTime {
	public static void main(String[] args) {
//		Socket s = null;	//error
		String serverIP = "192.168.0.19";
		int port = 7000;
		Date date = null;
		
		try {
			/*
			s = new Socket("192.168.0.19", 7000);	//port번호 7000번
			// I/O객체
			
			//읽어들이겠다
			InputStream is = s.getInputStream(); //read
			OutputStream os = s.getOutputStream();
			
			String str = "Server, Hi!";
			os.write(str.getBytes()); //str이 가지고 있는 byte만큼 써줘
			
			byte[] buffer = new byte[100];
			is.read(buffer);
			System.out.println(new String(buffer));
			*/														//error
			
			Socket client = new Socket(serverIP, port);
			InputStream is = client.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			System.out.println("Server측 날짜/시간 확인. 여기는 Client입니다.");
			
			date = (Date)ois.readObject();
			System.out.println("현재시간 : " + date + "입니다.");
			ois.close();
			client.close();
			
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
}
