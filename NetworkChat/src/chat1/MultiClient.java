package chat1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
 
public class MultiClient {

	public static void main(String[] args) {
		
		//클라이언트는 최초 접속시 대화명을 입력한다.
		System.out.print("이름을 입력하세요:");
		Scanner scanner = new Scanner(System.in);
		String s_name = scanner.nextLine();
		PrintWriter out = null;
		BufferedReader in = null;
		
		try {
			//클라이언트 실행 시 별도의 접속 IP가 없으면 localhost(루프백)으로 고정된다.
			String ServerIP = "localhost"; //localhost >> 127.0.0.1 or 루프백 주소(=내부 아이피 주소)  (JSP에서 많이보게 된다)
			//실행시 매개변수로 IP주소를 전달하면 해당 주소로 설정함
			if(args.length>0) { //상단의 args..
				ServerIP = args[0];
			}
			//IP주소와 포트를 기반으로 Socket객체를 생성하여 서버에 접속요청을 한다.
			Socket socket = new Socket(ServerIP, 9999);
			
			/*
			서버에서 접속을 허가하기 위해 accept()메소드를 실행하면
			클라이언트는 접속하게 된다.
			 */
			System.out.println("서버와 연결되었습니다.");
			
			//MultiServer측과 스트림이 100프로 동일함.
			/*
			바이트스트림과 문자스트림의 상호변환을 제공하는 입출력스트림으로
			바이트를 읽어서 지정된 문자인코딩에 따라 문자로 변환하는데 사용한다.
			여기서는 서버가 보내는 내용을 읽고 서버로 메세지를 보낼 때 사용하는 입출력 스트림이 된다.
			MultiServer 주석과 같은 말임.. (서버 ~ 클라이언트로부터 ~)
			 */
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			//대화명을 서버측으로 출력스트림을 통해 전송
			out.println(s_name);
			//서버가 보내준(Echo 해준) 메세지를 Line단위로 읽어 콘솔에 출력.
			System.out.println("Receive:"+in.readLine());
			
			//스트림, 소켓을 종료하여 자원해제한다.
			in.close();
			out.close();
			socket.close();
		}
		catch (Exception e) {
			System.out.println("예외발생[MultiClient]"+e);
		}
	}
}
